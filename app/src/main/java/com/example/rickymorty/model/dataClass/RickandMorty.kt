package com.example.rickymorty.model.dataClass


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters



data class RickandMorty (

 val info: Info,
 val results:List<Results>

)