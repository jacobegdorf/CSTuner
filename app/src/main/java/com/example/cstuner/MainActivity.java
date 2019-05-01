package com.example.cstuner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.util.PitchConverter;

public class MainActivity extends AppCompatActivity {
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
                        if (midi == 45) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(45, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 46) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(46, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 47) {
                            noteDisplay.setImageResource(R.drawable.b);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(47, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
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
                        if (midi == 52) {
                            noteDisplay.setImageResource(R.drawable.e);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(52, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 53) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(53, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 54) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(54, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 55) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(55, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 56) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.three);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(56, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 57) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(57, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 58) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(58, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 59) {
                            noteDisplay.setImageResource(R.drawable.b);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(59, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 60) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(60, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 61) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(61, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 62) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(62, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 63) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(63, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 64) {
                            noteDisplay.setImageResource(R.drawable.e);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(64, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 65) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(65, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 66) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(66, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 67) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(67, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 68) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.four);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(68, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 69) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(69, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 70) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(70, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 71) {
                            noteDisplay.setImageResource(R.drawable.b);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(71, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 72) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(72, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 73) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(73, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 74) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(74, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 75) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(75, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 76) {
                            noteDisplay.setImageResource(R.drawable.e);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(76, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 77) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(77, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 78) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(78, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 79) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(79, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 80) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.five);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(80, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 81) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(81, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 82) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(82, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 83) {
                            noteDisplay.setImageResource(R.drawable.b);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(83, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 84) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(84, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 85) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(85, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 86) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(86, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 87) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(87, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 88) {
                            noteDisplay.setImageResource(R.drawable.e);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(88, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 89) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(89, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 90) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(90, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 91) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(91, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 92) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.six);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(92, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 93) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(93, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 94) {
                            noteDisplay.setImageResource(R.drawable.a);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(94, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 95) {
                            noteDisplay.setImageResource(R.drawable.b);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(95, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 96) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(96, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 97) {
                            noteDisplay.setImageResource(R.drawable.c);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(97, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 98) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(98, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 99) {
                            noteDisplay.setImageResource(R.drawable.d);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(99, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 100) {
                            noteDisplay.setImageResource(R.drawable.e);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(100, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 101) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(101, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 102) {
                            noteDisplay.setImageResource(R.drawable.f);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(102, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 103) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.INVISIBLE);
                            String distanceDisplay = distanceFromNote(103, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                        if (midi == 104) {
                            noteDisplay.setImageResource(R.drawable.g);
                            noteOctaveDisplay.setImageResource(R.drawable.seven);
                            noteSharpDisplay.setVisibility(View.VISIBLE);
                            String distanceDisplay = distanceFromNote(104, midiCent) + " cents";
                            frequencyDistanceDisplay.setText(distanceDisplay);
                        }
                    }
                });
            }
        };
        int audioPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (audioPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        } else {
            AudioDispatcher listener = AudioDispatcherFactory.fromDefaultMicrophone(44100, 8192, 2);
            AudioProcessor pitchProcess = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 44100, 8192, pitch);
            listener.addAudioProcessor(pitchProcess);
            Thread audio = new Thread(listener, "Audio");
            audio.start();
        }
    }
    public double distanceFromNote(int midiNote, double cents) {
        double difference = cents - midiNote;
        double multiplied = (int) (difference * 100);
        return multiplied;
    }
}
