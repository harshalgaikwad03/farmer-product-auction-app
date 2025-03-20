package com.example.farmer_app

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class farmerlocation : AppCompatActivity() {

    var btnshow: Button? = null
    var supportMapFragment: SupportMapFragment? = null
    var map: GoogleMap? = null
    var mfire: DatabaseReference? = null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var lati = 0.0
    var longi = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmerlocation)

        val btndeatils = findViewById<Button>(R.id.btndetails)

        btndeatils.setOnClickListener {
            val intent = Intent(applicationContext, ShowLocation::class.java)
            startActivity(intent)
        }


        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getlocation()
        }
    }

    private fun getlocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        val task = fusedLocationProviderClient!!.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                lati = location.latitude
                longi = location.longitude
                supportMapFragment!!.getMapAsync { googleMap ->
                    map = googleMap
                    mfire = FirebaseDatabase.getInstance().reference.child("Product")
                    mfire!!.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (s in snapshot.children) {
                                val lat = s.child("lati").value.toString()
//                                Toast.makeText(applicationContext,lat.toString(),Toast.LENGTH_LONG).show()
                                System.out.println("......................................." + lat)
                                val lng = s.child("longi").value.toString()
                                System.out.println("........................................" + lng)
//                                Toast.makeText(applicationContext,lng.toString(),Toast.LENGTH_LONG).show()
                                try {
                                    val latitude = lat.toDouble()
                                    val longitude = lng.toDouble()
                                    val lokasi = LatLng(latitude, longitude)
                                    println(lokasi)

//                                    Toast.makeText(applicationContext,lokasi.toString(),Toast.LENGTH_LONG).show()
                                    map!!.addMarker(
                                        MarkerOptions().position(lokasi)
                                            .title(s.child("fname").value.toString())


                                    )
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {}
                    })
                    map!!.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(lati, longi), 10f
                        )
                    )
                }
            }
        }
    }
}