package com.mcardenas.parstagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.ViewHolder>{

    Context context;
    List<Item_post> posts;

    public PostAdapter(Context context, List<Item_post> posts) {
        this.context = context;
        this.posts = posts;
    }

    //For each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Get the data at position
        Item_post post= posts.get(position);
        //Bind the tweet with view holder
        holder.bind(post);
    }

    //Pass in the context and list of tweets
    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Item_post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    // Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPicture;
        TextView tvDescription;
        TextView tvUsername;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivPicture= itemView.findViewById(R.id.ivPicture);
            tvDescription= itemView.findViewById(R.id.tvDescription);;
            tvUsername= itemView.findViewById(R.id.tvUsername);;
        }

        public void bind(Item_post post) {
            tvDescription.setText(post.Description);
            tvUsername.setText(post.Username);
            Glide.with(context).load(post.imageUrl).into(ivPicture);
        }
    }

}