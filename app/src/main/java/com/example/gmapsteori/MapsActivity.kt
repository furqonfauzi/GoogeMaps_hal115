package com.example.gmapsteori

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera

        val uty = LatLng(-7.747033,110.355398)
        mMap.addMarker(MarkerOptions().position(uty).title("UTY Kampus 1 ").snippet("Ini Sekolahan Saya")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,10.0f))


        val rumah = LatLng(-7.889221,110.106784)
        mMap.addMarker(MarkerOptions().position(rumah).title("Rumah Saya").snippet("Ini Tempat Tinggal Saya")
            .icon(BitmapDescreptorFromVector(applicationContext,R.drawable.rumah)))


        val zoo = LatLng(-7.8041252,110.3958328)
        mMap.addMarker(MarkerOptions().position(zoo).title("Gembero loko").snippet("Ini Peternakan Saya")
            .icon(BitmapDescreptorFromVector(applicationContext,R.drawable.zoo)))

        val airport = LatLng(-7.7876838,110.4295726)
        mMap.addMarker(MarkerOptions().position(airport).title("Air Port").snippet("Ini Garasi Saya")
            .icon(BitmapDescreptorFromVector(applicationContext,R.drawable.bandara)))

        val alun = LatLng(-7.8118476,110.3609755)
        mMap.addMarker(MarkerOptions().position(alun).title("Alun - Alun Kidul ").snippet("Ini Tempat Nongkrong Saya")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))


    }

    private fun BitmapDescreptorFromVector(context : Context,vectorResId:Int): BitmapDescriptor? {
        val vectorDrawable:Drawable? = ContextCompat.getDrawable(context,vectorResId)
        vectorDrawable!!.setBounds(0,0,vectorDrawable!!.intrinsicWidth,vectorDrawable.intrinsicHeight)

        val Bitmap:Bitmap= Bitmap.createBitmap(vectorDrawable.intrinsicWidth,vectorDrawable.intrinsicHeight,Bitmap.Config.ARGB_8888)

        val canvas:Canvas= Canvas(Bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(Bitmap)


    }
}
