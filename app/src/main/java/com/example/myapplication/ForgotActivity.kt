package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ForgotActivity : AppCompatActivity() {

    private lateinit var eAddressMail: EditText
    private lateinit var next_buttonForgot: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val textViewEnd = findViewById<TextView>(R.id.textViewForgot)
        textViewEnd.setOnClickListener {
            // Создаем Intent для перехода на LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            // Запускаем LoginActivity
            startActivity(intent)
        }

        eAddressMail = findViewById(R.id.eAddressMail)
        next_buttonForgot = findViewById(R.id.next_buttonForgot)

        eAddressMail.addTextChangedListener(textWatcher)

        next_buttonForgot.isEnabled = false




    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // Вызываем функцию проверки всех полей на заполненность и устанавливаем состояние кнопки
            checkFieldsForEmpty()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun checkFieldsForEmpty() {
        // Проверяем оба поля на заполненность
        val emailText = eAddressMail.text.toString().trim()

        // Если оба поля заполнены, делаем кнопку активной и меняем её цвет на синий
        if (emailText.isNotEmpty()){
            next_buttonForgot.isEnabled = true
            next_buttonForgot.setBackgroundResource(R.drawable.rounded_button_blue)
        } else {
            // Если какое-то поле пустое, делаем кнопку серой и неактивной
            next_buttonForgot.isEnabled = false
            next_buttonForgot.setBackgroundResource(R.drawable.rounded_button_gray)
        }
    }
}