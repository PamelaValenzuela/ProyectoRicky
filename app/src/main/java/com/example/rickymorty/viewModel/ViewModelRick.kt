package com.example.rickymorty.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.model.dataClass.RickandMorty
import com.example.rickymorty.model.repository.RepositoryRick

class ViewModelRick(application: Application): AndroidViewModel(application) {

    private val mRepositoryVM=RepositoryRick(application)


    fun InsertDataVM(page:Int){
        mRepositoryVM.insertdataDB(page)
    }

    fun getRicky(): LiveData<List<Results>> {
        return mRepositoryVM.getPersonajesFromDB()
    }





    /*MOVIE FAVORITE

    fun getAllFavoriteMoviesFromDB(): LiveData<List<MovieFavorite>> {
        return repository.getFavoriteMovies()
    }

    fun saveFavoriteById(id: Int){
        return repository.saveFavoriteById(id)
    }
    fun deleteFavMovie(id:Int){
        repository.deleteFavoriteMovieById(id)
    }*/
}