package com.example.playgroundapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.playgroundapp.fragment.DbFragment
import com.example.playgroundapp.R
import com.example.playgroundapp.model.MyViewModel
import com.example.playgroundapp.model.playgroundTable
import kotlinx.android.synthetic.main.db_item_row.view.*

class dbAdapter (private val fragment: DbFragment, private var list: ArrayList<playgroundTable>):  RecyclerView.Adapter<dbAdapter.ItemViewHolder>(){
   private val myViewModel by lazy { ViewModelProvider(fragment).get(MyViewModel::class.java) }

    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.db_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var data = list[position]

        holder.itemView.apply {
            if(data.imageURL.isNotEmpty()){
                Glide.with(this)
                    .load(data.imageURL)
                    .into(playgroundImageDB)
            }

            tvTitleDB.text = data.name

            deleteButtonDB.setOnClickListener {
                myViewModel.deleteplayground(playgroundTable(data.id,data.name,data.description,data.imageURL))
                Toast.makeText(fragment.requireContext(),"${data.name} deleted",Toast.LENGTH_LONG).show()
            }
            holder.itemView.setOnClickListener{
                Toast.makeText(fragment.requireContext(),data.description,Toast.LENGTH_LONG).show()
            }

        }
    }


    override fun getItemCount() = list.size

    fun update(list: ArrayList<playgroundTable>){
        this.list = list
        notifyDataSetChanged()
    }
}