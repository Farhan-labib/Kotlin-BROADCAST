package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val s= findViewById<Button>(R.id.button)
    s.setOnClickListener{
        val intent = Intent(this,custom::class.java)
        startActivity(intent)}

        val p= findViewById<Button>(R.id.button4)
        p.setOnClickListener{
            val i = Intent(this,battery::class.java)
            startActivity(i)
    }


        val q= findViewById<Button>(R.id.button2)
        q.setOnClickListener{
            val z = Intent(this,wifi::class.java)
            startActivity(z)
        }


    }
}