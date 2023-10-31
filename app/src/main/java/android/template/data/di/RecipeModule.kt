package android.template.data.di

import android.template.data.network.SearchRecipeGateway
import android.template.data.network.SearchRecipeGatewayImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RecipeModule {

    @Binds
    @Singleton
    abstract fun searchRecipesGateway(impl: SearchRecipeGatewayImpl): SearchRecipeGateway

}


