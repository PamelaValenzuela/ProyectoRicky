package com.example.rickymorty.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "tableResults")
data class Results(
 @PrimaryKey val id: Int?,
 val name: String?,
 val status: String?,
 val species: String?,
 val type: String?,
 val gender: String?,
@TypeConverters(OriginCoverter::class) val origin: List<Origin>?,
 @TypeConverters(LocationConverter::class) val location: List<Location>?,
 @TypeConverters(StringListConverter::class) val image: List<String>?,
 @TypeConverters(EpisodeConverter::class) val episode: List<Episode>?
)