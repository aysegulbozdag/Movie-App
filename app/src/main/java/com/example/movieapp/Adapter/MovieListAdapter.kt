package com.example.movieapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Model.PopularList
import com.example.movieapp.R
import com.example.movieapp.databinding.RowItemRvListBinding

class MovieListAdapter(var context: Context, var movieList: ArrayList<PopularList>) :
    RecyclerView.Adapter<MovieListAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ItemHolder {
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


    override fun onBindViewHolder(holder: MovieListAdapter.ItemHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return movieList.size;
    }

    class ItemHolder(itemView: RowItemRvListBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
}