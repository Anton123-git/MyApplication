package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class NextActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val nextButton1 = findViewById<AppCompatButton>(R.id.next_button2)
        nextButton1.setOnClickListener {
            val intent1 = Intent(this, EndActivity::class.java)
            startActivity(intent1)
        }

        val nextButtonSk = findViewById<AppCompatButton>(R.id.next_button5)
        nextButtonSk.setOnClickListener {
            val intentSk = Intent(this, EndActivity::class.java)
            startActivity(intentSk)
        }

    }
}