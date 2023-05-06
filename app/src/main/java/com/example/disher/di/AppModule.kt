package com.example.disher.di

import com.example.disher.category.data.repository.CategoryRepository
import com.example.disher.category.data.service.ICategoryService
import com.example.disher.category.domain.repository.ICategoryRepository
import com.example.disher.category.domain.use_case.GetCategoriesUseCase
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import com.example.disher.dishes.data.repository.DishesRepository
import com.example.disher.dishes.data.service.IDishesService
import com.example.disher.dishes.domain.GetDishesUseCase
import com.example.disher.dishes.domain.IDishesRepository
import com.example.disher.dishes.domain.IGetDishesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun providesDishesService(retrofit: Retrofit): IDishesService {
        return retrofit.create(IDishesService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {
        @Binds
        @Singleton
        fun provideCategoryRepository(repository: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideDishesRepository(repository: DishesRepository): IDishesRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(useCase: GetCategoriesUseCase): IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideGetDishesUseCase(useCase: GetDishesUseCase): IGetDishesUseCase
    }
}