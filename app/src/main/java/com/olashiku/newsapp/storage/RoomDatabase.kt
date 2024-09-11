package com.olashiku.newsapp.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olashiku.newsapp.model.data_response.ArticleData

@Database(entities = [ArticleData::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}