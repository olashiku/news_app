package com.olashiku.newsapp.module

import androidx.room.Room
import com.olashiku.newsapp.repository.NewsRepository
import com.olashiku.newsapp.repository.NewsRepositoryImplementation
import com.olashiku.newsapp.storage.AppDatabase
import com.olashiku.newsapp.storage.ArticleDataSource
import com.olashiku.newsapp.storage.ArticleDataSourceImplementation
import com.olashiku.newsapp.viewmodel.NewsViewModel

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var module = module {
    /*** repository section*/
    single<NewsRepository> { NewsRepositoryImplementation(articleDataSource = get()) }

    /*** view model section*/
    viewModel { NewsViewModel(repository = get()) }

    /*** database  section*/
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    /*** dao section*/
    single { get<AppDatabase>().articleDao() }

    /*** data source section*/
    single<ArticleDataSource> { ArticleDataSourceImplementation(articleDao = get()) }


}