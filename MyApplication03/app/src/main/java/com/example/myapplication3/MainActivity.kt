package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        findViewById()
         */

        val buttonD6 = findViewById<Button>(R.id.buttonD6)
        buttonD6.setOnClickListener {
            Toast.makeText(this, "Sorteio de 6 números realizado!", Toast.LENGTH_SHORT).show()
            rolarDados(6)
        }
            val buttonD12 = findViewById<Button>(R.id.buttonD12)
            buttonD12.setOnClickListener {
                Toast.makeText(this, "Sorteio de 12 números realizado!", Toast.LENGTH_SHORT).show()
                rolarDados(12)
            }
                val buttonD18 = findViewById<Button>(R.id.buttonD18)
                buttonD18.setOnClickListener {
                    Toast.makeText(this, "Sorteio de 18 números realizado!", Toast.LENGTH_SHORT)
                        .show()
                    rolarDados(18)
                }




    }

    private fun rolarDados(lados: Int) {
        val rolagem = (1..lados).random()
        val textDado = findViewById<TextView>(R.id.textDado)
        textDado.text = rolagem.toString()


    }
}
