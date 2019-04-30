package com.example.cstuner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.media.AudioRecord;
import android.widget.Toast;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class MainActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    AudioDispatcher listener = AudioDispatcherFactory.fromDefaultMicrophone(44100, 8192, 2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView frequencyDisplay = findViewById(R.id.frequency);
        PitchDetectionHandler pitch = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult pitchResult, AudioEvent audioEvent) {
                final float frequency = pitchResult.getPitch();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String display = frequency + "Hz";
                        frequencyDisplay.setText(display);
                    }
                });
            }
        };
        AudioProcessor pitchProcess = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 44100, 8192, pitch);
        listener.addAudioProcessor(pitchProcess);
        Thread audio = new Thread(listener, "Audio");
        audio.start();
    }
}
