package br.senai.sp.jandira.fiap.repository

import android.content.Context
import br.senai.sp.jandira.fiap.dao.AppDatabase
import br.senai.sp.jandira.fiap.dao.UserDao
import br.senai.sp.jandira.fiap.model.User

class UserRepository(context: Context) {

    private val db = AppDatabase.getDataBase(context)

    //Gravar um novo usuário
    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    //Efetuar login
    fun login(email: String, password: String): User{
        return db.userDao().login(email, password)
    }

    fun delete(user: User): Int {
        return db.userDao().excluir(user)
    }

}