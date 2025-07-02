package com.example.pra19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar


class Second : AppCompatActivity() {

    var a: String ="";
    var b: String ="";
    var c: String ="";
    var answ: Double =0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val spinner: Spinner = findViewById(R.id.fig)
        val imageView: ImageView = findViewById(R.id.figimg)


        val figuri = resources.getStringArray(R.array.items)
        val figimg = intArrayOf(
            R.drawable.tr,
            R.drawable.el
        )

        a= findViewById<EditText>(R.id.First).text.toString()
        b=findViewById<EditText>(R.id.Second).text.toString()



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                imageView.setImageResource(figimg[position])
                if(figimg[position].toString()=="0")
                {

                }
                else{

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                findViewById<EditText>(R.id.Second).visibility=View.VISIBLE;

            }
        }

    }

    private fun showSnackbar(message: String) {
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).setAction("OK") {}.show()
    }


    fun ras(view: View) {




        val intent = Intent(this, ThirdActivity::class.java).apply {


            putExtra("KEY_A", a)
            putExtra("KEY_B", b)

            putExtra("KEY_NUMBER", c)
        }


        startActivity(intent)
    }
}