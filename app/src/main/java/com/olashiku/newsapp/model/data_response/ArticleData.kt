package com.olashiku.newsapp.model.data_response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ArticleData")
data class ArticleData (
        @PrimaryKey(autoGenerate = true)
        var id:Int,
        val author: String?,
        val content: String,
        val description: String,
        val publishedAt: String,
        val source: String,
        val title: String,
        val url: String,
        val urlToImage: String?

)