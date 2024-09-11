package com.olashiku.newsapp.repository

import androidx.lifecycle.LiveData
import com.olashiku.newsapp.model.data_response.ArticleData
import com.olashiku.newsapp.model.news_response.NewsResponse
import com.olashiku.newsapp.storage.ArticleDataSource
import com.olashiku.newsapp.utils.ApiConstants

class NewsRepositoryImplementation(private var articleDataSource: ArticleDataSource):BaseRepository(),NewsRepository {

    override suspend fun getLiveNews(): NewsResponse? {
      return makeGetRequest(ApiConstants.newsApi,NewsResponse::class)
    }

    override  fun getArticles(): LiveData<List<ArticleData>>{
        return articleDataSource.getArticles()
    }

    override suspend fun saveArticle(article: ArticleData) {
        articleDataSource.saveArticle(article)
    }

    override  suspend fun deleteArticle(article: ArticleData) {
        articleDataSource.deleteArticle(article)
    }


}