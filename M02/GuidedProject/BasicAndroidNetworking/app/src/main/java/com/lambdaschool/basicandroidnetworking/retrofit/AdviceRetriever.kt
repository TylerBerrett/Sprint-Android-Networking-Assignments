package com.lambdaschool.basicandroidnetworking.retrofit

import retrofit2.Call
import com.google.gson.GsonBuilder
import com.lambdaschool.basicandroidnetworking.model.AdviceMsg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdviceRetriever {

    companion object {
        private const val TAG = "RETRIEVER"
        internal const val BASE_URL = "https://api.adviceslip.com/"
    }

    // TODO: Write a fun to get a Retrofit call for an AdviceMsg
    fun getRandomAdvice(): Call<AdviceMsg> {
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val adviceAPI = retrofit.create(AdviceAPI::class.java)

        return adviceAPI.randomAdvice()
    }

    // TODO: Write a fun to make the same call with an OkHttp that has an HttpLoggingInterceptor
}
