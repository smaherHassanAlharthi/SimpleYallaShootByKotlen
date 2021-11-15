package com.example.playgroundapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playgroundapp.R
import com.example.playgroundapp.adapter.dbAdapter
import com.example.playgroundapp.model.MyViewModel
import com.example.playgroundapp.model.playgroundTable
import kotlinx.android.synthetic.main.fragment_db.view.*

class DbFragment : Fragment() {
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    var list = ArrayList<playgroundTable>()
    lateinit var mydbAdapter : dbAdapter
    lateinit var rvSavedTvShows: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_db, container, false)
        myViewModel.getplayground().observe(viewLifecycleOwner, {
                tvShowsList ->
            mydbAdapter.update(tvShowsList as ArrayList<playgroundTable>)
        })

        mydbAdapter = dbAdapter(this ,list )
        view.rvDB.adapter = mydbAdapter
        view.rvDB.layoutManager = LinearLayoutManager(this.requireContext())

        // Inflate the layout for this fragment
        return view

    }

}