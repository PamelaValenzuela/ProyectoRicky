package com.example.rickymorty.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Info(
 val count: Int?,
 val pages: Int?,
 val next: String?,
 val prev: String?
) {
}