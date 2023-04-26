package com.example.musicplayer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicplayer2.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.materialButton.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassward.text.toString()
            val uniqueId = binding.etUniqeId.text.toString()


            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || uniqueId.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, email, password, uniqueId)
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(uniqueId).setValue(user).addOnSuccessListener {

                    binding.etName.text?.clear()
                    binding.etEmail.text?.clear()
                    binding.etPassward.text?.clear()
                    binding.etUniqeId.text?.clear()

                    Toast.makeText(this, "User logged In", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }

}