package com.example.newsapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL: String = "https://newsapi.org/v2/"

//const val API_KEY : String = "f83526809bc44fa88ab7de1748dfb289"
//changes from Api to news
interface ApiInterface {

//    @GET("top-headlines?apiKey=$API_KEY")

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apikey: String
    )
            : Call<MainNews>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apikey: String
    )
            : Call<MainNews>

}
//creating singleton object for retrofit
//object ApiInterface {
//
//    val newsInstance : NewsInterface
//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
////        implementation of NewsInterface
//        newsInstance = retrofit.create(NewsInterface::class.java)
//
//    }
//}