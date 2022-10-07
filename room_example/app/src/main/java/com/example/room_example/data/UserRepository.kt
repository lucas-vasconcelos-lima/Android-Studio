package com.example.room_example.data

/**
 * a criação exige que seja criado por alguem tipo Dao
 */
class UserRepository(private val userDao: UserDao) {

    val selectUsers = userDao.selectUsers()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }
}