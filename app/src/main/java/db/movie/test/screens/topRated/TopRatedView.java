package db.movie.test.screens.topRated;

import java.util.List;

import db.movie.test.common.ui.BaseView;
import db.movie.test.net.models.Movie;

public interface TopRatedView extends BaseView {

    void setData (List<Movie> movies) ;

}
