package com.example.temperatureconverter;

import static android.os.Build.VERSION_CODES.R;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextTemperature;
    RadioGroup radioGroupUnits;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        radioGroupUnits = findViewById(R.id.radioGroupUnits);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void convertTemperature(View view) {
        String input = editTextTemperature.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Enter a temperature", Toast.LENGTH_SHORT).show();
            return;
        }

        double temperature = Double.parseDouble(input);
        double result;

        int selectedId = radioGroupUnits.getCheckedRadioButtonId();
        if (selectedId == R.id.radioButtonCelsius) {
            result = (temperature - 32) * 5 / 9; // Fahrenheit to Celsius
        } else {
            result = (temperature * 9 / 5) + 32; // Celsius to Fahrenheit
        }

        textViewResult.setText("Result: " + result);
}
}