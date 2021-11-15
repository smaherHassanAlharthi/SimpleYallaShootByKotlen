package com.example.playgroundapp.api

import com.example.playgroundapp.model.playGround
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET(".")
    fun getBooks(): Call<playgroundList?>?

}

class playgroundList : ArrayList<playGround>()