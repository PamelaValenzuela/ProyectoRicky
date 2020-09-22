package com.example.rickymorty.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableInfo")
data class Info(
 val count: Int?,
 @PrimaryKey val pages: Int?,
 val next: String?,
 val prev: String?
) {
}