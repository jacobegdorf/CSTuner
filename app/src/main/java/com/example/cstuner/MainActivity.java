package com.example.cstuner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.AudioRecord;
import android.widget.Toast;

import org.w3c.dom.Text;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.util.PitchConverter;

public class MainActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    AudioDispatcher listener = AudioDispatcherFactory.fromDefaultMicrophone(44100, 8192, 2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView frequencyDisplay = findViewById(R.id.frequency);
        final ImageView noteDisplay = findViewById(R.id.noteName);
        final ImageView noteSharpDisplay = findViewById(R.id.noteSharp);
        final ImageView noteOctaveDisplay = findViewById(R.id.noteOctave);
        final TextView frequencyDistanceDisplay = findViewById(R.id.frequencyDistance);
        PitchDetectionHandler pitch = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult pitchResult, AudioEvent audioEvent) {
                final double frequency = ((int) (pitchResult.getPitch() * 1000.0)) / 1000.0;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String display = frequency + " Hz";
                        frequencyDisplay.setText(display);
                        int midi = PitchConverter.hertzToMidiKey((double) Math.round(frequency));
                        double midiCent = PitchConverter.hertzToMidiCent(frequency);
                        if (midi == 48) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(48, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 49) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(49, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 50) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(50, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 51) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(51, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                    }
                });
            }
        };
        AudioProcessor pitchProcess = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 44100, 8192, pitch);
        listener.addAudioProcessor(pitchProcess);
        Thread audio = new Thread(listener, "Audio");
        audio.start();
    }
    public double distanceFromNote(int midiNote, double cents) {
        double difference = cents - midiNote;
        double multiplied = (int) (difference * 100);
        return multiplied;
    }
}
