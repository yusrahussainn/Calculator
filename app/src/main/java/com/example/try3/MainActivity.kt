package com.example.try3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var counterText: TextView
    private var currentNumber = ""
    private var operator = ""
    private var firstNumber = 0.0
    private var secondNumber = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.counterText)

        val buttons = listOf(
            R.id.pressMeButton0, R.id.pressMeButton1, R.id.pressMeButton2, R.id.pressMeButton3,
            R.id.pressMeButton4, R.id.pressMeButton5, R.id.pressMeButton6, R.id.pressMeButton7,
            R.id.pressMeButton8, R.id.pressMeButton9
        )

        for (button in buttons) {
            findViewById<Button>(button).setOnClickListener {
                appendNumber((it as Button).text.toString())
            }
        }

        findViewById<Button>(R.id.pressMeButton10).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.pressMeButton11).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.pressMeButton12).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.pressMeButton13).setOnClickListener { setOperator("/") }
        findViewById<Button>(R.id.pressMeButton14).setOnClickListener { calculate() }
        findViewById<Button>(R.id.pressMeButton15).setOnClickListener { clear() }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        counterText.text = currentNumber
    }

    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber.toDouble()
            operator = op
            currentNumber = ""
        }
    }

    private fun calculate() {
        if (currentNumber.isNotEmpty()) {
            secondNumber = currentNumber.toDouble()
            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
            counterText.text = result.toString()
            currentNumber = result.toString()
        }
    }

    private fun clear() {
        currentNumber = ""
        operator = ""
        firstNumber = 0.0
        secondNumber = 0.0
        counterText.text = "0"
    }
}
