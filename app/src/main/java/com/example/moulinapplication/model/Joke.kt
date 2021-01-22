package com.example.moulinapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "joke_data_table")
data class Joke(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "joke_id")
    val id: Int,
    @ColumnInfo(name = "joke_punchline")
    val punchline: String,
    @ColumnInfo(name = "joke_setup")
    val setup: String,
    @ColumnInfo(name = "joke_type")
    val type: String

) : Serializable



