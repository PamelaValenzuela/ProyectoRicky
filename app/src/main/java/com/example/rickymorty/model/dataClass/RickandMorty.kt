package com.example.rickymorty.model.dataClass


import androidx.room.Entity
import androidx.room.TypeConverters

@Entity(tableName = "tableRicky")
data class RickandMorty (
    val mInfo: Info,
    @TypeConverters(ResultsConverter::class) val mResults:List<Results>?

)