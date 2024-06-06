package com.example.pra19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class main2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val currentFr=supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFr==null){
            val fragment=Crimefragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }
}