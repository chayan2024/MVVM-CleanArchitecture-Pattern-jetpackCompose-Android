package com.example.mvvm_cleanarchitecture_pattern.data.repository

import com.example.mvvm_cleanarchitecture_pattern.data.model.PostData
import com.example.mvvm_cleanarchitecture_pattern.data.network.ApiService
import com.example.mvvm_cleanarchitecture_pattern.data.toDomainModel
import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post
import com.example.mvvm_cleanarchitecture_pattern.domain.repository.PostRepository

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        val postDataList: List<PostData> = apiService.getPosts()
        return postDataList.map { it.toDomainModel() }
    }
}