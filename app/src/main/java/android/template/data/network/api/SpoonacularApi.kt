package android.template.data.network.api

import android.template.data.network.response.SearchRecipeResponse
import com.example.recipeonboardingproject.common.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {
    @GET("/recipes/complexSearch?apiKey=${Constants.SPOONACULAR_API_KEY}")
    suspend fun searchRecipes(@Query("query") query: String): SearchRecipeResponse

}