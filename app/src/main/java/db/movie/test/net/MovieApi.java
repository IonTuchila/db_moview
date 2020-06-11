package db.movie.test.net;

import db.movie.test.net.models.Movies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/popular")
    Call<Movies> getPopularMovies(@Query("page") int page, @Query("api_key") String userkey);

    @GET("movie/top_rated")
    Call<Movies> getTopRatedMovies(@Query("page") int page, @Query("api_key") String userkey);

}
