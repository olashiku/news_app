package com.olashiku.newsapp.repository

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlin.reflect.KClass

open class BaseRepository {

    val client = HttpClient(CIO)

    suspend fun <T : Any> makeGetRequest(url: String, responseDataClass: KClass<T>): T? {
        return try {
            val request: HttpResponse = client.get(url)
            val responseString: String = request.bodyAsText()
            Gson().fromJson(responseString, responseDataClass.java)
        } catch (e: Exception) {
            null
        }
    }

}
