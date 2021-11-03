package com.saif.mealz.ui.model

import com.saif.mealz.ui.model.api.MealApi
import com.saif.mealz.ui.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealApi = MealApi()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}