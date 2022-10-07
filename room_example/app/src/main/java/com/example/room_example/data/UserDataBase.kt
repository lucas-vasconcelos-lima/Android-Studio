package com.example.room_example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * export - mostra os scripts da api
 */
@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    /**
     * retorna a interface e ter acesso a todas requisições
     */
    abstract fun userDao(): UserDao

    companion object{
        /**
         * @Volatile - fica visivel a todas as flags do app quando for instanciada
         * e confere se não tem
         */
        @Volatile
        private var INSTANCE: UserDataBase? = null
        /**
         * verifica se existe alguma instancia, se existir retorna, se não é criada
         */
        fun getDataBase(context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return  tempInstance
            }
            /**
             *  synchronized - ele ganha prioridade na trad onde está sendo executado, no caso aqui (this)
             */
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, UserDataBase::class.java,"user_database"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}