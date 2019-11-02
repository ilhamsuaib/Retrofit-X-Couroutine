package dev.ilhamsuaib.app.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.timeout
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.ilhamsuaib.app.data.PostRepository
import dev.ilhamsuaib.app.network.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class PostViewModelTest {

    lateinit var mViewModel: PostViewModel
    lateinit var postRepository: PostRepository
    lateinit var postObserver: Observer<Resource<List<PostUIModel>>>
    private val posts = Resource.success(emptyList<PostUIModel>())

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ObsoleteCoroutinesApi
    @Before
    fun before() {
        Dispatchers.setMain(mainThreadSurrogate)
        postRepository = mock()
        runBlocking {
            whenever(postRepository.getPosts()).thenReturn(posts)
        }
        mViewModel = PostViewModel(postRepository)
        postObserver = mock()
    }

    @Test
    fun `when get post is success`() = runBlocking {
        mViewModel.posts.observeForever(postObserver)
        delay(100L)
        verify(postRepository).getPosts()
        verify(postObserver, timeout(30L)).onChanged(Resource.loading())
        verify(postObserver, timeout(30L)).onChanged(posts)
    }
}