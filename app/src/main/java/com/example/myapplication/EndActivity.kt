package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val nextButtonE = findViewById<AppCompatButton>(R.id.next_buttonEnd)
        nextButtonE.setOnClickListener {
            val intentE = Intent(this, CreatActivity::class.java)
            startActivity(intentE)
        }

        val textViewEnd = findViewById<TextView>(R.id.textViewEnd)
        textViewEnd.setOnClickListener {
            // Создаем Intent для перехода на LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            // Запускаем LoginActivity
            startActivity(intent)
        }
    }
}