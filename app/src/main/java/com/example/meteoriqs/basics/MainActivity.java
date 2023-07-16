package com.example.meteoriqs.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    TextView welcomeText;
    EditText editText;
    TextView editBoxLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submitBtn);
        submitButton.setOnClickListener(this);
        submitButton.setOnLongClickListener(this);

        welcomeText = findViewById(R.id.welcomeText);
        editText = findViewById(R.id.editText);
        editBoxLabel = findViewById(R.id.editBoxLabel);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submitBtn) {
//            Toast.makeText(this, "Button has been clicked !", Toast.LENGTH_SHORT).show();
            editBoxLabel.setText(editText.getText().toString());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.submitBtn) {
            System.out.println("Button clicked !!!");
            Toast.makeText(MainActivity.this, "Button Long click done !", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}