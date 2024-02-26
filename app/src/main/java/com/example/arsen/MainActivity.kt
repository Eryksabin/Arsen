package com.example.arsen
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)
        }
    }
    fun click1(view: View) {
        var displaytext : TextView = findViewById(R.id.textView)
        displaytext.setText("Dzien dobry")
    }
    fun click2(view: View) {
        var displaytext : TextView = findViewById(R.id.textView)
        displaytext.setText("Eryk Sabiniewicz")
    }
    fun click3(view: View) {
        var displaytext : TextView = findViewById(R.id.textView)
        displaytext.setText("Pozdrawiam")
    }
}