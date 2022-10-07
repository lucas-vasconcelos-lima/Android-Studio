package com.example.room_example.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
*(@Dao) - sabe que as requisições iram partir dela
 */
@Dao
interface UserDao {
/**
   * adiciona o usuario dentro do banco
    *@Insert - anotação para inserir no banco
    *onConflict - usuario duplicado é ignorado e descarta
 */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usuario: Usuario)

    /**
     * @Query - "retorna todos dentro da entidade e ordena pelo id de forma crescente"
     */
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectUsers(): LiveData<List<Usuario>>
}