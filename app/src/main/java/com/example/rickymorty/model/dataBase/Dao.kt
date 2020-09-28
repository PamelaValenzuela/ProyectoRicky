package com.example.rickymorty.model.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickymorty.model.dataClass.Favorite
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.model.dataClass.RickandMorty
@Dao
interface Dao {
    //Preguntar por que este debe tener onConflict, este sirve para mantener actualizado los nombres
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPersonajes(mPersonajes: List<Results>)

    //cuando agregas livedata no se requiere suspend
    @Query("SELECT * FROM tableresults" )
    fun getAllPersonajes(): LiveData<List<Results>>

    // para favoritos

    @Query("SELECT * FROM tableresults where id=:idfavorite" )
    fun getfavorite(idfavorite: Int): Results

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertfavorite(mFavorite: Favorite)

    @Query("SELECT * FROM tableFavorite" )
    fun getallfavorite(): LiveData<List<Favorite>>


}