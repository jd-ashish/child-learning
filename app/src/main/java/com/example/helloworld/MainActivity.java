package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.example.helloworld.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        textToSpeech.setLanguage(Locale.UK);


        ClickMethod();
    }

    private void ClickMethod() {
        binding.one.setOnClickListener(v -> speech("1",R.drawable.one,R.color.one));
        binding.two.setOnClickListener(v -> speech("2", R.drawable.two, R.color.two));
        binding.three.setOnClickListener(v -> speech("3", R.drawable.three, R.color.three));
        binding.four.setOnClickListener(v -> speech("4", R.drawable.foure, R.color.four));
        binding.five.setOnClickListener(v -> speech("5", R.drawable.five, R.color.five));
        binding.six.setOnClickListener(v -> speech("6", R.drawable.six, R.color.six));
        binding.seven.setOnClickListener(v -> speech("7", R.drawable.seven, R.color.seven));
        binding.eight.setOnClickListener(v -> speech("8", R.drawable.eight, R.color.eight));
        binding.nine.setOnClickListener(v -> speech("9", R.drawable.nine, R.color.nine));
        binding.zero.setOnClickListener(v -> speech("zero", R.drawable.zero, R.color.zero));
        binding.clear.setOnClickListener(v -> {
            textToSpeech.speak("clear",TextToSpeech.SUCCESS,null);
            binding.result.setImageDrawable(null);
        });
        binding.exit.setOnClickListener(v -> {
            textToSpeech.speak("exit",TextToSpeech.SUCCESS,null);
            finish();
            System.exit(0);
        });

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void speech(String s, int img, int color) {
        textToSpeech.speak(s,TextToSpeech.SUCCESS,null);
        binding.result.setImageDrawable(getDrawable(img));
        binding.result.setColorFilter(ContextCompat.getColor(this, color), android.graphics.PorterDuff.Mode.MULTIPLY);



    }
}