package com.example.rickymorty.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rickymorty.R
import com.example.rickymorty.model.dataClass.Favorite
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.model.dataClass.RickandMorty
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.holderimage.view.*


class CharacterAdapter(var mAdapterCharacter: MutableList<Results>,var pAdapCharacter: pAdapter): RecyclerView.Adapter<CharacterAdapter.ViewHolderCharacter>() {

   fun updateData(mCharacter:MutableList<Results>?){
        if (mCharacter != null) {
            mAdapterCharacter= mCharacter
        }
        notifyDataSetChanged()
    }


  inner class ViewHolderCharacter(itemView: View): RecyclerView.ViewHolder(itemView){


        fun mbind(result:Results) {
               itemView.charactername.text=result.name
                Picasso.get().load(result.image).placeholder(R.drawable.ic_launcher_background).into(itemView.imageCharacter)
//el tomar el itemView, se refiere al conjunto de vistas que componen el viewholder, lo que vuelve clickeable
          itemView.setOnLongClickListener {
                pAdapCharacter.idFromLonglick(result.id!!)//se le envia el id al fragment para que este se la pase al viewmodel y el viewmodel guarde ese id como favorito
                Toast.makeText(itemView.context," added as favorite", Toast.LENGTH_LONG).show()
              itemView.corazonfavorite.visibility=View.VISIBLE
                true

            }
        }
  }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        return ViewHolderCharacter(LayoutInflater.from(parent.context).inflate(R.layout.holderimage,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
        holder.mbind(mAdapterCharacter[position])
    }

    override fun getItemCount(): Int {
     return mAdapterCharacter.size
    }
    interface pAdapter{
        fun idFromLonglick(id:Int)

    }


}