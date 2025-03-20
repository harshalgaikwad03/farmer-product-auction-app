package com.example.farmer_app

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference

class details : AppCompatActivity() {

    var name: String? = null
    var material: String? = null
    var manifacute: String? = null
    var origin: String? = null
    var weight: String? = null
    var rating: String? = null
    var demi: String? = null
    var price: String? = null

    var ref: DatabaseReference? = null
    var username: String? = null
    var usermobile: String? = null
    var useremail: String? = null
    var useraddress: String? = null
    var url: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val txtproname = findViewById<TextView>(R.id.txtname)
        val txtmaterial = findViewById<TextView>(R.id.txtmaterial)
        val txtaddress = findViewById<TextView>(R.id.txtmanifacture)

        val txtarea = findViewById<TextView>(R.id.txtorigin)
        val txtwight = findViewById<TextView>(R.id.txtweigth)
        val txtrating = findViewById<TextView>(R.id.txtrating)
        val txtdemi = findViewById<TextView>(R.id.txtdime)



        val bundle = intent.extras

        name = bundle?.getString("uname")
        material = bundle?.getString("unumber")
        manifacute = bundle?.getString("uaddress")
        origin = bundle?.getString("date")
        weight = bundle?.getString("time")
        rating = bundle?.getString("fname")
        demi = bundle?.getString("proname")


        url = bundle?.getString("url")



        txtproname.setText("User Name:" + name)
        txtmaterial.setText("User Address: " + material)
        txtaddress.setText("User Number: " + manifacute)
        txtarea.setText("Date: " + origin)
        txtwight.setText("Time: " + weight)
        txtrating.setText("Farmer Name: " + rating)
        txtdemi.setText("Product Name: " + demi)
//        txtprice.setText("Price: " + price)
        val btnorder = findViewById<Button>(R.id.btnorder)
        btnorder.setOnClickListener {


            val smsManager: SmsManager = SmsManager.getDefault()

            smsManager.sendTextMessage("+91"+manifacute, null, "Your Are Won Product", null, null)
        }


        val btncall = findViewById<Button>(R.id.btncall)
        btncall.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:"+manifacute)
            startActivity(intent)

        }

        val btntrack = findViewById<Button>(R.id.btntrack)
        btntrack.setOnClickListener {
            try {
                val uri = Uri.parse("https://www.google.co.in/maps/dir/"+""+"/"+ material)

                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }catch (e: ActivityNotFoundException)
            {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }


    }
}