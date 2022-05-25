package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String[] Questions = {"In Java strings are immutable?", "Java is introduced in 1823?", "JAVA is a person?", "Java is built in python?"};
    private boolean[] answers = {true, false, false, false};
    private int score = 0;
    private int index = 0;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textView2.setText(Questions[0]);
        binding.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answers[index]) {
                    score += 5;
                    binding.textView3.setText(score + "");
                    // Toast.makeText(getApplicationContext(), "TRUE", Toast.LENGTH_SHORT).show();

                }
                if (index == Questions.length - 1) {
                    binding.textView3.setText(score + "");
                } else {
                    binding.textView2.setText(Questions[++index]);
                }
            }
        });
        binding.NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answers[index]) {
                    score += 5;
                    binding.textView3.setText(score + "");
                    //Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
                }
                if (index + 1 == Questions.length) {
                    binding.textView3.setText(score + "");
                } else {
                    binding.textView2.setText(Questions[++index]);
                }
            }
        });
    }
}