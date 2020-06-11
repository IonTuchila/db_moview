package db.movie.test.screens.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import db.movie.test.R;
import db.movie.test.net.models.Movie;
import db.movie.test.util.ImageLoader;

public class MovieAdapter extends RecyclerView.Adapter<MovieVH> {

    private List<Movie> dataCol = new ArrayList<>();
    private ImageLoader imageLoader;
    private MovieCallback callback;

    public MovieAdapter(ImageLoader imageLoader, MovieCallback callback) {
        this.imageLoader = imageLoader;
        this.callback = callback;
    }


    private Movie getItem(int position) {
        return dataCol.get(position);
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {
        Movie movie = getItem(position);
        holder.textView.setText(movie.getTitle());
        holder.itemView.setOnClickListener(click -> callback.onClick(movie));
        imageLoader.loadImage(holder.imageView, movie.getPosterPath());
    }

    @Override
    public int getItemCount() {
        return dataCol.size();
    }

    public void setData(List<Movie> data) {
        dataCol.clear();
        dataCol.addAll(data);
        notifyDataSetChanged();
    }

}