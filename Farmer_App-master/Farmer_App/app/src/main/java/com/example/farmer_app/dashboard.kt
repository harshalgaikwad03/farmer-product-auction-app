package com.example.farmer_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {


                R.id.shop ->
                {
                    //Toast.makeText(applicationContext,"Recipe",Toast.LENGTH_LONG).show()

                    val i = Intent(applicationContext,Addproduct::class.java)
                    startActivity(i)
                    true

                }


                R.id.feedback ->
                {

                    Toast.makeText(applicationContext,"show order", Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,ShowOrder::class.java)
                    startActivity(i)
                    true
                }
                R.id.showre ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                    true
                }

                R.id.alarm ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,Alarm::class.java)
                    startActivity(i)
                    true
                }




                else -> {false}
            }
        }
    }
}