package db.movie.test.screens.main;

import db.movie.test.net.models.Movie;

public interface NavigationCallback {

    void goToHome();

    void goToDetails(Movie movie);

}
