package com.example.rickymorty.model.dataClass


import androidx.room.TypeConverters


data class RickandMorty (
    val mInfo: Info,
    @TypeConverters(ResultsConverter::class) val mResults:List<Results>?

)