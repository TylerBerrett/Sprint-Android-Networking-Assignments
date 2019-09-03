package com.example.basicnetworking

import com.example.basicnetworking.model.OceaniaCountry
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {
    @GET("/rest/v2/region/oceania")
    fun getCountries(): Call<List<OceaniaCountry>>
}