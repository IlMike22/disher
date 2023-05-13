package com.example.disher.detail.data.service

import com.example.disher.detail.data.model.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDetailService {
    @GET("lookup.php")
    suspend fun getDetailsForDish(
        @Query("i") mealId: String
    ): DetailResponse
}