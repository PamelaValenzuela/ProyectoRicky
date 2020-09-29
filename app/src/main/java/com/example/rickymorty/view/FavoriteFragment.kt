package com.example.rickymorty.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickymorty.R
import com.example.rickymorty.model.dataClass.Favorite
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.viewModel.ViewModelRick
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_fragmentimage.*

private lateinit var mFavVM:ViewModelRick
private lateinit var mAdapterfav: FavoriteAdapter
var page=1

class FavoriteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mFavVM = ViewModelProvider(activity!!).get(ViewModelRick::class.java)
            mAdapterfav = FavoriteAdapter()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFavVM.getallVMrepo()
        mFavVM.getallVMrepo().observe(viewLifecycleOwner, {
            mAdapterfav.updateData(it as MutableList<Favorite>?)
        })

        recyclerfav.adapter = mAdapterfav
        recyclerfav.layoutManager = LinearLayoutManager(activity)}

        companion object {


            @JvmStatic
            fun newInstance() =
                FavoriteFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
        }
    }







