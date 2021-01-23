package com.example.moulinapplication.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moulinapplication.model.Joke

@Database(entities = [Joke::class],version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract val JokeDAO : JokeDao

    companion object{
        @Volatile
        private var INSTANCE : RoomDB? = null
        fun getInstance(context: Context):RoomDB{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java,
                        "RoomDB"
                    ).build()
                }
                return instance
            }
        }

    }
}