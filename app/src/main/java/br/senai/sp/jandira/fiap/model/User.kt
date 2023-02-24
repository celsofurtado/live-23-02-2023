package br.senai.sp.jandira.fiap.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "user_name") var userName: String = "",
    var email: String = "",
    var password: String = "",
    var over18: Int = 0
)
