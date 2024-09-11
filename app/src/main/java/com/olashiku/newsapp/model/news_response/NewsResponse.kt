package com.olashiku.newsapp.model.news_response

data class NewsResponse(
    val articles: List<Article> = emptyList(),
    val status: String = "",
    val totalResults: Int = 0
)