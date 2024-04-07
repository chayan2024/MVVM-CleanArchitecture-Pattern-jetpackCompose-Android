package com.example.mvvm_cleanarchitecture_pattern.domain.use_cases

import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post
import com.example.mvvm_cleanarchitecture_pattern.domain.repository.PostRepository

class GetPostsUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(): List<Post> {
        return postRepository.getPosts()
    }
}