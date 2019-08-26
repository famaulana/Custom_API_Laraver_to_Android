package com.android.localapi.Utilities

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



public class ApiClient {

    companion object{
        val BASE_URL = "http://172.168.10.15/LatihanAPI/public/api/"
    }

    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}