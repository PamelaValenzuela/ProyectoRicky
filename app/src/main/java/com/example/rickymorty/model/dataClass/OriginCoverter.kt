package com.example.rickymorty.model.dataClass

import androidx.room.TypeConverter
import com.google.gson.Gson

class OriginCoverter {
    @TypeConverter
    fun listToJson(value: List<Origin>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Origin>? {

        val objects = Gson().fromJson(value, Array<Origin>::class.java) as Array<Origin>
        val list = objects.toList()
        return list
    }

}
