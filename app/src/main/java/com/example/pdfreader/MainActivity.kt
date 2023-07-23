package com.example.pdfreader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.Browse_btn)
        val image : ImageView = findViewById(R.id.Logo)
        val txt : TextView = findViewById(R.id.textView2)

        btn.setOnClickListener(){   //To perform action when button is pressed

            var i = Intent(this, Preview_Activity::class.java)      //To move to next activity
            startActivity(i)
        }

    }

}