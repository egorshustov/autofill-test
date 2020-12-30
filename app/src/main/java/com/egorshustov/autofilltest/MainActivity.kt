package com.egorshustov.autofilltest

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egorshustov.autofilltest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener { saveEmailAddresses() }
    }

    private fun saveEmailAddresses() {
        getSharedPreferences(EMAIL_PREFERENCES, Context.MODE_PRIVATE).edit().apply {
            putString(EMAIL_PRIMARY_PREF, binding.editEmailPrimary.text.toString())
            putString(EMAIL_SECONDARY_PREF, binding.editEmailSecondary.text.toString())
            apply()
        }
    }
}