package com.example.rickymorty.model.dataClass

import androidx.room.TypeConverter
import com.google.gson.Gson

class ResultsConverter {
    @TypeConverter
    fun listToJson(value: List<Results>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Results>? {

        val objects = Gson().fromJson(value, Array<Results>::class.java) as Array<Results>
        val list = objects.toList()
        return list
    }

}
