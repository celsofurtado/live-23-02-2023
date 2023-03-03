package br.senai.sp.jandira.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.fiap.R.*
import br.senai.sp.jandira.fiap.model.User
import br.senai.sp.jandira.fiap.repository.UserRepository

class MainActivity : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSignin: Button
    lateinit var editTextId: EditText
    lateinit var buttonDel: Button

    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val textSigUp = findViewById<TextView>(R.id.text_view_signup)
        editTextEmail = findViewById(R.id.login_edit_text_email)
        editTextPassword = findViewById(R.id.login_edit_text_password)
        buttonSignin = findViewById(R.id.button_signin)
        editTextId = findViewById(R.id.login_id)
        buttonDel = findViewById(R.id.button_delete)

        userRepository = UserRepository(this)

        textSigUp.setOnClickListener {
            val openSignUp = Intent(this, SignupActivity::class.java)
            startActivity(openSignUp)
        }

        buttonSignin.setOnClickListener {
            val user = userRepository.login(
                editTextEmail.text.toString(),
                editTextPassword.text.toString()
            )

            var sucesso = user ?: User()
            Toast.makeText(this, sucesso.userName, Toast.LENGTH_LONG).show()

        }

        buttonDel.setOnClickListener {
            val u = User(id = editTextId.text.toString().toLong())
            val i = userRepository.delete(u)
            Toast.makeText(this, "$i", Toast.LENGTH_LONG).show()
        }

    }
}