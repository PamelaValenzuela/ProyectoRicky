package com.example.rickymorty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickymorty.R
import com.example.rickymorty.model.dataClass.Favorite
import com.example.rickymorty.model.dataClass.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favoriteviewholder.view.*

class FavoriteAdapter(): RecyclerView.Adapter<FavoriteAdapter.ViewHolderFavorite>(){
    private var mfavset:MutableList<Favorite> = mutableListOf()

    fun updateData(mFavoriteupdate:MutableList<Favorite>?){
        if (mFavoriteupdate!= null) {
            mfavset= mFavoriteupdate
        }
        notifyDataSetChanged()
    }

    fun deletefavorite(position: Int){
        mfavset.removeAt(position)
        notifyDataSetChanged()
    }
    fun getFav(position: Int): Favorite {
        return mfavset[position]
    }



    inner class ViewHolderFavorite(item : View):RecyclerView.ViewHolder(item){
        fun mbind(result: Favorite) {
            itemView.respuestanombre.text=result.nombre
            itemView.respStatus.text=result.status
            itemView.respspecies.text=result.species
            Picasso.get().load(result.image).placeholder(R.drawable.ic_launcher_background).into(itemView.imagefavorite)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavorite {
      return ViewHolderFavorite(LayoutInflater.from(parent.context).inflate(R.layout.favoriteviewholder,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderFavorite, position: Int) {
       holder.mbind(mfavset[position])
    }

    override fun getItemCount(): Int {
    return mfavset.size
    }
}