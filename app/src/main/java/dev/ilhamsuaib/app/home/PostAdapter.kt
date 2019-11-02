package dev.ilhamsuaib.app.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ilhamsuaib.app.R
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class PostAdapter(
    private val posts: List<PostUIModel>,
    private val onClick: (PostUIModel) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
            .setOnClickListener {
                onClick(post)
            }
    }

    override fun getItemCount(): Int = posts.size

    inner class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: PostUIModel) = itemView.apply {
            val title = "${adapterPosition.plus(1)}. ${post.title}"
            tvTitle.text = title
            tvBody.text = post.body
        }
    }
}