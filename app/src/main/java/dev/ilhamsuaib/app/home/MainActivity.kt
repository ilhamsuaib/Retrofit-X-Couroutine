package dev.ilhamsuaib.app.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ilhamsuaib.app.R
import dev.ilhamsuaib.app.network.Result
import dev.ilhamsuaib.app.network.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: PostViewModel by viewModel()

    private val posts = mutableListOf<PostUIModel>()
    private val postAdapter by lazy { PostAdapter(posts, this::onPostClick) }

    private val observer = Observer<Result<List<PostUIModel>>> {
        when (it.status) {
            Status.SUCCESS -> showPosts(it.data.orEmpty())
            Status.ERROR -> showError(it.msg)
            Status.LOADING -> showLoading()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        mViewModel.posts.observe(this, observer)
    }

    private fun setupView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

    private fun onPostClick(post: PostUIModel) {
        Toast.makeText(this, post.title, Toast.LENGTH_SHORT).show()
    }

    private fun showPosts(posts: List<PostUIModel>) {
        progress.isVisible = false
        this.posts.clear()
        this.posts.addAll(posts)
        postAdapter.notifyDataSetChanged()
    }

    private fun showLoading() {
        progress.isVisible = true
    }

    private fun showError(msg: String?) {
        progress.isVisible = false
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
