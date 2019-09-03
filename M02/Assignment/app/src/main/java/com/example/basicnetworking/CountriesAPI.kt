package com.example.basicnetworking

import com.example.basicnetworking.model.OceaniaCountry
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {
    @GET("oceania")
    fun getCountries(): Call<OceaniaCountry>
}