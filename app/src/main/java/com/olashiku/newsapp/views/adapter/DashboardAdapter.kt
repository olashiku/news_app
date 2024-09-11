package com.olashiku.newsapp.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.olashiku.newsapp.R
import com.olashiku.newsapp.model.news_response.Article
import com.olashiku.newsapp.utils.loadImage

class DashboardAdapter  (private val itemList: List<Article>,val context: Context, var viewItemDetails:(Article)->Unit) :
    RecyclerView.Adapter<DashboardAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)
        val newsTitleTextView: TextView = itemView.findViewById(R.id.newsTitleTextView)
        val rootLayout : ConstraintLayout = itemView.findViewById(R.id.rootLayout)
        val itemAuthorTextView: TextView = itemView.findViewById(R.id.itemAuthorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_blueprint, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.newsTitleTextView.text = itemList[position].title
        holder.itemAuthorTextView.text = context.getString(R.string.by, itemList[position].author?: context.getString(
            R.string.anonymous
        ))
        holder.newsImageView.loadImage(itemList[position].urlToImage?:"")


        holder.rootLayout.setOnClickListener {
            viewItemDetails.invoke(itemList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}