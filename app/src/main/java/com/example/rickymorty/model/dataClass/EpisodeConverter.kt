package com.example.rickymorty.model.dataClass

import androidx.room.TypeConverter
import com.google.gson.Gson

class EpisodeConverter {
    @TypeConverter
    fun listToJson(value: List<Episode>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Episode>? {

        val objects = Gson().fromJson(value, Array<Episode>::class.java) as Array<Episode>
        val list = objects.toList()
        return list
    }

}
