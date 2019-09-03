package com.example.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    inner class MyAsyncTask : AsyncTask<Unit, Int, String>(){
        //Need
        override fun doInBackground(vararg p0: Unit?): String {
            val primeNumbers = primes().take(16000).joinToString(", ")
            return primeNumbers
        }
        override fun onPreExecute() {
            super.onPreExecute()
            prime_number_text.visibility = TextView.GONE
            toggleProgressBar()
        }
        //need
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            toggleProgressBar()
            prime_number_text.visibility = View.VISIBLE
            prime_number_text.text = "Primes: $result"
        }

        override fun onCancelled() {
            super.onCancelled()
            println("onCancelled")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyAsyncTask().execute()
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
        MyAsyncTask().cancel(false)
    }




    //Functions below

    fun toggleProgressBar (){
        if (progressBar.visibility == ProgressBar.VISIBLE){
            progressBar.visibility = ProgressBar.GONE
        }
        else{
            progressBar.visibility = ProgressBar.VISIBLE
        }
    }


    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }
    }


}
