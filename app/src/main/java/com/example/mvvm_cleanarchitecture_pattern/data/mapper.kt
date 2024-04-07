package com.example.mvvm_cleanarchitecture_pattern.data

import com.example.mvvm_cleanarchitecture_pattern.data.model.PostData
import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post

fun PostData.toDomainModel(): Post {
    return Post(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}