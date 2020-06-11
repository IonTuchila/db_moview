package db.movie.test.util;

import db.movie.test.net.models.MovieError;

public interface LoadMoviesInterface<D> {

    void onSuccess(D data);

    void onFails(MovieError error);

}
