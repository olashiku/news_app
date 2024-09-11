package com.olashiku.newsapp.storage

import androidx.lifecycle.LiveData
import com.olashiku.newsapp.model.data_response.ArticleData



class ArticleDataSourceImplementation(private val articleDao: ArticleDao):ArticleDataSource {

    override fun getArticles(): LiveData<List<ArticleData>> {
     return   articleDao.getArticles()
    }

    override suspend fun saveArticle(article: ArticleData) {
        articleDao.saveArticle(article)
    }

    override suspend fun deleteArticle(article: ArticleData) {
        articleDao.deleteArticle(article)
    }
}