package com.example.rickymorty.model.dataBase

import android.content.Context
import androidx.room.Room
import com.example.rickymorty.model.dataClass.RickandMorty

@DataBase(entities = [(RickandMorty::class)], version = 1)
abstract DataBasem : RoomDataBase {
    abstract fun getDataModelHeroesDao():Dao



    //Esta linea de codigo indica que es und metodo estatico que se realiza sólo una vez
    companion object{

        //no entiendo por que se debe ocupar volatile
        @Volatile
        private var INSTANCE: DataBasem?= null
        fun getDBPersonajes(context: Context):DataBasem{
            val createdInstance= INSTANCE
            if (createdInstance!=null){
                return createdInstance
            }
            synchronized(this){
                val newInstance= Room.databaseBuilder(context.applicationContext, DataBasem::class.java, "heroes_db")
                    //se necesita cuando se realizan cambios a la database
                    .fallbackToDestructiveMigrationFrom(1,2,3,4,5,6,7)
                    .build()
                INSTANCE= newInstance
                return newInstance
            }

        }

    }
}