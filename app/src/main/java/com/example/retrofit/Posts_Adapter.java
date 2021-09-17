package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Posts_Adapter extends RecyclerView.Adapter<Posts_Adapter.ViewHolder> {

   private List<Posts> postsList;

    public Posts_Adapter(List<Posts> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Posts_Adapter.ViewHolder holder, int position) {

        Posts posts = postsList.get(position);

        holder.user_id.setText("User_ID : " + posts.getUserID());
        holder.Id.setText("ID : " + posts.getID());
        holder.title.setText("Title : " + posts.getTitle());
        holder.body.setText("Body : " + posts.getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView user_id, Id, title, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_id = itemView.findViewById(R.id.user_id);
            Id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);


        }
    }
}


