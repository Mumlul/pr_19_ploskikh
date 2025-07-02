package com.example.pra19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val receivedA = intent.getStringExtra("KEY_A") ?: ""
        val receivedB = intent.getStringExtra("KEY_B") ?: ""
        val receivedNumber = intent.getIntExtra("KEY_NUMBER", 0)

//        val n1=Integer.parseInt(receivedA)
//        val n2=Integer.parseInt(receivedB)



        if(receivedNumber==0){
            findViewById<ImageView>(R.id.figiraimg).setImageResource(R.drawable.tr)
            findViewById<TextView>(R.id.figiratxt).text="Треугольник"
//            val answ=2*n1+n2
//            findViewById<TextView>(R.id.answ).text=answ.toString()
        }
        else
        {
            findViewById<ImageView>(R.id.figiraimg).setImageResource(R.drawable.el)
            findViewById<TextView>(R.id.figiratxt).text="Круг"
//            findViewById<TextView>(R.id.answ).text=(receivedA.toInt()/(2*3.14)).toString()
        }



    }

    fun register(view: View) {
        val intent=Intent(this,main2::class.java)
        startActivity(intent)

    }
}