package com.example.android.kotlinretrofitapicall.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.android.kotlinretrofitapicall.R
import com.example.android.kotlinretrofitapicall.adepter.MyAdepter
import com.example.android.kotlinretrofitapicall.model.ResponceModel
import com.example.android.kotlinretrofitapicall.retrofit.ApiInterface
import com.example.android.kotlinretrofitapicall.retrofit.Apiclient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    lateinit var mApiInterface: ApiInterface
    lateinit var mAdepter: MyAdepter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiliazation()
    }

    private fun initiliazation() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        mApiInterface = Apiclient.client.create(ApiInterface::class.java)
        apiCall()
    }

    private fun apiCall() {
        var call = mApiInterface.getTopRatedMovies("2")
        call.enqueue(object : Callback<ResponceModel> {
            override fun onFailure(call: Call<ResponceModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponceModel>, response: Response<ResponceModel>) {
                var listOfMovies: List<ResponceModel.Data> = response.body()?.data!!
                mAdepter = MyAdepter(applicationContext, listOfMovies)
                recyclerView.setAdapter(mAdepter)
                Log.e(TAG, "responce" + response.body()?.image_url)
            }
        })
    }
}
