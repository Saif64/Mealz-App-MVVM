package com.saif.mealz.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.saif.mealz.ui.model.MealsRepository
import com.saif.mealz.ui.model.response.MealResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,

    ) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository: MealsRepository = MealsRepository.getInstance()

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""

        mealState.value = repository.getMeal(mealId)
    }
}