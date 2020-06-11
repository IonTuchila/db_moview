package db.movie.test.screens.popular.mvp;

import java.util.List;

import db.movie.test.common.ui.BasePresenter;
import db.movie.test.net.models.Movie;
import db.movie.test.net.models.MovieError;
import db.movie.test.screens.popular.PopularView;
import db.movie.test.util.LoadMoviesInterface;

public class PopularPresenter extends BasePresenter<PopularView> {

    PopularModel model;

    public PopularPresenter(PopularModel model) {
        this.model = model;
    }

    public void freshLoad() {
        model.freshLoad(new LoadMoviesInterface<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> data) {
                view.showDataLayout();
                view.setData(data);
            }

            @Override
            public void onFails(MovieError error) {

            }
        });
    }

}
