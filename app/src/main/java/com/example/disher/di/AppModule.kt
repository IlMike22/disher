package com.example.disher.di

import com.example.disher.category.data.repository.CategoryRepository
import com.example.disher.category.domain.repository.ICategoryRepository
import com.example.disher.category.domain.use_case.GetCategoriesUseCase
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

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