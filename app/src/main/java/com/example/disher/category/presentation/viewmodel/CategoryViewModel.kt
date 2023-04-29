package com.example.disher.category.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val getCategories: IGetCategoriesUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            val categoryResponse = getCategories()
            categoryResponse.categories.forEach {
                Log.d("BK",it.strCategory)
            }
        }
    }
}