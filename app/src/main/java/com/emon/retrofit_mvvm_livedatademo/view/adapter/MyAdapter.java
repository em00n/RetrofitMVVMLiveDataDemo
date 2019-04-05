package com.emon.retrofit_mvvm_livedatademo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.emon.retrofit_mvvm_livedatademo.R;
import com.emon.retrofit_mvvm_livedatademo.model.Comment;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecyclerViewHolder> {
    Context context;
    List<Comment> postList;


    public MyAdapter(Context context, List<Comment> postList) {
        this.context = context;
        this.postList = postList;
    }


    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {

        // Comment post=postList.get(position);
        int id = postList.get(position).getId();
        int postid = postList.get(position).getPostId();
        String ids = "Id: " + String.valueOf(id);
        String postids = "Post id: " + String.valueOf(postid);
        String names = "Name: " + postList.get(position).getName();
        String emails = "Email: " + postList.get(position).getEmail();
        String texts = "Text: " + postList.get(position).getText();


        holder.id.setText(ids);
        holder.postid.setText(postids);
        holder.name.setText(names);
        holder.email.setText(emails);
        holder.text.setText(texts);

    }

    @Override
    public int getItemCount() {
        if (postList==null)return 0;
       else return postList.size();
    }

    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView id, postid, name, email, text;

        public MyRecyclerViewHolder(View itemView) {

            super(itemView);
            id = (TextView) itemView.findViewById(R.id.idTV);
            postid = (TextView) itemView.findViewById(R.id.postidTV);
            name = (TextView) itemView.findViewById(R.id.nameTV);
            email = (TextView) itemView.findViewById(R.id.emailTV);
            text = (TextView) itemView.findViewById(R.id.textTV);


        }
    }
}
