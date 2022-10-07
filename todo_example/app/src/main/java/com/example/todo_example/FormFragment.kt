package com.example.todo_example

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_example.databinding.FragmentFormBinding
import com.example.todo_example.fragment.DatePickerFragment
import com.example.todo_example.fragment.TimerPickerListener
import com.example.todo_example.model.Categoria
import com.example.todo_example.model.Tarefa
import com.example.todo_example.util.MainViewModel
import java.time.LocalDate


class FormFragment : Fragment(), TimerPickerListener  {

    private  lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    // vai armazenar o id da categoria que queremos
    private var categoriaSelecionada = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.dataSelecionada.value = LocalDate.now()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())

        }
        //
        mainViewModel.dataSelecionada.observe(viewLifecycleOwner){
            selectedDate -> binding.editData.setText(selectedDate.toString())

        }

               binding.buttonSalvar.setOnClickListener {
                   inserirNoBanco()
        }
        // apresenta o calendario pegando
        binding.editData.setOnClickListener{
            DatePickerFragment(this)
                .show(parentFragmentManager, "DatePicker")
        }

        return binding.root

    }

    fun spinnerCategoria(listCategoria: List<Categoria>?){
        if (listCategoria != null){
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                // entende que sera usado apenas aqui, por isso não importa no cabeçalho
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listCategoria
            )

        // o que acontece quando um item é selecionado
        binding.spinnerCategoria.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                // aqui verifica se realmente o item foi selecionado e qual
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val selectec = binding.spinnerCategoria.selectedItem as Categoria
                    // armazena o id da categoria selecionada
                    categoriaSelecionada = selectec.id
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
    private fun validarCampos(nome: String, descricao: String, responsavel: String): Boolean{

        return!(
                (nome == "" || nome.length <3 || nome.length >20) ||
                        (descricao == "" || descricao.length < 5 || descricao.length >200) ||
                        (responsavel == "" || responsavel.length < 3 || responsavel.length > 20)
                )
    }

    private fun inserirNoBanco(){
        val nome = binding.editNome.text.toString()
        val desc = binding.editDescricao.text.toString()
        val resp = binding.editResponsavel.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchAtivoCard.isChecked
        val categoria = Categoria(categoriaSelecionada, null, null)

        if(validarCampos(nome, desc, resp)){
            val tarefa = Tarefa(0, nome, desc, resp, data, status, categoria)
            mainViewModel.addTarefa(tarefa)
            Toast.makeText(context, "Tarefa criada!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }else
            Toast.makeText(context, "Verifique os campos!", Toast.LENGTH_SHORT).show()
    }


    //quando estender a classe de TimerPickerListener ele implementa esse metodo
    override fun onDateSelected(date: LocalDate) {
        // joga a data para dentro da dataSelecionada, como está sendo observado ele altera
        mainViewModel.dataSelecionada.value = date
    }
}
