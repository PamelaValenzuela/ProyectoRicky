package com.example.rickymorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rickymorty.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeFragmentimage()
    }
    fun initializeFragmentimage(){
        supportFragmentManager.beginTransaction().add(R.id.fragmentmain,Fragmentimage.newInstance()).commit()
    }
}