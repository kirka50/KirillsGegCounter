package com.example.praktika3

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0
    private var colorful: Boolean = true
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonCounter = findViewById<Button>(R.id.button_count)
        val textView = findViewById<TextView>(R.id.textView)
        buttonCounter.setOnClickListener(){
            textView.text = "Кнопка нажата ${++counter} раз"
        }
        imageView.setOnClickListener(){
            colorful = if (colorful) {
                textView.setTextColor(Color.BLACK)
                !colorful
            } else {
                textView.setTextColor(Color.BLUE)
                !colorful
            }

        }
    }
}



