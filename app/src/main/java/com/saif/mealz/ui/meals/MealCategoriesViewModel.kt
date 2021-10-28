package com.saif.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.saif.mealz.ui.model.MealsRepository
import com.saif.mealz.ui.model.response.MealsCategoriesResponse

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
         repository.getMeals { response ->
             successCallback(response)
        }
    }
}