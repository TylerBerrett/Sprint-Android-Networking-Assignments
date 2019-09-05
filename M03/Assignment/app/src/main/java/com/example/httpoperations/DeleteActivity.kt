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

class DeleteActivity : AppCompatActivity(), Callback<Void> {

    override fun onFailure(call: Call<Void>, t: Throwable) {
        Toast.makeText(this, "Failed to post", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        if (response.isSuccessful){
            Toast.makeText(this, "Successfully deleted", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.GONE
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        val employees = JsonPlaceHolderAPI.Factory.create()
        employees.deleteEmployeeById("1").enqueue(this)

    }
}
