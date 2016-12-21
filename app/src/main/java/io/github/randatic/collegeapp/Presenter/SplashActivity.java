package io.github.randatic.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import io.github.randatic.collegeapp.R;

public class SplashActivity extends AppCompatActivity {

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                endSplashScreen();
            }
        };

        timer.start();
    }

    private void endSplashScreen() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
