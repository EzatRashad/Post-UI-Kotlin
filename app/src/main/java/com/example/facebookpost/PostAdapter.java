package com.example.facebookpost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.userName.setText(post.getUserName());
        holder.time.setText(post.getPostTime());
        holder.content.setText(post.getPostContent());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userName, time, content;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name_tv);
            time = itemView.findViewById(R.id.post_time_tv);
            content = itemView.findViewById(R.id.post_content_tv);
        }
    }
}