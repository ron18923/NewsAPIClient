package com.example.newsapiclient.data.db

import androidx.room.TypeConverter
import com.example.newsapiclient.data.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String? = source.name

    @TypeConverter
    fun toResource(sourceName: String): Source = Source(sourceName, sourceName)

}