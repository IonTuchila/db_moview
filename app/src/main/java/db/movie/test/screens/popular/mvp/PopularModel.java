package db.movie.test.screens.popular.mvp;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

import db.movie.test.net.MovieApi;
import db.movie.test.net.models.Movie;
import db.movie.test.net.models.MovieError;
import db.movie.test.net.models.Movies;
import db.movie.test.util.Constants;
import db.movie.test.util.LoadMoviesInterface;
import db.movie.test.util.NetworkHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularModel {


    Context context;
    MovieApi api;
    private NetworkHelper networkHelper;


    public PopularModel(Context context, MovieApi api, NetworkHelper networkHelper) {
        this.context = context;
        this.api = api;
        this.networkHelper = networkHelper;
    }

    public void freshLoad(LoadMoviesInterface<List<Movie>> loadInterface) {
        if (!networkHelper.isNetworkConnected()) {
            loadInterface.onFails(new MovieError(true));
            return;
        }

        api.getPopularMovies(1, Constants.API_KEY).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(@NonNull Call<Movies> call, @NonNull Response<Movies> response) {
                List<Movie> responseBody = null;

                if (response.body() != null) {
                    responseBody = response.body().getMovieResult();
                }

                loadInterface.onSuccess(responseBody);
            }

            @Override
            public void onFailure(@NonNull Call<Movies> call, @NonNull Throwable t) {
                loadInterface.onFails(new MovieError(true));
            }

        });
    }

}
