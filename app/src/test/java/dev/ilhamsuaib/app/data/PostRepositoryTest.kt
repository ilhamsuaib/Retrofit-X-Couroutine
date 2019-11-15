package dev.ilhamsuaib.app.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.ilhamsuaib.app.data.model.PostModel
import dev.ilhamsuaib.app.home.PostUIModel
import dev.ilhamsuaib.app.network.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PostRepositoryTest {

    lateinit var postRepository: PostRepository
    private val postApiModels = listOf(PostModel(1, 1, "Title", "Body"))
    private val postUIModels = listOf(PostUIModel(1, "Title", "Body"))

    @Before
    fun before() {
        val service = mock<ApiService>()
        runBlocking {
            whenever(service.getPosts()).thenReturn(postApiModels)
        }
        postRepository = PostRepository(service)
    }

    @Test
    fun `test get post on success`() = runBlocking {
        assertEquals(postUIModels, postRepository.getPosts().data)
    }
}