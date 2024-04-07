package com.example.mvvm_cleanarchitecture_pattern.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post
import com.example.mvvm_cleanarchitecture_pattern.domain.use_cases.GetPostsUseCase
import junit.framework.Assert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PostListViewModelTest {

    private lateinit var viewModel: PostListViewModel
    private lateinit var useCase: GetPostsUseCase
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        useCase = mock(GetPostsUseCase::class.java)
        viewModel = PostListViewModel(useCase)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    suspend fun fetchPosts_shouldUpdatePostsLiveData() {
        // Given
        val posts = listOf(
            Post(1, 1, "Title 1", "Body 1"),
            Post(2, 2, "Title 2", "Body 2")
        )
        `when`(useCase.invoke()).thenReturn(posts)

        // When
        viewModel.fetchPosts()

        // Then
        val result = viewModel.posts.value
        Assert.assertEquals(posts, result)
    }
}