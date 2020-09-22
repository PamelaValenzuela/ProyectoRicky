package com.example.rickymorty.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickymorty.R
import com.example.rickymorty.model.dataClass.Results
import com.example.rickymorty.viewModel.ViewModelRick
import kotlinx.android.synthetic.main.fragment_fragmentimage.*

class Fragmentimage : Fragment(), CharacterAdapter.pAdapter{
    private lateinit var rickVM: ViewModelRick
    private lateinit var mAdapterfrag:CharacterAdapter
    //pagina inicial
    var page=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           rickVM= ViewModelProvider(activity!!).get(ViewModelRick::class.java)
            mAdapterfrag= CharacterAdapter(mutableListOf(),this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentimage, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rickVM.InsertDataVM(page)

        nested_scrollview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (v != null) {
                if(scrollY== v.getChildAt(0)?.measuredHeight!! - v.measuredHeight){
                    if(page<34){
                        page++
                        Log.d("Pame","pagina numero $page")
                        myprogressbar.visibility=View.VISIBLE
                        rickVM.InsertDataVM(page)
                      myprogressbar.visibility=View.GONE
                    }else{
                        myendofline.visibility=View.VISIBLE
                    }
                }
            }
        })
        rickVM.getRicky().observe(viewLifecycleOwner,{
            mAdapterfrag.updateData(it as MutableList<Results>)})
        myrecycler.adapter=mAdapterfrag
        myrecycler.layoutManager=GridLayoutManager(activity,5)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragmentimage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            Fragmentimage().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun id(id: Int) {
    // activity?.supportFragmentManager!!.beginTransaction().addToBackStack("popular").replace(R.id.frameLayout,MovieDetailsFragment.newInstance(id)).commit()
    }
}