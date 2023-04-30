package com.example.disher.category.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.category.data.model.Category
import com.example.disher.category.domain.use_case.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val getCategories: IGetCategoriesUseCase
) : ViewModel() {
    private val _categories: MutableState<List<Category>> = mutableStateOf(emptyList())
    val categories: State<List<Category>> = _categories

    init {
        viewModelScope.launch {
            val categoryResponse = getCategories()
            _categories.value = categoryResponse.categories
        }
    }
}