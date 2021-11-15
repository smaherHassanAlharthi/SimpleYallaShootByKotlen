package com.example.playgroundapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playGrounds")
data class playgroundTable (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id") val id : Int = 0, // this is how can include id if needed
    @ColumnInfo(name = "name") var name: String ,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "image") var imageURL: String,)

