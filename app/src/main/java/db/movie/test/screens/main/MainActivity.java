package db.movie.test.screens.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import db.movie.test.R;
import db.movie.test.net.models.Movie;
import db.movie.test.screens.details.DetailsFragment;
import db.movie.test.screens.home.HomeFragment;

public class MainActivity extends DaggerAppCompatActivity implements NavigationCallback {

    @Inject
    ScreenManager screenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToHome();
    }

    @Override
    public void goToHome() {
        screenManager.navigateToFragment(R.id.fragment_container, HomeFragment.newInstance());
    }

    @Override
    public void goToDetails(Movie movie) {
        screenManager.navigateToFragment(R.id.fragment_container, DetailsFragment.newInstance(movie));
    }

}
