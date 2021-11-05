package com.saif.mealz.ui.model

import com.saif.mealz.ui.model.api.MealApi
import com.saif.mealz.ui.model.response.MealResponse
import com.saif.mealz.ui.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealApi = MealApi()) {
    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}