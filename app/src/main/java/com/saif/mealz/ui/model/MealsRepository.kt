package com.saif.mealz.ui.model

import com.saif.mealz.ui.model.api.MealsWebService
import com.saif.mealz.ui.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}