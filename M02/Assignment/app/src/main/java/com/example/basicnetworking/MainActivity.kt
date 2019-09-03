package com.example.basicnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnetworking.model.OceaniaCountry
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<OceaniaCountry>> {
    override fun onFailure(call: Call<List<OceaniaCountry>>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.printStackTrace()}"
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<OceaniaCountry>>, response: Response<List<OceaniaCountry>>) {
        if(response.isSuccessful){
            val oceaniaCountryList = response.body()
            countriesRecyclerView.layoutManager = LinearLayoutManager(this)
            countriesRecyclerView.adapter = CountriesRecycler(oceaniaCountryList)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchCountriesButton.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }

    }
}
