package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.RowItemRvListBinding
import com.example.movieapp.model.Results

class MovieListAdapter(var context: Context) :
    RecyclerView.Adapter<MovieListAdapter.ItemHolder>() {
    var movieList = ArrayList<Results>()

    fun setUpdatedData(movieList: ArrayList<Results>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        context = parent.context

        val inflater = LayoutInflater.from(context);
        val view = DataBindingUtil.inflate<RowItemRvListBinding>(
            inflater,
            R.layout.row_item_rv_list,
            parent,
            false
        )
//        val itemHolder =
//            LayoutInflater.from(parent.context).inflate(R.layout.row_item_rv_list, parent, false)

        return ItemHolder(view);
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.view.txtMovieTitle.text = movieList[position].original_title
        val url = "https://image.tmdb.org/t/p/w500/" + movieList[position].poster_path;

        Glide.with(context)
            .load(url)
            .into(holder.view.ivMovie)

    }

    override fun getItemCount(): Int {
        return movieList.size;
    }

    class ItemHolder(var view: RowItemRvListBinding) : RecyclerView.ViewHolder(view.root) {

    }
}