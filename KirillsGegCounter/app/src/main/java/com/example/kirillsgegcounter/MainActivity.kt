package com.example.kirillsgegcounter

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    var gegs: Int = 0
    private val database = Firebase.database
    private val myRef = database.getReference("gegs")

    companion object {
        private const val TAG = "KotlinActivity"
    }
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
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<Int>()
                Log.d(TAG, "Value is: $value")
                if (value != null) {
                    gegs = value
                    view.setText(gegs.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
    fun incraseCount(view: TextView) {
        this.gegs = this.gegs + 1
        Log.d("wtf", this.gegs.toFloat().toString())
        view.text = this.gegs.toString()
        myRef.setValue(gegs)
    }
    fun refresgGegs(Gegs: Int) {
        this.gegs = Gegs.toInt()
    }


}