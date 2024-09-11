package com.olashiku.newsapp.model.news_response

import com.google.gson.Gson
import com.olashiku.newsapp.model.data_response.ArticleData

data class Article(
    val author: String? ="",
    val content: String?="",
    val description: String="",
    val publishedAt: String="",
    val source: Source?= null,
    val title: String="",
    val url: String="",
    val urlToImage: String? = ""
)

fun Article.toArticleData():ArticleData{
    return ArticleData(0,this.author,this.content?:"",this.description,
        this.publishedAt,Gson().toJson(source),this.title,this.url,this.urlToImage)
}

fun ArticleData.toArticle():Article{
    return Article(this.author,this.content?:"",this.description,
        this.publishedAt,Gson().fromJson(source,Source::class.java),this.title,this.url,this.urlToImage)
}

