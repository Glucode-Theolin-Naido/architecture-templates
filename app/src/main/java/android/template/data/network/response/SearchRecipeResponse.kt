package android.template.data.network.response

import androidx.core.net.toUri
import com.google.gson.annotations.SerializedName

data class SearchRecipeResponse(
    @SerializedName("results")
    val results: List<SearchRecipeResultResponse>
)

data class SearchRecipeResultResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
)

//fun SearchRecipeResultResponse.toDomain() = Recipe(
//    id = id,
//    title = title,
//    imageUrl = image.toUri(),
//    isFavourite = false
//)