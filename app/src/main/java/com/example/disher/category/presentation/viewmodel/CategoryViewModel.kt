package com.example.disher.category.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel@Inject constructor(
    val getCategories: IGetCategoriesUseCase
) : ViewModel() {
    init {
        getCategories()
    }
}