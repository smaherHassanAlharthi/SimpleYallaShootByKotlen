package com.example.playgroundapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.playgroundapp.model.playgroundTable

//Data Access Object
@Dao
interface playgroundDao {

    @Query("SELECT * FROM playGrounds")
    fun getplayground(): LiveData<List<playgroundTable>>


    @Insert
    fun insertplayground(playground: playgroundTable)


    @Delete
    fun deleteplayground(playground: playgroundTable)

}