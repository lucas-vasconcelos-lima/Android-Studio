package com.example.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // deixa ativo até o ciclo de vida da main activity (this) ou seja, sobrevive a ele
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.cont.observe(this){
            binding.textResult.text = it.toString()
        }
        binding.buttonClique.setOnClickListener {
            mainViewModel.addNum()
        }
    }
}