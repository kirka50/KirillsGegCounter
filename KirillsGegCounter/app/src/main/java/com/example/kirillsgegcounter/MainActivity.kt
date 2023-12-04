package com.example.kirillsgegcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var gegs: Int = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<TextView>(R.id.textView)
        view.text = gegs.toString()
        findViewById<Button>(R.id.button)
            .setOnClickListener {
                Log.d("BUTTONS", "click")
                incraseCount(view)
            }

    }
    fun incraseCount(view: TextView) {
        this.gegs = this.gegs + 1
        Log.d("wtf", this.gegs.toFloat().toString())
        view.text = this.gegs.toString()
    }
}