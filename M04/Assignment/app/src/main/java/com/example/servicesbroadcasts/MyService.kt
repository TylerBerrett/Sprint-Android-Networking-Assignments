package com.example.servicesbroadcasts

import android.app.Service
import android.content.Intent
import android.net.Network
import android.os.IBinder
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.UnsupportedOperationException

class MyService : Service() {

    companion object {
        val DOWNLOAD_IMAGE_KEY = "key"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(Runnable {
            val bitmap = NetworkAdapter.getBitmapFromUrl("https://i.imgur.com/HaSmgGn.jpg", 100, 100)

            val intent = Intent("test").apply {
                putExtra(DOWNLOAD_IMAGE_KEY, bitmap)
            }
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            stopSelf()
        }).start()
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException()
    }
}
