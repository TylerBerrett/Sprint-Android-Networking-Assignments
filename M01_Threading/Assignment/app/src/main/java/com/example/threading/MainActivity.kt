package com.example.threading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prime_number_text.visibility = TextView.GONE
        toggleProgressBar()

        val primeNumbers = primes().take(16000).joinToString(", ")
        prime_number_text.text = "Primes: $primeNumbers"




    }


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
