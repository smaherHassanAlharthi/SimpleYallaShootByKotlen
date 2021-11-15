package com.example.playgroundapp.fragment

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playgroundapp.R
import com.example.playgroundapp.adapter.SearchBookAdapter
import com.example.playgroundapp.api.APIClient
import com.example.playgroundapp.api.APIInterface
import com.example.playgroundapp.api.playgroundList
import com.example.playgroundapp.model.MyViewModel
import kotlinx.android.synthetic.main.fragment_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiFragment : Fragment() {
    private lateinit var rvAdapter:SearchBookAdapter
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_api, container, false)

        createApiInterface("spongebob")
        return view
    }

    private fun createApiInterface(keyword: String) {
        //show progress Dialog
        val progressDialog = ProgressDialog(this.context)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        val call: Call<playgroundList?>? = apiInterface!!.getBooks()

        call?.enqueue(object : Callback<playgroundList?> {
            override fun onResponse(
                call: Call<playgroundList?>?,
                response: Response<playgroundList?>
            ) {
                progressDialog.dismiss()

                if(response.body()!=null)
                    setRV(response.body()!!)

            }

            override fun onFailure(call: Call<playgroundList?>, t: Throwable?) {
                Toast.makeText(requireContext(),"Unable to load data!", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
                call.cancel()
            }
        })
    }

    fun setRV(tvshows: playgroundList) {

        rvAdapter =SearchBookAdapter(tvshows,this)
        this.rvBooks.adapter = rvAdapter
        this.rvBooks.layoutManager = LinearLayoutManager(this.context)

    }
    fun hideKeyboard() {
        // Hide Keyboard
        val hideKeyboard = ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
        hideKeyboard?.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }

}