package com.example.homeworkfive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.homeworkfive.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val auth = FirebaseAuth.getInstance()
        val intentProfile = Intent(this, ProfileActivity::class.java)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }

        binding.buttonLogIn.setOnClickListener {

            if(isNotBlank(binding.editTextEmail) && isNotBlank(binding.editTextPassword)){
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val uid = user?.uid // This is the unique user ID
                            startActivity(intentProfile)
                            Toast.makeText(this, "DONEEE", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()
                        }
                    }

            }


        }
    }

    fun isNotBlank(input: AppCompatEditText):Boolean{
        val inputText = input.text.toString()
        if(inputText.isNotEmpty()){
            return true
        }
        Toast.makeText(this, "Fill Everything!!", Toast.LENGTH_SHORT).show()
        return false
    }
}