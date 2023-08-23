package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class custom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)


        val t = findViewById<EditText>(R.id.editTextText)
        val q= findViewById<Button>(R.id.button3)

        q.setOnClickListener {
            val a =t.text.toString()
            val z = Intent(this,wifi::class.java)
            z.putExtra("hh",a)
            System.out.println(a)
            startActivity(z)
        }
    }
}