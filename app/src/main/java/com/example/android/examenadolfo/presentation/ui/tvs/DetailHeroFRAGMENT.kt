package com.example.android.examenadolfo.presentation.ui.tvs

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide

import com.example.android.examenadolfo.presentation.common.viewBinding


import com.example.android.examenadolfo.R
import com.example.android.examenadolfo.data.network.model.response.Tv
import com.example.android.examenadolfo.databinding.DetailHeroFragmentBinding


class DetailHeroFRAGMENT  : Fragment() {



    private val authViewModel by activityViewModels<HeroesViewModel>()
    private val binding by viewBinding(DetailHeroFragmentBinding::bind)
    lateinit var  adapter: HeroesComicsAdapter
    var data:Tv? = null
    var append_comics:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_hero_fragment, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.get("data_hero") as Tv
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun applyBinding() {
        with(binding) {
            if(!data?.description.isNullOrEmpty())
             binding.descripcion.setText(data?.description)
            else
                binding.descripcion.setText("NO EXISTE DESCRIPCIÓN")

            for (name in data?.comics?.items!!) {
                append_comics+=" - "+name.name+"\n"
            }
            binding.COMICSLIST.setText(append_comics)
            Glide.with(requireActivity())
                .load(data?.thumbnail?.path+"."+data?.thumbnail?.extension)
                .into(binding.imageTv)
        }
    }

    override fun onResume() {
        super.onResume()
    }








}



