package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class battery : AppCompatActivity() {
    lateinit var tv: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery)

        val t = findViewById<EditText>(R.id.tv)
        val q= findViewById<Button>(R.id.button5)

        q.setOnClickListener{
            val a =t.text.toString()
            val z = Intent(this,wifi::class.java)
            z.putExtra("a",a)
            System.out.println(a)
            startActivity(z)
        }
    }
}