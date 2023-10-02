package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        var imageButton : ImageButton = findViewById(R.id.imageButton)
        var editText: EditText = findViewById(R.id.editTextTextPersonName)
        var switch: Switch = findViewById(R.id.switch1)
        imageButton.setOnClickListener{
            if (!switch.isChecked) {
                if (editText.text.isEmpty()) {
                    textView.text = "Hello, friend";
                } else {
                    textView.text = "Hello, " + editText.text
                }

            } else {
                if (editText.text.isEmpty()) {
                    textView.text = "Привет мой грустный друг";
                } else {
                    textView.text = "Чё такой грустный, " + editText.text
                }
            }
        }
    }
}
