package dev.ilhamsuaib.app.network

/**
 * Created by @ilhamsuaib on 2019-11-02.
 * github.com/ilhamsuaib
 */

data class Result<T>(val status: Status, val data: T?, val msg: String?) {

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): Result<T> {
            return Result(Status.ERROR, null, msg)
        }

        fun <T> loading(): Result<T> {
            return Result(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}