package br.senai.sp.jandira.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.fiap.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val textSigUp = findViewById<TextView>(R.id.text_view_signup)

        textSigUp.setOnClickListener {
            val openSignUp = Intent(this, SignupActivity::class.java)
            startActivity(openSignUp)
        }


    }
}