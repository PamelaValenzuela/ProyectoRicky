package com.example.rickymorty.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.rickymorty.model.dataClass.Favorite
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.model.dataClass.RickandMorty
import com.example.rickymorty.model.repository.RepositoryRick
import kotlinx.coroutines.launch

class ViewModelRick(application: Application): AndroidViewModel(application) {

    private val mRepositoryVM=RepositoryRick(application)


    fun InsertDataVM(page:Int){
        mRepositoryVM.insertdataDB(page)
    }

    fun getRicky(): LiveData<List<Results>> {
        return mRepositoryVM.getPersonajesFromDB()
    }

        fun insertfavVM(id: Int) {
        viewModelScope.launch {
            mRepositoryVM.saveFavoriteRepo(id)
        }


    }
        fun getallVMrepo(): LiveData<List<Favorite>>{
        return  mRepositoryVM.getAllFavDao()
         }

         fun deleteFavMovie(id:Int){
             viewModelScope.launch {
                 mRepositoryVM.deleteFavoriterepo(id)
             }



        }


}