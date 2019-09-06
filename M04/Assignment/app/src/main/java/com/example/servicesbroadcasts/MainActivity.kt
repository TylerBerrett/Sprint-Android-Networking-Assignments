package com.example.servicesbroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var imageDownload: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_get_image.setOnClickListener {
            val serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
            it.visibility = View.GONE
            loading.visibility = View.VISIBLE
        }

        imageDownload = object: BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                val bitmap = p1?.getParcelableExtra<Bitmap>(MyService.DOWNLOAD_IMAGE_KEY)
                main_image.setImageBitmap(bitmap)
                loading.visibility = View.GONE
            }

        }

        val intentFilter = IntentFilter().apply {
            addAction(MyService.DOWNLOAD_ACTION)
        }

        LocalBroadcastManager.getInstance(this).registerReceiver(imageDownload, intentFilter)


    }

    override fun onDestroy() {
        unregisterReceiver(imageDownload)
        super.onDestroy()
    }
}
