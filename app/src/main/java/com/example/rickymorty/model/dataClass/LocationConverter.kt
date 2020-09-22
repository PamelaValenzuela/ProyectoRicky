package com.example.rickymorty.model.dataClass

import androidx.room.TypeConverter
import com.google.gson.Gson

class LocationConverter {
    @TypeConverter
    fun listToJson(value: List<Location>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Location>? {

        val objects = Gson().fromJson(value, Array<Location>::class.java) as Array<Location>
        val list = objects.toList()
        return list
    }

}
