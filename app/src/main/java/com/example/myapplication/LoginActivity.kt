package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var eAddressEmail: EditText
    private lateinit var ePassword: EditText
    private lateinit var nextButtonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textViewEnd = findViewById<TextView>(R.id.textViewLogin)
        textViewEnd.setOnClickListener {
            // Создаем Intent для перехода на LoginActivity
            val intent = Intent(this, CreatActivity::class.java)
            // Запускаем LoginActivity
            startActivity(intent)
        }

        val textViewEnd2 = findViewById<TextView>(R.id.Forgot)
        textViewEnd2.setOnClickListener {
            // Создаем Intent для перехода на LoginActivity
            val intent = Intent(this, ForgotActivity::class.java)
            // Запускаем LoginActivity
            startActivity(intent)
        }

        // Инициализируем view-элементы
        eAddressEmail = findViewById(R.id.eAddressEmail)
        ePassword = findViewById(R.id.ePassword)
        nextButtonLogin = findViewById(R.id.next_buttonLogin)

        // Устанавливаем слушатель изменения текста для полей ввода
        eAddressEmail.addTextChangedListener(textWatcher)
        ePassword.addTextChangedListener(textWatcher)

        // Начальное состояние кнопки - серая и неактивная
        nextButtonLogin.isEnabled = false

        // Установка слушателя кликов на кнопку

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
        val emailText = eAddressEmail.text.toString().trim()
        val passwordText = ePassword.text.toString().trim()

        // Если оба поля заполнены, делаем кнопку активной и меняем её цвет на синий
        if (emailText.isNotEmpty() && passwordText.isNotEmpty()) {
            nextButtonLogin.isEnabled = true
            nextButtonLogin.setBackgroundResource(R.drawable.rounded_button_blue)
        } else {
            // Если какое-то поле пустое, делаем кнопку серой и неактивной
            nextButtonLogin.isEnabled = false
            nextButtonLogin.setBackgroundResource(R.drawable.rounded_button_gray)
        }
    }
}