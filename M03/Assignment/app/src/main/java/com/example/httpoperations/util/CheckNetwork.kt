package com.example.httpoperations.util

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class CheckNetwork {
    companion object{

        fun isConnected(context: Context): Boolean{
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork?.isConnected == true

        }

        fun displaySnackBar(view: View){
            Snackbar.make(view, "Failed to connect to internet", Snackbar.LENGTH_LONG).show()
        }


    }

}