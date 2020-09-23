package com.example.rickymorty.model.dataClass

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
@Entity(tableName = "tableresults")
data class Results(
 @PrimaryKey val id: Int?,
 val name: String?,
 val status: String?,
 val species: String?,
 val type: String?,
 val gender: String?,
 val image: String?,
)