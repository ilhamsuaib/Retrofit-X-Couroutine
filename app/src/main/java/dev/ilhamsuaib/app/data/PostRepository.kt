package dev.ilhamsuaib.app.data

import dev.ilhamsuaib.app.MyApp
import dev.ilhamsuaib.app.home.Post

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class PostRepository {

    private val service = MyApp.service

    suspend fun getPosts() = service.getPosts()
        .map {
            Post(
                id = it.id,
                title = it.title,
                body = it.body
            )
        }
}