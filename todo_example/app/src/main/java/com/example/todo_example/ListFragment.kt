package com.example.todo_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_example.adapter.TarefaAdapter
import com.example.todo_example.databinding.FragmentListBinding
import com.example.todo_example.model.Tarefa


class ListFragment : Fragment() {

    // classe só existe pq habilitamos
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)



        // Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)



        binding.floatingAdd.setOnClickListener {
            // navController - controller de ações
            // navigate - ir até algum destino
            // destino
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        return binding.root
    }

}

