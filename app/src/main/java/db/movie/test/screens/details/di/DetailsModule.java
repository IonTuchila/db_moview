package db.movie.test.screens.details.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import db.movie.test.net.MovieApi;
import db.movie.test.screens.details.mvp.DetailModel;
import db.movie.test.screens.details.mvp.DetailPresenter;
import db.movie.test.util.NetworkHelper;

@Module
public class DetailsModule {

    @DetailsFragmentScope
    @Provides
    DetailModel providesDetailModel(Context context, MovieApi api, NetworkHelper networkHelper) {
        return new DetailModel(context, api, networkHelper);
    }

    @DetailsFragmentScope
    @Provides
    DetailPresenter providesDetailPresenter(DetailModel model) {
        return new DetailPresenter(model);
    }

}
