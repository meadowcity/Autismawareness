package com.asdidapp.autismawareness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField = findViewById<EditText>(R.id.name_field)
        val phoneNumberField = findViewById<EditText>(R.id.phone_number_field)
        val emergencyContactField = findViewById<EditText>(R.id.emergency_contact_field)

        val nextButton = findViewById<Button>(R.id.next_button)
        nextButton.setOnClickListener {
            val name = nameField.text.toString()
            val phoneNumber = phoneNumberField.text.toString()
            val emergencyContact = emergencyContactField.text.toString()

            val intent = Intent(this, LockScreenActivity::class.java).apply {
                putExtra("name", name)
                putExtra("phoneNumber", phoneNumber)
                putExtra("emergencyContact", emergencyContact)
            }
            startActivity(intent)
        }
    }
}

