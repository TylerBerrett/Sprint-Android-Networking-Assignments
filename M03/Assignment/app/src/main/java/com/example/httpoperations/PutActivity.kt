package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.httpoperations.api_interface.JsonPlaceHolderAPI
import com.example.httpoperations.model.Employee
import kotlinx.android.synthetic.main.activity_get.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PutActivity : AppCompatActivity(), Callback<Employee> {
    override fun onFailure(call: Call<Employee>, t: Throwable) {
        Toast.makeText(this, "Failed to post", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        if (response.isSuccessful){
            println(response.body())
            val changedEmployee = response.body() as Employee
            Toast.makeText(this, "${changedEmployee.name} successfully updated", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.GONE
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_put)

        val employees = JsonPlaceHolderAPI.Factory.create()
        val employee = Employee("Steve", 1, 25, "Principal Engineer")
        employees.updateEmployee(employee).enqueue(this)
    }
}
