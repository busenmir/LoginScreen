package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.loginscreen.databinding.ActivityKayitBinding

class KayitActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("KullaniciBilgi", MODE_PRIVATE)

        binding.buttonKayT.setOnClickListener{

            val newUser = binding.editYeniKullanici.text.toString()
            val newPass = binding.edirYeniSifre.text.toString()
            if(newUser == "" || newPass == "" && newUser.length < 3){
                val uyari = AlertDialog.Builder(this@KayitActivity)
                uyari.setMessage("Kullanıcı Adı veya Şifrede Boşluk Kullanmayınız\n Kullanıcı Adı 3 Harfden Fazla Olmalı")
                uyari.setTitle("Uyari")
                uyari.setPositiveButton("Tamam"){ dialogInterface, i ->
                    Toast.makeText(applicationContext, "Lütfen Kullanıcı Adınızı ve Şİfrenizi Giriniz", Toast.LENGTH_SHORT).show()
                }
                uyari.create().show()
            }else {
            val editor = sp.edit()
            editor.putString("username",newUser)
            editor.putString("password",newPass)
            editor.apply()
            startActivity(Intent(this@KayitActivity,MainActivity::class.java))
                finish()
        }
        }

    }
}