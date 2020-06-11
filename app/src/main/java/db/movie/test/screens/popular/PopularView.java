package db.movie.test.screens.popular;

import java.util.List;

import db.movie.test.common.ui.BaseView;
import db.movie.test.net.models.Movie;

public interface PopularView extends BaseView {

    void setData (List<Movie> movies) ;
}
