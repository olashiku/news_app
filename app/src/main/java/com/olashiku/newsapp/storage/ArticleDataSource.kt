package com.olashiku.newsapp.storage

import androidx.lifecycle.LiveData
import com.olashiku.newsapp.model.data_response.ArticleData

interface ArticleDataSource {
    fun getArticles(): LiveData<List<ArticleData>>
    suspend fun saveArticle(article:ArticleData)
    suspend fun deleteArticle(article: ArticleData)
}