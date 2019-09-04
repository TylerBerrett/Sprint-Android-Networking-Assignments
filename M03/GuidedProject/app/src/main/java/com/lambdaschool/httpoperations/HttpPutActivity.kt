package com.lambdaschool.httpoperations

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lambdaschool.httpoperations.model.Employee
import com.lambdaschool.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpPutActivity : AppCompatActivity(), Callback<Employee> {
    override fun onFailure(call: Call<Employee>, t: Throwable) {

    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        response.body().let {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }
    }

    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)
        title = "Put Request: Update existing Employee Steve"

        // TODO: Create the API object
        val gson = Gson()
        employeesService = Retrofit.Builder()
            .baseUrl(JsonPlaceHolderApi.Factory.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(JsonPlaceHolderApi::class.java)
        updateEmployee()
    }

    private fun updateEmployee(){
        // TODO: Write the call to update an employee
        val employee = Employee("Brian", 6, 41, "Instructor")
        employeesService.updateEmployee(employee).enqueue(this)
    }

}
