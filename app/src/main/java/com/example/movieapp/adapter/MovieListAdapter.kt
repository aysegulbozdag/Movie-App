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

        return ItemHolder(view);
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.view.txtMovieTitle.text = movieList[position].original_title
        holder.view.txtVoteAvarage.text = movieList[position].vote_average.toString()
        holder.view.txtReleaseDate.text = movieList[position].release_date;
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