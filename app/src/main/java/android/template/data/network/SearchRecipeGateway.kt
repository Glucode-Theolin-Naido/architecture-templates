package android.template.data.network

import android.template.data.network.api.SpoonacularApi
import android.template.data.network.response.SearchRecipeResponse
import com.example.recipeonboardingproject.common.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface SearchRecipeGateway {
    suspend fun searchRecipe(recipeToSearch: String): Flow<DataResult<SearchRecipeResponse>>
}

class SearchRecipeGatewayImpl @Inject constructor(
    private val api: SpoonacularApi
) : SearchRecipeGateway {
    override suspend fun searchRecipe(recipeToSearch: String): Flow<DataResult<SearchRecipeResponse>> =
        flow {
            try {
                emit(DataResult.Loading())
                val recipe = api.searchRecipes(recipeToSearch)
                emit(
                    DataResult.Success(
                        recipe
                    )
                )
            } catch (e: HttpException) {
                emit(DataResult.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(DataResult.Error("Couldn't reach server. Check your internet connection."))
            }
        }
}