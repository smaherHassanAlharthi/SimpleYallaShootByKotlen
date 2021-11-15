package com.example.playgroundapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.playgroundapp.fragment.ApiFragment
import com.example.playgroundapp.R
import com.example.playgroundapp.api.playgroundList
import com.example.playgroundapp.model.playgroundTable
import kotlinx.android.synthetic.main.api_item_row.view.*

class SearchBookAdapter(private var playgroundList: playgroundList,val apiFragment: ApiFragment) : RecyclerView.Adapter<SearchBookAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.api_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var book = playgroundList[position]

        holder.itemView.apply {
            tvTitle.text = book.name
            tvDescription.text = book.description
            Glide.with(this)
                .load(book.pictures?.get(0))
                .into(playgroundImage)
        }
        holder.itemView.setOnClickListener{
            apiFragment.myViewModel.addplayground(playgroundTable(0,book.name!!,book.description!!, book.pictures!![0]))
            Toast.makeText(apiFragment.context, "Added successfully to local database!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = playgroundList.size


}