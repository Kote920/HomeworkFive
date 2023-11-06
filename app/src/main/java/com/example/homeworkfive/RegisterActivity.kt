package com.example.homeworkfive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.homeworkfive.databinding.ActivityLogInBinding
import com.example.homeworkfive.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }

        binding.buttonNext.setOnClickListener {

            if (isEmailValid(binding.editTextEmail) && isValidPass(binding.editTextPassword)){
                val intent = Intent(this, RegisterSecondActivity::class.java)
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Enter Valid E-mail!!", Toast.LENGTH_SHORT).show()
            }

        }


    }
    fun isEmailValid(input: AppCompatEditText): Boolean {
        val email = input.text.toString()
        val pattern = Patterns.EMAIL_ADDRESS
        if(pattern.matcher(email).matches()){
            return true
        }
        Toast.makeText(this, "Enter Valid E-mail!!", Toast.LENGTH_SHORT).show()

        return false
    }
    fun isValidPass(input: AppCompatEditText): Boolean{
        val text = input.text.toString()
        if (text.length < 8){
            Toast.makeText(this, "Enter valid password(more than 8 letters)", Toast.LENGTH_LONG).show()
            return false
        }
        else{
            return true
        }
    }
}