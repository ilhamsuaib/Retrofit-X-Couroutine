package dev.ilhamsuaib.app.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.ilhamsuaib.app.data.model.PostModel
import dev.ilhamsuaib.app.network.ApiService
import dev.ilhamsuaib.app.network.Resource
import dev.ilhamsuaib.app.network.ResponseHandler
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PostRepositoryTest {

    lateinit var postRepository: PostRepository
    private val posts = emptyList<PostModel>()

    @Before
    fun before() {
        val responseHandler = ResponseHandler()
        val service = mock<ApiService>()
        runBlocking {
            whenever(service.getPosts()).thenReturn(posts)
        }
        postRepository = PostRepository(service, responseHandler)
    }

    @Test
    fun `test get post on success`() = runBlocking {
        assertEquals(posts, postRepository.getPosts().data)
    }
}