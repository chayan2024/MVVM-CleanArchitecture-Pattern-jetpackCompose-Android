package com.example.mvvm_cleanarchitecture_pattern.domain.use_cases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post
import com.example.mvvm_cleanarchitecture_pattern.domain.repository.PostRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GetPostsUseCaseTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    suspend fun `invoke should return list of posts`() {
        // Mock dependencies
        val posts = listOf(
            Post(1, 1, "Title 1", "Body 1"),
            Post(2, 2, "Title 2", "Body 2")
        )
        val mockRepository = mock(PostRepository::class.java)
        `when`(mockRepository.getPosts()).thenReturn(posts)

        // Initialize use case
        val useCase = GetPostsUseCase(mockRepository)

        // Invoke use case
        val result = runBlocking { useCase() }

        // Assert result
        assertEquals(posts, result)
    }
}
