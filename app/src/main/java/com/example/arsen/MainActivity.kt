package com.example.arsen
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.widget.Button

class MainActivity : ComponentActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)
        }
        textView = findViewById(R.id.textView)

        val buttons = listOf(
            R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six,
            R.id.seven, R.id.eight, R.id.nine, R.id.zero,
            R.id.plus, R.id.minus, R.id.multi, R.id.divide, R.id.modulo, R.id.coma)

        buttons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener { buttonClicked(it) }
        }

        findViewById<Button>(R.id.C).setOnClickListener { clearTextView() }
    }
    private fun buttonClicked(view: View) {
        val button = view as Button
        textView.text = "${textView.text}${button.text}"
    }

    private fun clearTextView() {
        textView.text = ""
    }
}