package com.example.playgroundapp.model

import com.google.gson.annotations.SerializedName

data class playGround(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("picture")
    val pictures: List<String>?
)

