package com.olashiku.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olashiku.newsapp.model.data_response.ArticleData
import com.olashiku.newsapp.model.news_response.Article
import com.olashiku.newsapp.model.news_response.NewsResponse
import com.olashiku.newsapp.model.news_response.toArticleData
import com.olashiku.newsapp.repository.NewsRepository
import com.olashiku.newsapp.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class NewsViewModel(val repository: NewsRepository) : ViewModel() {

    val newsResponse = SingleLiveEvent<NewsResponse?>()
    val errorMessage = SingleLiveEvent<String>()
    var selectedArticle: Article = Article()


    fun getCurrentNews() {
        viewModelScope.launch {
            val response = repository.getLiveNews()
            if (response != null) {
                newsResponse.postValue(response)
            } else {
                errorMessage.postValue("Something went wrong, please try again later")
            }
        }
    }

    fun saveArticle(article: Article) {
        selectedArticle = article
        viewModelScope.launch {
            repository.saveArticle(article.toArticleData())
        }
    }

    fun getArticles(): LiveData<List<ArticleData>> {
        return repository.getArticles()
    }

    fun deleteArticle(article: Article) {
        viewModelScope.launch {
            repository.deleteArticle(article.toArticleData())
        }
    }
}