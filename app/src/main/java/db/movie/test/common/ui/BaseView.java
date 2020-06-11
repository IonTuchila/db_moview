package db.movie.test.common.ui;

import db.movie.test.util.network.NetworkState;

public interface BaseView {
    /**
     * Takes a {@link NetworkState} and updates view correspond it.
     *
     * @param networkState a {@link NetworkState} that contains current network state.
     */
    void setState(NetworkState networkState);

    /**
     * Displays normal data view.
     */
    void showDataLayout();

    /**
     * Hides layout that displays network error states.
     */
    void hideServiceLayout();

}
