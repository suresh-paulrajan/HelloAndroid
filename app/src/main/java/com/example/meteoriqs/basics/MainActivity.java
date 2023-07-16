package com.example.meteoriqs.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private CheckBox checkHP, checkMI, checkFF;
    private RadioGroup radioMaritalStatus;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkHP = findViewById(R.id.checkBoxHP);
        checkMI = findViewById(R.id.checkBoxMI);
        checkFF = findViewById(R.id.checkBoxFF);

        radioMaritalStatus = findViewById(R.id.radioGroupMaritalStatus);

        checkHP.setOnCheckedChangeListener(this);
        checkMI.setOnCheckedChangeListener(this);
        checkFF.setOnCheckedChangeListener(this);

        radioMaritalStatus.setOnCheckedChangeListener(this);

        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId() == R.id.checkBoxHP ) {
            if (b) {
                Toast.makeText(this, "Potterhead !", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Muggle !", Toast.LENGTH_SHORT).show();
            }
        }
        if (compoundButton.getId() == R.id.checkBoxMI ) {
            if (b) {
                Toast.makeText(this, "Ethan Hunt has your back !", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Accept the mission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == R.id.radioMarried)
            Toast.makeText(this, "Married", Toast.LENGTH_SHORT).show();
        else if(i == R.id.radioUnMarried) {
            Toast.makeText(this, "UnMarried", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }
        else
            Toast.makeText(this, "Separated", Toast.LENGTH_SHORT).show();
    }
}