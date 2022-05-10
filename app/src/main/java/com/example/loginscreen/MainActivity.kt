package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("KullaniciBilgi", MODE_PRIVATE)

        binding.buttonGiris.setOnClickListener{

            val username = binding.EditTextUserName.text.toString()
            val password = binding.EditPassWord.text.toString()

            val ad = sp.getString("username","")
            val aq = sp.getString("password","")
            if( username == ad && password == aq ){
                val editor = sp.edit()
                editor.putString("username",username)
                editor.putString("password",password)
                editor.commit()

                startActivity(Intent(this@MainActivity,AnaSayfaActivity::class.java))
                finish()
            }else{
                Toast.makeText(applicationContext, "Hatalı Giriş", Toast.LENGTH_LONG).show()
            }
        }
        binding.ButtonKayit.setOnClickListener{
            startActivity(Intent(this@MainActivity,KayitActivity::class.java))
            finish()
        }
    }
}