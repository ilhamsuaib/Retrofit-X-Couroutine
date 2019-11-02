package dev.ilhamsuaib.app.data

import dev.ilhamsuaib.app.home.PostUIModel
import dev.ilhamsuaib.app.network.ApiService
import dev.ilhamsuaib.app.network.Resource
import dev.ilhamsuaib.app.network.ResponseHandler
import retrofit2.HttpException

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

open class PostRepository(
    private val service: ApiService,
    private val responseHandler: ResponseHandler
) {

    suspend fun getPosts(): Resource<List<PostUIModel>> {
        return try {
            val response: List<PostUIModel> = service.getPosts()
                .map {
                    PostUIModel(
                        id = it.id,
                        title = it.title,
                        body = it.body
                    )
                }
            responseHandler.onSuccess(response)
        } catch (e: HttpException) {
            responseHandler.onError(e.code())
        }
    }
}