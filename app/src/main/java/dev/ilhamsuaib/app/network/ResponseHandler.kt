package dev.ilhamsuaib.app.network

/**
 * Created by @ilhamsuaib on 2019-11-02.
 * github.com/ilhamsuaib
 */

class ResponseHandler {

    fun <T> onSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T> onError(code: Int): Resource<T> {
        return Resource.error(getErrorMessage(code))
    }

    private fun getErrorMessage(code: Int): String {
        return when(code) {
            404 -> "Not found"
            else -> "Something went wrong, try again"
        }
    }
}