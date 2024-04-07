package com.example.mvvm_cleanarchitecture_pattern.domain.repository

import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}