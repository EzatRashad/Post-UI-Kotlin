package com.example.facebookpost

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val recyclerView: RecyclerView = findViewById(R.id.posts_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val postList = mutableListOf<Post>()

        postList.add(Post("Ahmed Ali", "2 hours ago", "Hello World!"))
        postList.add(Post("Mohamed Hassan", "30 mins ago", "Hello World!"))
        postList.add(Post("Sara Khaled", "Just now", "Hello World!"))
        postList.add(Post("John Doe", "5 mins ago", "Hello World!"))

        val adapter = PostAdapter(postList)

        adapter.setOnPostClickListener(object : OnPostClickListener {
            override fun onPostClick(post: Post?, position: Int) {
                Toast.makeText(
                    this@PostActivity,
                    "Hello ${post?.userName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        recyclerView.adapter = adapter
    }
}
