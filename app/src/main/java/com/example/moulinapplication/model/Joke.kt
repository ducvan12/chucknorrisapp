package com.example.moulinapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * TODO
 *
 * @property id
 * @property punchline
 * @property setup
 * @property type
 * @property numberOfStars
 */
@Entity(tableName = "joke_data_table")
data class Joke(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "joke_id")
    val id: Int,
    @ColumnInfo(name = "joke_punchline")
    var punchline: String,
    @ColumnInfo(name = "joke_setup")
    var setup: String,
    @ColumnInfo(name = "joke_type")
    val type: String,
    @ColumnInfo(name = "joke_number_Of_Stars")
    var numberOfStars: Float

) : Serializable
