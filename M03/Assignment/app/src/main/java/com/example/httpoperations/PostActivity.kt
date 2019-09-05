package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.httpoperations.api_interface.JsonPlaceHolderAPI
import com.example.httpoperations.model.Employee
import kotlinx.android.synthetic.main.activity_get.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity(), Callback<Employee> {
    override fun onFailure(call: Call<Employee>, t: Throwable) {
        Toast.makeText(this, "Failed to post", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        if (response.isSuccessful){
            val newEmployee = response.body() as Employee
            Toast.makeText(this, "${newEmployee.name} successfully added", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.GONE
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val employees = JsonPlaceHolderAPI.Factory.create()
        val employee = Employee("David", 7, 30, "intern")
        employees.addNewEmployee(employee).enqueue(this)


    }
}
