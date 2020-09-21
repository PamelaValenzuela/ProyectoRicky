package com.example.rickymorty.model.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickymorty.model.dataClass.RickandMorty

interface Dao {
    //Preguntar por que este debe tener onConflict, este sirve para mantener actualizado los nombres
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPersonajes(mPersonajes:RickandMorty)

    //cuando agregas livedata no se requiere suspend
    @Query("SELECT * FROM tableRicky" )
    fun getAllPersonajes(): LiveData<RickandMorty>
}