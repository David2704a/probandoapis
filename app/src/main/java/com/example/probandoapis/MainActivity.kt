package com.example.probandoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.probandoapis.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map : GoogleMap
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createFragment()

        val retroftiTraer =  RetrofitClient.consumirApi.getTraer()

        retroftiTraer.enqueue(object : retrofit2.Callback<Cliente>{
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                binding.tvMostrar.text = response.body().toString()
            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error al consultar el api rest", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}