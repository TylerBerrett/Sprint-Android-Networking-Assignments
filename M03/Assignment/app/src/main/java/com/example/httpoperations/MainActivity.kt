package com.example.httpoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.httpoperations.util.CheckNetwork
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonGet.setOnClickListener {
            if (!CheckNetwork.isConnected(it.context)) {CheckNetwork.displaySnackBar(it)}
            else{
                val intent = Intent(this, GetPickerActivity::class.java)
                startActivity(intent)
            }
        }
        buttonPost.setOnClickListener {
            if (!CheckNetwork.isConnected(it.context)) {CheckNetwork.displaySnackBar(it)}
            else{
                val intent = Intent(this, PostActivity::class.java)
                startActivity(intent)
            }
        }
        buttonPut.setOnClickListener {
            if (!CheckNetwork.isConnected(it.context)) {CheckNetwork.displaySnackBar(it)}
            else{
                val intent = Intent(this, PutActivity::class.java)
                startActivity(intent)
            }
        }
        buttonDelete.setOnClickListener {
            if (!CheckNetwork.isConnected(it.context)) {CheckNetwork.displaySnackBar(it)}
            else{
                val intent = Intent(this, DeleteActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
