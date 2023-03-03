package br.senai.sp.jandira.fiap.dao

import androidx.room.*
import br.senai.sp.jandira.fiap.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Update
    fun atualizar(user: User): Int

    @Delete
    fun excluir(user: User): Int

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun getUserById(id: Long): User

    @Query("SELECT * FROM tbl_user ORDER BY user_name ASC")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :password")
    fun login(email: String, password: String): User
}



