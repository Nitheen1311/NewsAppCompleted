package com.example.newsapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SportsFragment : Fragment() {


    val api  = "f83526809bc44fa88ab7de1748dfb289"


    private lateinit var  modelClassArrayList: ArrayList<ModelClass>
    private lateinit var v :View
    private lateinit var adapter : Adapter

    private val country = "in"
    private lateinit var recyclerViewofsports : RecyclerView

    private  var category : String ="sports"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v= inflater!!.inflate(R.layout.sportsfragment, container, false)


//        first
        recyclerViewofsports=v.findViewById(R.id.recyclerviewofsports)
        modelClassArrayList = ArrayList()
        recyclerViewofsports.layoutManager = LinearLayoutManager(context)
        adapter = Adapter(context,modelClassArrayList)
        recyclerViewofsports.adapter  = adapter

        findNews()

        return v
    }

    //sample






    private fun findNews() {
        val news: Call<MainNews> = ApiUtilities.getApiInterface.instance.getCategoryNews(
            country ,
            category,
            100,
            api
        )
        news.enqueue(object : Callback<MainNews> {
            override fun onResponse(call: Call<MainNews>?, response: Response<MainNews>) {
                if (response.isSuccessful) {
                    modelClassArrayList.addAll(response.body()?.articles!!)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }


}