package com.example.playgroundapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.playgroundapp.database.playgroundDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val playgroundDao=playgroundDatabase.getInstance(application).tvShowDao()

    private val allPlaygrounds: LiveData<List<playgroundTable>> = playgroundDao.getplayground()

    fun getplayground(): LiveData<List<playgroundTable>> {
        return allPlaygrounds
    }

     fun addplayground(playground: playgroundTable){
        CoroutineScope(Dispatchers.IO).launch {
            playgroundDao.insertplayground(playground)
        }

    }

    fun deleteplayground(playground: playgroundTable){
        CoroutineScope(Dispatchers.IO).launch {
            playgroundDao.deleteplayground(playground)

        }
    }



}