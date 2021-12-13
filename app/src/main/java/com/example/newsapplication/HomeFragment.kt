package com.example.newsapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    val api = "f83526809bc44fa88ab7de1748dfb289"
    private val country = "in"

    private lateinit var modelClassArrayList: ArrayList<ModelClass>
    private lateinit var v: View
    private lateinit var adapter: Adapter


    private lateinit var recyclerViewofhome: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        v = inflater!!.inflate(R.layout.homefragment, container, false)
        recyclerViewofhome = v.findViewById(R.id.recyclerviewofhome)
        modelClassArrayList = ArrayList ()
        recyclerViewofhome.layoutManager = LinearLayoutManager(context)
        findNews()
        adapter = Adapter(context, modelClassArrayList)
        recyclerViewofhome.adapter = adapter



        return v
    }

    //sample


    private fun findNews() {
        val news: Call<MainNews> = ApiUtilities.getApiInterface.instance.getNews(country, 10, api)
        news.enqueue(object : Callback<MainNews> {
            override fun onResponse(call: Call<MainNews>?, response: Response<MainNews>) {
                if (response.isSuccessful) {
                    modelClassArrayList.addAll(response.body()?.articles!!)
                    Log.d("cherry", "successful")
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainNews>, t: Throwable) {
                Log.d("cherry", "Unsuccessful")
            }

        })


    }


}