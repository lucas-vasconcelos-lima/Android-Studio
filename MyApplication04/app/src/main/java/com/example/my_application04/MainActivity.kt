package com.example.my_application04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ciclo", "onCreate")

        // tras o botão para dentro do cod
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        // cria a intenção de mudança de tela
        val intentSegunda = Intent(this, SegundaActivity2::class.java)

        // atribui a função de click no botão
        buttonNext.setOnClickListener {
            // indica a função de mudar a pg pelo botão
            startActivity(intentSegunda)
        }
    }
}