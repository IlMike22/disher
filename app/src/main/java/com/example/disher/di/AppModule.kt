package com.example.disher.di

import com.example.disher.category.data.repository.CategoryRepository
import com.example.disher.category.data.service.ICategoryService
import com.example.disher.category.domain.repository.ICategoryRepository
import com.example.disher.category.domain.use_case.GetCategoriesUseCase
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit): ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {
        @Binds
        @Singleton
        fun provideCategoryRepository(repository: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideGetCateogoryUseCase(useCase: GetCategoriesUseCase): IGetCategoriesUseCase
    }
}