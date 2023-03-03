package br.senai.sp.jandira.fiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import br.senai.sp.jandira.fiap.model.User
import br.senai.sp.jandira.fiap.repository.UserRepository

class SignupActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var checkOver18: CheckBox
    private lateinit var buttonCreateAccount: Button

    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editTextName = findViewById(R.id.sign_up_edit_text_username)
        editTextPhone = findViewById(R.id.sign_up_edit_text_phone)
        editTextEmail = findViewById(R.id.sign_up_edit_text_email)
        editTextPassword = findViewById(R.id.sign_up_edit_text_password)
        buttonCreateAccount = findViewById(R.id.sign_up_button_save)
        checkOver18 = findViewById(R.id.sign_up_check_box_over18)

        userRepository = UserRepository(this)

        // Ao clicar no botão, criar um usuário e salvar no banco
        buttonCreateAccount.setOnClickListener{
            val user = User(
                userName = editTextName.text.toString(),
                email = editTextEmail.text.toString(),
                password = editTextPassword.text.toString(),
                over18 = if(checkOver18.isChecked) 1 else 0
            )

            val id = userRepository.save(user)

        }

    }
}