package com.example.room_example

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_example.data.UserDataBase
import com.example.room_example.data.UserRepository
import com.example.room_example.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Para conseguir utilizar banco eu utilizar a função que irá retornar ele precisamos do context
 */
class MainViewModel (application: Application): AndroidViewModel(application) {

    val selecUsers: LiveData<List<Usuario>>
    val repository: UserRepository
    /**
     * inicializa essas variaveis para ter acesso aos dados que queremos recuperar
     */
    init {
        /**
         * userDao - guarda nessa variavel um objeto que tenha implementação da interface userDao
         */
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        selecUsers = repository.selectUsers
    }
    /**
     * executa a função de add no banco
     * Dispatchers.IO - otimizado para utilizar o disco, para fazer a inserção na memoria do celular
     */

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(usuario)
        }
    }
}