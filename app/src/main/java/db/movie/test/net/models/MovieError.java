package db.movie.test.net.models;

public class MovieError {

    private boolean isNetworkConnectionError;

    public MovieError(boolean isNetworkConnectionError) {
        this.isNetworkConnectionError = isNetworkConnectionError;
    }

    public boolean isNetworkConnectionError() {
        return isNetworkConnectionError;
    }

}
