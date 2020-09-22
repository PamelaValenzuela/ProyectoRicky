package com.example.rickymorty.model.retrofit

import com.example.rickymorty.model.dataClass.RickandMorty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofit {

    @GET("character")
    fun getAllcharacterFromApi(@Query("page")page:Int):Call<RickandMorty>
}