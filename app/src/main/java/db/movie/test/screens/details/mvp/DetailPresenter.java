package db.movie.test.screens.details.mvp;

import db.movie.test.common.ui.BasePresenter;
import db.movie.test.common.ui.BaseView;

public class DetailPresenter extends BasePresenter<BaseView> {

    DetailModel model;

    public DetailPresenter(DetailModel model) {
        this.model = model;
    }

}
