package com.example.playgroundapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.playgroundapp.model.playgroundTable

@Database(entities = [playgroundTable::class],version = 1,exportSchema = false)
abstract class playgroundDatabase: RoomDatabase() {

    companion object{
        var instance: playgroundDatabase?=null;
        fun getInstance(ctx: Context): playgroundDatabase
        {
            if(instance !=null)
            {
                return  instance as playgroundDatabase;
            }
            instance = Room.databaseBuilder(ctx, playgroundDatabase::class.java,"playgroundDB").run { allowMainThreadQueries() }.build()
            return instance as playgroundDatabase;
        }
    }
    abstract fun tvShowDao(): playgroundDao;
}