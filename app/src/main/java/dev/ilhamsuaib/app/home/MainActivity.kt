package dev.ilhamsuaib.app.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ilhamsuaib.app.R
import dev.ilhamsuaib.app.logD
import dev.ilhamsuaib.app.toJson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val posts = mutableListOf<Post>()
    private val postAdapter by lazy { PostAdapter(posts, this::onPostClick) }

    @Suppress("UNCHECKED_CAST")
    private val mViewModel: PostViewModel by lazy {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PostViewModel() as T
            }
        })[PostViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

        mViewModel.posts.observe(this, Observer { posts ->
            logD("this.posts size : ${this.posts.size}")
            logD("posts : ${posts.toJson}")
            this.posts.addAll(posts)
            postAdapter.notifyDataSetChanged()
        })
        this.posts.add(Post(1, "Test", "Test body"))
    }

    private fun setupView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

    private fun onPostClick(post: Post) {
        Toast.makeText(this, post.title, Toast.LENGTH_SHORT).show()
    }
}
