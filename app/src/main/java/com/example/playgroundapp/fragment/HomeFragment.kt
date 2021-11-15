package com.example.playgroundapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.playgroundapp.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_home, container, false)

        view.apiButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_apiFragment)
        }

        view.dbButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_dbFragment)
        }

        return view
    }


}