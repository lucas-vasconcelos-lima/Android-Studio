package com.example.my_application04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val buttonVoltar = findViewById<Button>(R.id.buttonBack)

        buttonVoltar.setOnClickListener {
            finish()
        }


    }
}