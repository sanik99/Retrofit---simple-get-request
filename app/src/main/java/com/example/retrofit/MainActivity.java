package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcView;
    ProgressBar progressBar;
    Posts_Adapter adapter;
    List<Posts> postsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Simple get request (Retrofit)");

        rcView = findViewById(R.id.rcView);
        progressBar = findViewById(R.id.progressBar);

        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setHasFixedSize(true);

        adapter = new Posts_Adapter(postsList);
        rcView.setAdapter(adapter);

        fetchPosts();

    }

    private void fetchPosts(){

        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                if (response.isSuccessful() && response.body() !=null){

                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}