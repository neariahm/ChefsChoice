package com.example.myapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
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
        @GET("recipes/findByIngredients?apiKey=16c7675b72404cf5b7dd4b41afb2d195&number=15&ranking=2")
        suspend fun getPhotos(@Query("ingredients") ingredient: String): List<Recipes>

        @GET("food/trivia/random?apiKey=16c7675b72404cf5b7dd4b41afb2d195")
        suspend fun getTrivia(): Trivia

        @GET("random?apiKey=16c7675b72404cf5b7dd4b41afb2d195&number=1")
        suspend fun getRandom(): RandomRecipe

        @GET("recipes/{id}/card?apiKey=16c7675b72404cf5b7dd4b41afb2d195&mask=potMask")
        suspend fun getRecipe() : RecipeCard

        @GET("recipes/findByIngredients?apiKey=16c7675b72404cf5b7dd4b41afb2d195&ingredients=beef&number=7&ranking=2&sort=popularity")
       // @GET("recipes/complexSearch?apiKey=16c7675b72404cf5b7dd4b41afb2d195&cuisine=american&sort=popularity&number=10")
        suspend fun getPopular() : List<ComplexSearchData>
    }
    object ChefApi {
        val retrofitService : ChefTestService by lazy {
            retrofit.create(ChefTestService::class.java)
        }
    }

