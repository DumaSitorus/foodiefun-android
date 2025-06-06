package com.duma.foodiefun.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromStringList(value: String?): List<String> {
        return value?.let {
            val type = object : TypeToken<List<String>>() {}.type
            Gson().fromJson(it, type)
        } ?: emptyList()
    }

    @TypeConverter
    fun toStringList(list: List<String>?): String {
        return Gson().toJson(list)
    }
}