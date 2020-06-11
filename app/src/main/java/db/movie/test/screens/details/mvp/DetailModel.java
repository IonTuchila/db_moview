package db.movie.test.screens.details.mvp;

import android.content.Context;

import db.movie.test.net.MovieApi;
import db.movie.test.util.NetworkHelper;

public class DetailModel {

    Context context;
    MovieApi api;
    private NetworkHelper networkHelper;


    public DetailModel(Context context, MovieApi api, NetworkHelper networkHelper) {
        this.context = context;
        this.api = api;
        this.networkHelper = networkHelper;
    }

}
