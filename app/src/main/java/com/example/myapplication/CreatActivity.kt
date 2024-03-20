import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.R

class CreatActivity : AppCompatActivity() {

    private lateinit var checkBox: CheckBox
    private lateinit var nextButton: Button
    private lateinit var eTextName: EditText
    private lateinit var eTextPhone: EditText
    private lateinit var eTextMail: EditText
    private lateinit var eTextPassword: EditText
    private lateinit var eTextConPassword: EditText


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
        eTextName = findViewById(R.id.eTextName)
        eTextPhone = findViewById(R.id.eTextPhone)
        eTextMail = findViewById(R.id.eTextMail)
        eTextPassword = findViewById(R.id.eTextPassword)
        eTextConPassword = findViewById(R.id.eTextConPassword)

 // инициализируем поле ввода

        // Установка слушателя изменения состояния чекбокса
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            // Включение или выключение кнопки в зависимости от состояния чекбокса и заполненности всех полей ввода
            nextButton.isEnabled = isChecked && isAllFieldsValid()
            // Изменение цвета кнопки в зависимости от состояния чекбокса
            if (isChecked) {
                nextButton.setBackgroundResource(R.drawable.rounded_button_blue)
            } else {
                nextButton.setBackgroundResource(R.drawable.rounded_button_gray)
            }
        }

        // Установка слушателя изменения текста в полях ввода
        eTextName.addTextChangedListener {
            nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        }
        eTextPhone.addTextChangedListener {
            nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        }
        eTextMail.addTextChangedListener {
            nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        }
        eTextPassword.addTextChangedListener {
            nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        }
        eTextConPassword.addTextChangedListener {
            nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        }


        // добавляем аналогичные слушатели для остальных полей ввода

        // Устанавливаем кнопке начальное состояние в зависимости от состояния чекбокса и заполненности всех полей ввода
        nextButton.isEnabled = checkBox.isChecked && isAllFieldsValid()
        // Устанавливаем начальный цвет кнопки в зависимости от начального состояния чекбокса
        if (checkBox.isChecked) {
            nextButton.setBackgroundResource(R.drawable.rounded_button_blue)
        } else {
            nextButton.setBackgroundResource(R.drawable.rounded_button_gray)
        }
    }

    // Функция для проверки заполненности всех полей ввода
    private fun isAllFieldsValid(): Boolean {
        val name = eTextName.text.toString().trim()
        val phone = eTextPhone.text.toString().trim()
        val email = eTextMail.text.toString().trim()
        val pass = eTextPassword.text.toString().trim()
        val conPass = eTextConPassword.text.toString().trim()

        // проверяем остальные поля ввода
        // вернем true только если все поля ввода заполнены
        return !TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(conPass)// && остальные проверки
    }
}
