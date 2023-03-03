package br.senai.sp.jandira.fiap.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.fiap.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{

        private lateinit var instance: AppDatabase

        fun getDataBase(context: Context): AppDatabase {

            if(!::instance.isInitialized){
                instance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }

}
