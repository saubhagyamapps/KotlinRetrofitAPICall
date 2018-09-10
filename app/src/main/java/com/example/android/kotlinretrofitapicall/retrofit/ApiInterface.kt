package com.example.android.kotlinretrofitapicall.retrofit

import com.example.android.kotlinretrofitapicall.model.ResponceModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("selected_AuthorData")
    fun getTopRatedMovies(@Field("author_id") author_id: String): Call<ResponceModel>
}