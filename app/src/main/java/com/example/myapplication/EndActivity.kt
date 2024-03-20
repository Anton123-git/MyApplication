package com.example.myapplication
import CreatActivity
import android.content.Intent
import android.os.Bundle
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
    }
}