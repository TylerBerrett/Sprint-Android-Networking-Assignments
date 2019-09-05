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

class GetActivity : AppCompatActivity(), Callback<List<Employee>> {

    override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
        Toast.makeText(this, "Failed to get anything", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<List<Employee>>, response: Response<List<Employee>>) {
        if (response.isSuccessful){
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            result.text = response.body().toString()
            progressBar.visibility = View.GONE
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        val employee = JsonPlaceHolderAPI.Factory.create()

        val whichScreen = intent.getStringExtra("toGet")

        when (whichScreen){
            "simple" -> employee.getEmployees().enqueue(this)
            "path" -> employee.getEmployeesById("2").enqueue(this)
            "query" -> employee.getEmployeesByAge("45").enqueue(this)

        }





    }


}
