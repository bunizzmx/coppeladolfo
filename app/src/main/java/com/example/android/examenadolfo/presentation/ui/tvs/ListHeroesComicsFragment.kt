package com.example.android.examenadolfo.presentation.ui.tvs

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.android.examenadolfo.presentation.common.viewBinding
import com.example.android.examenadolfo.utils.EventObserver


import com.example.android.examenadolfo.R
import com.example.android.examenadolfo.data.network.model.response.Tv
import com.example.android.examenadolfo.databinding.FragmentListTvsBinding
import com.example.android.examenadolfo.utils.NetworkConnection
import java.io.Serializable
import kotlin.collections.ArrayList


class ListHeroesComics  : Fragment() {



    private val authViewModel by activityViewModels<HeroesViewModel>()
    private val binding by viewBinding(FragmentListTvsBinding::bind)
    lateinit var  adapter: HeroesComicsAdapter
    lateinit var layoutManager : GridLayoutManager
    var isLoading:Boolean=false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_tvs, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyBinding()
        observeEvents()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun applyBinding() {
        with(binding) {
            adapter = HeroesComicsAdapter(requireActivity(),object  :
                OpenHeroListener {
                override fun open(data:Tv) {
                    var  b = Bundle()
                    b.putSerializable("data_hero",data as Serializable)
                    findNavController().navigate(R.id.action_second_fragment_to_detailHeroFRAGMENT,b)
                }
            })
            binding.recyclerview.adapter = adapter
            layoutManager =  GridLayoutManager( requireContext(),2)
            binding.recyclerview.layoutManager = layoutManager
            }
            binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val linearLayoutManager = recyclerView.layoutManager as GridLayoutManager?
                    if (!isLoading) {
                        if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (adapter.items.size -1)) {
                            if (NetworkConnection.hasInternetConnection(requireActivity())) {}
                            authViewModel.getTvs(adapter.items.size.toString(),true)
                            isLoading = true
                        }
                    }
                }
            })
            authViewModel.getTvs("0",false)

    }



    override fun onResume() {
        super.onResume()
    }

    private fun observeEvents() {
        authViewModel.heroesResponse?.observe(viewLifecycleOwner,EventObserver{ tvs ->
            isLoading =false
            with(binding) {
                binding.tipesResults.setText(getString(R.string.list_online))
            }
            adapter.setTvsItems(tvs as ArrayList<Tv>)
        })
        authViewModel.heroesResponseMore?.observe(viewLifecycleOwner,EventObserver{ tvs ->
            isLoading =false
            adapter.load_more(tvs as ArrayList<Tv>)
        })
    }


}



