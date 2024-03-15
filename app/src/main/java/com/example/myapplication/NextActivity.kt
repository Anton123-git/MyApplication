package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val nextButton2 = findViewById<AppCompatButton>(R.id.next_button2)
        nextButton2.setOnClickListener {
            val intent2 = Intent(this, EndActivity::class.java)
            startActivity(intent2)
        }

    }
}