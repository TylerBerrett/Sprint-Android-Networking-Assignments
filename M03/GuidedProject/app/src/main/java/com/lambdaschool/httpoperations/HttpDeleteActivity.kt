package com.lambdaschool.httpoperations

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lambdaschool.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpDeleteActivity : AppCompatActivity(), Callback<Void> {
    override fun onFailure(call: Call<Void>, t: Throwable) {

    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        if (response.isSuccessful){
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }

    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)
        title = "Delete Request: Delete existing employee with id 1"


        val gson = Gson()
        employeesService = Retrofit.Builder()
            .baseUrl(JsonPlaceHolderApi.Factory.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(JsonPlaceHolderApi::class.java)
        deleteEmployee()
    }

    private fun deleteEmployee(){
        // TODO: delete the employee
        employeesService.deleteEmployeeById("1").enqueue(this)
    }
}
