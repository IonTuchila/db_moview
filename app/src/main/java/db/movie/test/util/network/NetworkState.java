package db.movie.test.util.network;

import db.movie.test.net.models.MovieError;

public class NetworkState {


    private final State state;
    private MovieError postcardError;

    public NetworkState(State state, MovieError postcardError) {
        this.state = state;
        this.postcardError = postcardError;
    }

    private NetworkState(State state) {
        this.state = state;
    }

}
