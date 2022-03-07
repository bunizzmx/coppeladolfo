package com.example.android.examenadolfo.presentation.ui.tvs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.examenadolfo.R
import com.example.android.examenadolfo.data.network.model.response.Tv

class HeroesComicsAdapter (context :Context, listener: OpenHeroListener): RecyclerView.Adapter<HeroesComicsAdapter.CajerosHolder>() {
    val TYPE_TV :Int =0
    lateinit var context:Context
    var  listener: OpenHeroListener
    lateinit var items:ArrayList<Tv>
    init {
        this.items= arrayListOf()
        this.context = context
        this.listener=listener
    }

    fun setTvsItems(items:ArrayList<Tv>)
    {
        this.items = items
        notifyDataSetChanged()
    }

    fun load_more(items:ArrayList<Tv>)
    {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private fun getInflatedView(parent: ViewGroup, resourceLayout: Int): View? {
        return LayoutInflater
            .from(parent.context)
            .inflate(resourceLayout, parent, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CajerosHolder {
        var  view: View?
        view = getInflatedView(parent, R.layout.item_tv)
        return   CajerosHolder(view!!)


    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_TV
    }

    override fun onBindViewHolder(holder: CajerosHolder, position: Int) {
        holder.bind(items[position], listener)

    }

    override fun getItemCount(): Int {
        if(items!=null)
            return  items.size
        else return  0
    }

    class CajerosHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_tv: TextView
        val image_tv:ImageView
        val vote_average:TextView
        init {
            name_tv = itemView.findViewById(R.id.name_tv)
            image_tv = itemView.findViewById(R.id.image_tv)
            vote_average = itemView.findViewById(R.id.vote_average)
        }

        fun bind(item: Tv, listener: OpenHeroListener) = with(itemView) {
            name_tv.text = item.name
           // vote_average.text = item
            Glide.with(context)
                .load(item.thumbnail?.path+"."+item.thumbnail?.extension)
                .into(image_tv)
            image_tv.setOnClickListener {
                listener.open(item)
            }
           //setOnClickListener { listener(item) }
        }
    }
}