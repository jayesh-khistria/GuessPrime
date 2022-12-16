package com.example.guessprime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnCheck;
    private int inputNumber;
    private boolean isPrimeNumber = true;
    private TextView tv_check;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);
        btnCheck = findViewById(R.id.btn_check);
        tv_check = findViewById(R.id.tv_check);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(etInput.getText().toString().trim() != null && etInput.getText().toString().trim().length() > 0)) {
                    etInput.setError("Please enter the number");

                } else {
                    inputNumber = Integer.parseInt(etInput.getText().toString());
                    for (int i = 2; i <= inputNumber / 2; i++) {
                        if (inputNumber % i == 0) {
                            isPrimeNumber = false;
                            break;
                        }
                    }

                    if (isPrimeNumber) {
                        tv_check.setText("The given number " + inputNumber + " is a prime number");
                    } else {
                        tv_check.setText("The given number " + inputNumber + " is not a prime number");
                    }
                    isPrimeNumber = true;
                }
            }
        });

    }

}
