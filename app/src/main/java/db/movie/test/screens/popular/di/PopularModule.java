package db.movie.test.screens.popular.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import db.movie.test.net.MovieApi;
import db.movie.test.screens.home.MovieAdapter;
import db.movie.test.screens.popular.PopularFragment;
import db.movie.test.screens.popular.mvp.PopularModel;
import db.movie.test.screens.popular.mvp.PopularPresenter;
import db.movie.test.util.ImageLoader;
import db.movie.test.util.NetworkHelper;

@Module
public class PopularModule {

    @PopularFragmentScope
    @Provides
    PopularModel providesTopRatedModel(Context context, MovieApi api, NetworkHelper networkHelper) {
        return new PopularModel(context, api, networkHelper);
    }

    @PopularFragmentScope
    @Provides
    PopularPresenter providesPopularPresenter(PopularModel model) {
        return new PopularPresenter(model);
    }

    @PopularFragmentScope
    @Provides
    MovieAdapter providesCategoriesAdapter(ImageLoader imageLoader, PopularFragment callback) {
        return new MovieAdapter(imageLoader, callback);
    }

}
