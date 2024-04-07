package com.example.mvvm_cleanarchitecture_pattern.data.di
import com.example.mvvm_cleanarchitecture_pattern.data.network.ApiService
import com.example.mvvm_cleanarchitecture_pattern.data.repository.PostRepositoryImpl
import com.example.mvvm_cleanarchitecture_pattern.domain.repository.PostRepository
import com.example.mvvm_cleanarchitecture_pattern.domain.use_cases.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(apiService: ApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetPostsUseCase(postRepository: PostRepository): GetPostsUseCase {
        return GetPostsUseCase(postRepository)
    }
}