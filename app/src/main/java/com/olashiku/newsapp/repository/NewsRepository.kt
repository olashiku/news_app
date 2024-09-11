package com.olashiku.newsapp.repository

import androidx.lifecycle.LiveData
import com.olashiku.newsapp.model.data_response.ArticleData
import com.olashiku.newsapp.model.news_response.NewsResponse

interface NewsRepository {
    suspend fun getLiveNews(): NewsResponse?
    fun getArticles(): LiveData<List<ArticleData>>
    suspend fun saveArticle(article: ArticleData)
    suspend fun deleteArticle(article: ArticleData)
}

