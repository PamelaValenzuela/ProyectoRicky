package com.example.rickymorty.model.retrofit

import com.example.rickymorty.model.dataClass.RickandMorty
import retrofit2.http.GET

interface ApiRetrofit {

    @GET("character")
    suspend fun getAllcharacterFromApi():List<RickandMorty>
}