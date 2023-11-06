package com.example.homeworkfive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.homeworkfive.databinding.ActivityRegisterBinding
import com.example.homeworkfive.databinding.ActivityRegisterSecondBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterSecondActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var  binding: ActivityRegisterSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }

        binding.buttonSignUp.setOnClickListener {
            if(isValidUsername(binding.editTextUsername)){
                val email = intent.getStringExtra("email")
                val password = intent.getStringExtra("password")
                val intentMainActivity = Intent(this, MainActivity::class.java)

                auth.createUserWithEmailAndPassword(email!!, password!!)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            // Save the user profile data to Firebase Database or Firestore
                            Toast.makeText(this, "Success!!", Toast.LENGTH_SHORT).show()
                            startActivity(intentMainActivity)
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                            startActivity(intentMainActivity)
                        }
                    }
            }

        }



    }
    fun isValidUsername(input: AppCompatEditText): Boolean{
        val inputUsername = input.text.toString()
        if(inputUsername.length < 5){
            Toast.makeText(this, "Enter valid username (min 5 letters)", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }
}
