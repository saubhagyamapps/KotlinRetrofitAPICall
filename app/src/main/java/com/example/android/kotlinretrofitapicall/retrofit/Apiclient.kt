package com.example.android.kotlinretrofitapicall.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {
    companion object {

        val baseURL: String = "http://rajviinfotech.in/quotes/"
        var retofit: Retrofit? = null

        val client: Retrofit
            get() {

                if (retofit == null) {
                    retofit = Retrofit.Builder()
                            .baseUrl(baseURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
                return retofit!!
            }
    }
}