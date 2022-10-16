package com.developeralamin.mvvmartic.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.developeralamin.mvvmartic.R;
import com.developeralamin.mvvmartic.service.model.Result;

import java.util.List;

public class TopMovieApater extends RecyclerView.Adapter<TopMovieApater.TopMovieViewHolder> {


   private Context context;
   private List<Result> list;

    public TopMovieApater(Context context, List<Result> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public TopMovieApater.TopMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.item_movie_layout, parent, false);
        return new TopMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieApater.TopMovieViewHolder holder, int position) {


       holder.mTitle.setText(list.get(position).getTitle());
       holder.mRating.setText(list.get(position).getVoteAverage().toString());
       holder.mRelDate.setText(list.get(position).getReleaseDate());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+list.get(position).getPosterPath()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopMovieViewHolder extends RecyclerView.ViewHolder {


        private TextView mTitle, mRating, mRelDate;
        ImageView imageView;

        public TopMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tittle);
            mRating = itemView.findViewById(R.id.rateing);
            mRelDate = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.imageView1);

        }
    }
}
