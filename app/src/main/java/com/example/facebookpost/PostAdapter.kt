package com.example.facebookpost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    private val postList: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var onPostClickListener: OnPostClickListener? = null

    fun setOnPostClickListener(listener: OnPostClickListener) {
        this.onPostClickListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        holder.userName.text = post.userName
        holder.time.text = post.postTime
        holder.content.text = post.postContent

        holder.itemView.setOnClickListener {
            onPostClickListener?.onPostClick(post, position)
        }
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.user_name_tv)
        val time: TextView = itemView.findViewById(R.id.post_time_tv)
        val content: TextView = itemView.findViewById(R.id.post_content_tv)
    }
}
