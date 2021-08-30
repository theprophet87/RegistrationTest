package com.theprophet.registrationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.theprophet.registrationtest.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.previewButton.setOnClickListener {
            onPreviewClicked()
        }



        val spinnerValues: Array<String> = arrayOf("","Mr.", "Mrs.", "Ms.", "Dr.")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.titleSpinner.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {

        val formInformation = Information(
            binding.titleSpinner.selectedItem?.toString(),
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPhone.text.toString(),
            binding.editTextPassword.text.toString()
            )


        val previewActivity = Intent(this, PreviewActivity::class.java)
        previewActivity.putExtra("nameInfo", formInformation)
        previewActivity.putExtra("emailInfo", formInformation)
        previewActivity.putExtra("phoneInfo", formInformation)
        previewActivity.putExtra("passwordInfo", formInformation)
        startActivity(previewActivity)


    }
}