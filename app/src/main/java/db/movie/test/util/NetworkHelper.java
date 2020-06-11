package db.movie.test.util;

import android.net.ConnectivityManager;

public class NetworkHelper {

    private final ConnectivityManager connectivityManager;

    public NetworkHelper(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    public boolean isNetworkConnected() {
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
