package com.example.mvvm_cleanarchitecture_pattern.data.network


import com.example.mvvm_cleanarchitecture_pattern.data.model.PostData
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostData>
}
