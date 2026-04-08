package com.utama.registerapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        rgGender = findViewById(R.id.rgGender)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val nama = etNama.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val password = etPassword.text.toString()
            val confirm = etConfirmPassword.text.toString()

            val selectedGender = rgGender.checkedRadioButtonId

            if (nama.isEmpty() || email.isEmpty() || phone.isEmpty()
                || password.isEmpty() || confirm.isEmpty()
            ) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()

            } else if (password != confirm) {
                Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_SHORT).show()

            } else if (selectedGender == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()

                // balik ke login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
