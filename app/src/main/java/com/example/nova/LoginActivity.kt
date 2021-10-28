package com.example.nova

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nova.databinding.ActivityMainBinding

class LoginActivity: AppCompatActivity() {

    var _binding: ActivityMainBinding? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding = _binding!!

        setContentView(binding.root)
    }
}