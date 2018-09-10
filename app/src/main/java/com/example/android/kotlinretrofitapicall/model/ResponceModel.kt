package com.example.android.kotlinretrofitapicall.model


data class ResponceModel(
        val status: Int,
        val msg: String,
        val image_url: String,
        val data: List<Data>
) {

    data class Data(
            val id: Int,
            val quotes_image: String,
            val quotes_name: String,
            val authormanagement_id: Int,
            val categorymanagement_id: Int,
            val created_at: String,
            val updated_at: String
    )
}