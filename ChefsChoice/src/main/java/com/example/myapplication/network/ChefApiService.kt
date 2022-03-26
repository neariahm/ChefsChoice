package com.example.myapplication.network

import com.example.myapplication.database.FavoriteEntity
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.spoonacular.com/"

    private val networkLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface ChefTestService {

        @GET("recipes/findByIngredients?apiKey=0b7156ae48984e2091b073fc1fe388dd&number=15&ranking=2")
        suspend fun getPhotos(@Query("ingredients") ingredient: String): List<FavoriteEntity>

        @GET("food/trivia/random?apiKey=0b7156ae48984e2091b073fc1fe388dd")
        suspend fun getTrivia(): Trivia

        @GET("random?apiKey=0b7156ae48984e2091b073fc1fe388dd")
        suspend fun getRandom(): RandomRecipe

        @GET("recipes/{id}/card?apiKey=0b7156ae48984e2091b073fc1fe388dd")
        suspend fun getRecipe(@Path("id") recipeId: String) : RecipeCard

        @GET("recipes/complexSearch?apiKey=0b7156ae48984e2091b073fc1fe388dd&cuisine=american&sort=popularity&number=3")
        suspend fun getPopular() : ComplexSearch

        @GET("recipes/complexSearch?apiKey=0b7156ae48984e2091b073fc1fe388dd&type=dessert&sort=random&number=3")
        suspend fun getDessert() : ComplexSearch

        @GET("recipes/complexSearch?apiKey=0b7156ae48984e2091b073fc1fe388dd&maxReadyTime=30&sort=random&number=3")
        suspend fun getQuick() : ComplexSearch

        @GET("food/products/upc/{upc}/?apiKey=0b7156ae48984e2091b073fc1fe388dd")
        suspend fun getBarcode(@Path("upc") upc: String): Upc
    }
    object ChefApi {
        val retrofitService : ChefTestService by lazy {
            retrofit.create(ChefTestService::class.java)
        }
    }

