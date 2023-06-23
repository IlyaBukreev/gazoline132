package com.example.gazoline

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var priceRadioGroup: RadioGroup
    private lateinit var editText: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        priceRadioGroup = findViewById(R.id.priceRadioGroup)
        editText = findViewById(R.id.editText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val selectedRadioButton = findViewById<RadioButton>(priceRadioGroup.checkedRadioButtonId)
            val enteredAmount = editText.text.toString().toDouble()
            var firstTwoDigits = ""

            when (selectedRadioButton.id) {
                R.id.radio92 -> firstTwoDigits = "50"
                R.id.radio95 -> firstTwoDigits = "55"
                R.id.radio98 -> firstTwoDigits = "57"
            }

            val multipliedAmount = enteredAmount * firstTwoDigits.toDouble()

            val message = "Сумма бензина: $multipliedAmount"
            showToast(message)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
