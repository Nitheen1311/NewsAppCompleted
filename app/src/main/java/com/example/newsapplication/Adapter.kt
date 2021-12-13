package com.example.newsapplication


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.ViewGroup
import  android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView


import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide

class Adapter(val context: Context?, private var modelClassArrayList: ArrayList<ModelClass>) :
    RecyclerView.Adapter<ViewHolder>() {

    lateinit var v: View
    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardView.setOnClickListener(View.OnClickListener {
            onClick(position)
            Log.d("maaa", "news got clicked ")
            Toast.makeText(context, " it got clicked", Toast.LENGTH_LONG)


        })






        holder.mtime.text = modelClassArrayList[position].publishedAt
        holder.mauthor.text = modelClassArrayList[position].author
        holder.mheading.text = modelClassArrayList[position].title
        holder.mcontent.text = modelClassArrayList[position].description
        Glide.with(holder.itemView.context).load(modelClassArrayList[position].urlToImage)
            .into(holder.imageView)
    }

    private fun onClick(position: Int) {
//              to display in new activity use the below code

//        val intent = Intent(context,webView::class.java)
//                intent.putExtra("url",modelClassArrayList[position].url)
//                context?.startActivity(intent)

//        to display in custom tab use the below code
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        if (context != null) {
            customTabsIntent.launchUrl(
                context,
                Uri.parse(modelClassArrayList[position].url)
            )
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        val viewHolder = ViewHolder(view)

        return viewHolder
    }
}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mheading: TextView = itemView.findViewById(R.id.mainheading)
    val mcontent: TextView = itemView.findViewById(R.id.content)
    val mauthor: TextView = itemView.findViewById(R.id.author)
    val mtime: TextView = itemView.findViewById(R.id.time)
    val imageView: ImageView = itemView.findViewById(R.id.imageview)
    val cardView: CardView = itemView.findViewById(R.id.cardview)


}
