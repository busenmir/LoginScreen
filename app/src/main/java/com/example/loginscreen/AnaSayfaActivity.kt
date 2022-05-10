package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginscreen.databinding.ActivityAnaBinding

class AnaSayfaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("KullaniciBilgi", MODE_PRIVATE)

        val username = sp.getString("username","kullanıcı adı yok")
        val password = sp.getString("password","şifre yok")

        binding.textSonuc.text="Kullanıcı Adı : $username \n Şifre : $password"
        binding.buttonCikis.setOnClickListener{
            startActivity(Intent(this@AnaSayfaActivity,MainActivity::class.java))
            finish()
        }

    }
}