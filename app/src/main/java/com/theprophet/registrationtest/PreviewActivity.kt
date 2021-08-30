package com.theprophet.registrationtest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.theprophet.registrationtest.databinding.PreviewActivityBinding



class PreviewActivity: AppCompatActivity() {
    private lateinit var binding: PreviewActivityBinding

    private lateinit var nameInfo: Information
    private lateinit var nameInfoPreviewText: String

    private lateinit var emailInfo: Information
    private lateinit var emailInfoPreviewText: String

    private lateinit var phoneInfo: Information
    private lateinit var phoneInfoPreviewText: String

    private lateinit var passwordInfo: Information
    private lateinit var passwordInfoPreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = PreviewActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        displayName()
        displayEmail()
        displayPhone()
        displayPassword()
        sendEmail()
        sendPhone()

    }


    //this will send the name into the preview screen's name card
    //---TO DO--
    //Add title logic
    private fun displayName() {
        nameInfo = intent.getSerializableExtra("nameInfo") as Information
        nameInfoPreviewText = "${nameInfo.getName()}"
        binding.textViewName.text = nameInfoPreviewText

    }

    private fun displayEmail() {
        emailInfo = intent.getSerializableExtra("emailInfo") as Information
        emailInfoPreviewText = "${emailInfo.email}"
        binding.textViewEmail.text = emailInfoPreviewText
    }

    private fun displayPhone() {
        phoneInfo = intent.getSerializableExtra("phoneInfo") as Information
        phoneInfoPreviewText = "${phoneInfo.phoneNumber}"
        binding.textViewPhone.text = phoneInfoPreviewText

    }


    private fun displayPassword() {
        passwordInfo = intent.getSerializableExtra("passwordInfo") as Information
        passwordInfoPreviewText = "${passwordInfo.password}"
        binding.textViewPassword.text = passwordInfoPreviewText
    }

    private fun sendPhone() {
        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${phoneInfo.phoneNumber}")

            }
            startActivity(intent)
        }
    }

    private fun sendEmail() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${emailInfo.email}")

            }
            startActivity(intent)
        }

    }

}


