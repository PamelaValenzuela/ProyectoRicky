package com.example.rickymorty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickymorty.R
import com.example.rickymorty.model.dataClass.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favoriteviewholder.view.*

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.ViewHolderFavorite>(){





    inner class ViewHolderFavorite(item : View):RecyclerView.ViewHolder(item){
        fun mbind(result: ) {

            itemView.respuestanombre.text=result.name
            Picasso.get().load(result.image).placeholder(R.drawable.ic_launcher_background).into(itemView.imagefavorite)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavorite {
      return ViewHolderFavorite(LayoutInflater.from(parent.context).inflate(R.layout.favoriteviewholder,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderFavorite, position: Int) {
       holder.mbind(mAdapterfavorite[position])
    }

    override fun getItemCount(): Int {
    return mAdapterfavorite.size
    }
}