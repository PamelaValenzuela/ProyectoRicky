package com.example.rickymorty.model.dataClass

import androidx.room.TypeConverters

class Results(
 val id: Int?,
 val name: String,
 val status: String,
 val species: String,
 val type: String,
 val gender: String,
 @TypeConverters()






) {
}