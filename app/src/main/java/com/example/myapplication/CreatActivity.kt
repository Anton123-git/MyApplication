package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

@Suppress("DEPRECATION")
class CreatActivity : AppCompatActivity() {

    private lateinit var checkBox: CheckBox
    private lateinit var nextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creat)

        val textView = findViewById<TextView>(R.id.textView11)
        val text = "By ticking this box, you agree to our Terms and \nconditions and private policy"

        val spannable = SpannableString(text)
        val yellowColor = Color.parseColor("#FFCF48")

        val halfTextLength = 38

        spannable.setSpan(ForegroundColorSpan(yellowColor), halfTextLength, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannable


        checkBox = findViewById(R.id.ChekBox)
        nextButton = findViewById(R.id.next_buttonCreat)

        // Установка слушателя изменения состояния чекбокса
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            // Включение или выключение кнопки в зависимости от состояния чекбокса
            nextButton.isEnabled = isChecked
            // Изменение цвета кнопки в зависимости от состояния чекбокса
            if (isChecked) {
                nextButton.setBackgroundColor(resources.getColor(R.color.enabled_button_color))
            } else {
                nextButton.setBackgroundColor(resources.getColor(R.color.disabled_button_color))
            }

        }

        // Устанавливаем кнопке начальное состояние в зависимости от состояния чекбокса
        nextButton.isEnabled = checkBox.isChecked
        // Устанавливаем начальный цвет кнопки в зависимости от начального состояния чекбокса
        if (checkBox.isChecked) {
            nextButton.setBackgroundColor(resources.getColor(R.color.enabled_button_color))
        } else {
            nextButton.setBackgroundColor(resources.getColor(R.color.disabled_button_color))
        }
    }
}