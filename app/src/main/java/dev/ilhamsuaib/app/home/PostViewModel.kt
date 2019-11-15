package dev.ilhamsuaib.app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.ilhamsuaib.app.data.PostRepository
import dev.ilhamsuaib.app.network.Result

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class PostViewModel(private val repo: PostRepository) : ViewModel() {

    val posts = liveData {
        emit(Result.loading())
        emit(repo.getPosts())
    }
}