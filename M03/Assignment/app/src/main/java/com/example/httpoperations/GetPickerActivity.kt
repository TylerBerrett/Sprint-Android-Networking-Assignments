package com.example.httpoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.api_interface.JsonPlaceHolderAPI
import com.example.httpoperations.model.Employee
import kotlinx.android.synthetic.main.activity_get_picker.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPickerActivity : AppCompatActivity(){




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picker)
        val toGetActivity = Intent(this, GetActivity::class.java)


        buttonSimpleGet.setOnClickListener {
            toGetActivity.putExtra("toGet", "simple")
            startActivity(toGetActivity)
        }

        buttonPath.setOnClickListener {
            toGetActivity.putExtra("toGet", "path")
            startActivity(toGetActivity)
        }

        buttonQuery.setOnClickListener {
            toGetActivity.putExtra("toGet", "query")
            startActivity(toGetActivity)
        }


    }
}
