package com.example.arsen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.widget.Button

class MainActivity : ComponentActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val buttons = listOf(
            R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six,
            R.id.seven, R.id.eight, R.id.nine, R.id.zero,
            R.id.plus, R.id.minus, R.id.multi, R.id.divide, R.id.modulo, R.id.coma
        )

        buttons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener { buttonClicked(it) }
        }

        findViewById<Button>(R.id.C).setOnClickListener { clearTextView() }
        findViewById<Button>(R.id.button6).setOnClickListener { calculateResult() }
    }

    private fun buttonClicked(view: View) {
        val button = view as Button
        textView.text = "${textView.text}${button.text}"
    }

    private fun clearTextView() {
        textView.text = ""
    }

    private fun calculateResult() {
        val expression = textView.text.toString()
        try {
            val result = evaluateExpression(expression)
            textView.text = result.toString()
        } catch (e: Exception) {
            textView.text = "Error"
        }
    }

    private fun evaluateExpression(expression: String): Double {
        // This method can evaluate basic arithmetic expressions
        val tokens = expression.split("(?<=[-+*/%])|(?=[-+*/%])".toRegex()).map { it.trim() }
        var result = tokens[0].toDouble()
        var i = 1
        while (i < tokens.size) {
            val operator = tokens[i]
            val operand = tokens[i + 1].toDouble()
            result = when (operator) {
                "+" -> result + operand
                "-" -> result - operand
                "*" -> result * operand
                "/" -> result / operand
                "%" -> result % operand
                else -> throw IllegalArgumentException("Unknown operator")
            }
            i += 2
        }
        return result
    }
}