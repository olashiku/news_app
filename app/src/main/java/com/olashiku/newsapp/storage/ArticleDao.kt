package com.olashiku.newsapp.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olashiku.newsapp.model.data_response.ArticleData

@Dao
interface ArticleDao {

    @Query("select DISTINCT * from ArticleData")
    fun getArticles():LiveData<List<ArticleData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveArticle(country:ArticleData)

    @Delete
    suspend fun deleteArticle(country: ArticleData)
}