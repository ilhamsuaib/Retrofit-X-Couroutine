package dev.ilhamsuaib.app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.ilhamsuaib.app.data.model.PostModel
import dev.ilhamsuaib.app.data.PostRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class PostViewModel : ViewModel() {

    private val repo = PostRepository()

    val posts = liveData(Dispatchers.IO) {
        val posts: List<Post> = repo.getPosts()
        emit(posts)
    }
}