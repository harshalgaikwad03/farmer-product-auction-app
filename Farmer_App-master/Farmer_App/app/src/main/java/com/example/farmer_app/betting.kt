package com.example.farmer_app

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




class betting : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null

    var fname:String?=null
    var proname:String?=null
    var date:String?=null
    var time:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_betting)


         date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

        time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())


        val bundle = intent.extras

        fname = bundle?.getString("name")
        proname = bundle?.getString("address")

        Toast.makeText(applicationContext,fname.toString(),Toast.LENGTH_LONG).show()

        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)
        edtime = findViewById<EditText>(R.id.edprice)

    }

    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val name = edprofile!!.text.toString()
        val description = edcriteria!!.text.toString()
        val price = edtime!!.text.toString()


        val data = FirebaseDatabase.getInstance().reference.child("order")
        val service = Userbetting(category,name,description,price,fname,proname,date,time)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }
}