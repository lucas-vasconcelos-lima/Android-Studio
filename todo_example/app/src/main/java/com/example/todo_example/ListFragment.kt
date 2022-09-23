package com.example.todo_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // trás o inflate para conseguir inflar
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        // aqui joga ar para inflar
        val floatingAdd = view.findViewById<FloatingActionButton>(R.id.floatingAdd)
        // quando clicar navega para proxima tela
        floatingAdd.setOnClickListener {
            // navController - controller de ações
            // navigate - ir até algum destino
            // destino
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return view
    }

}

