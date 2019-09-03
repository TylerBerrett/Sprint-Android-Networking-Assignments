package com.example.basicnetworking

import com.example.basicnetworking.model.OceaniaCountry
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OceaniaCountriesRetriever {

    fun getOceaniaCountries(): Call<OceaniaCountry> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/region/oceania")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val countriesAPI = retrofit.create(CountriesAPI::class.java)

        return countriesAPI.getCountries()
    }

}