package com.sam.parcelabledemokt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    companion object{
       const  val USER = "user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClickMe = findViewById<Button>(R.id.button_click_me)
        val user = User("boris","qqq", PersonInfo("boris","zivkovic"))
        btnClickMe.setOnClickListener {
            val intent = Intent(this,Activity2::class.java)
            intent.putExtra(USER,user)
            startActivity(intent)
        }
    }
}