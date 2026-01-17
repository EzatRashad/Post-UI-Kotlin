package com.example.facebookpost;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        RecyclerView recyclerView = findViewById(R.id.posts_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<Post> postList = new ArrayList<>();

        postList.add(new Post("Ahmed Ali", "2 hours ago", "Hello World!"));
        postList.add(new Post("Mohamed Hassan", "30 mins ago", "Hello World!"));
        postList.add(new Post("Sara Khaled", "Just now", "Hello World!"));
        postList.add(new Post("John Doe", "5 mins ago", "Hello World!"));

        PostAdapter adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);
    }
}