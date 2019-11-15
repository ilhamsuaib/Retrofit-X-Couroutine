package dev.ilhamsuaib.app.data

import dev.ilhamsuaib.app.home.PostUIModel
import dev.ilhamsuaib.app.network.ApiService
import dev.ilhamsuaib.app.network.Result
import retrofit2.HttpException
import java.net.UnknownHostException

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class PostRepository(
    private val service: ApiService
) {

    suspend fun getPosts(): Result<List<PostUIModel>> = getResult {
        val response: List<PostUIModel> = service.getPosts()
            .map {
                PostUIModel(
                    id = it.id,
                    title = it.title,
                    body = it.body
                )
            }
        return@getResult Result.success(response)
    }
}

//top level fun for wrapping request to get result
suspend fun <R> getResult(statement: suspend () -> Result<R>): Result<R> {
    return try {
        statement()
    } catch (e: Exception) {
        val defaultMessage = "Something went wrong, try again"
        val message = when (e) {
            is HttpException -> {
                when (e.code()) {
                    404 -> "Not found"
                    else -> defaultMessage
                }
            }
            is UnknownHostException -> "No internet connection"
            else -> defaultMessage
        }
        Result.error(message)
    }
}

