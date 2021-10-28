package com.saif.mealz.ui.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(var categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryDescription")  val description: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String
)