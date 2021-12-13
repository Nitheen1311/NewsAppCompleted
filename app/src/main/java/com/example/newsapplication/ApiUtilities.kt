package com.example.newsapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtilities {

    //creating singleton object for retrofit
    object getApiInterface {

        //        lateinit var newsInstance : ApiInterface
//        init {
//            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
////        implementation of NewsInterface
//            retrofit.create(ApiInterface::class.java)
//
//        }
        val instance: ApiInterface by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApiInterface::class.java)
        }

    }

}