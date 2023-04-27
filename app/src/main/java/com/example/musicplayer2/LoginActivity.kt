package com.example.musicplayer2

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicplayer2.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSignIn.setOnClickListener {

            val uniqueId = binding.enterId.text.toString()
            if (uniqueId.isNotEmpty()) {
                getData(uniqueId)
            } else {
                Toast.makeText(this, "Please enter user id", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun getData(uniqueId: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(uniqueId).get().addOnSuccessListener {


            if (binding.checkbox.isChecked) {
                Toast.makeText(this, "u accepted term and condition", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Please accept term and condition", Toast.LENGTH_SHORT).show()
                binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
            }
            if (it.exists()) {

                val intent = Intent(this, MusicActivity::class.java)

                startActivity(intent)
            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }

        }

    }
}