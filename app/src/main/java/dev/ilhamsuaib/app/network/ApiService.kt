package dev.ilhamsuaib.app.network

import dev.ilhamsuaib.app.data.model.PostModel
import retrofit2.http.GET

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostModel>
}