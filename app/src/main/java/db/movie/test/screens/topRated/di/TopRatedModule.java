package db.movie.test.screens.topRated.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import db.movie.test.net.MovieApi;
import db.movie.test.screens.home.MovieAdapter;
import db.movie.test.screens.popular.PopularFragment;
import db.movie.test.screens.popular.di.PopularFragmentScope;
import db.movie.test.screens.topRated.TopRatedFragment;
import db.movie.test.screens.topRated.mvp.TopRatedModel;
import db.movie.test.screens.topRated.mvp.TopRatedPresenter;
import db.movie.test.util.ImageLoader;
import db.movie.test.util.NetworkHelper;

@Module
public class TopRatedModule {

    @TopRatedFragmentScope
    @Provides
    TopRatedModel providesTopRatedModel(Context context, MovieApi api, NetworkHelper networkHelper) {
        return new TopRatedModel(context, api, networkHelper);
    }

    @TopRatedFragmentScope
    @Provides
    TopRatedPresenter providesTopRatedPresenter(TopRatedModel model) {
        return new TopRatedPresenter(model);
    }

    @TopRatedFragmentScope
    @Provides
    MovieAdapter providesCategoriesAdapter(ImageLoader imageLoader, TopRatedFragment callback) {
        return new MovieAdapter(imageLoader, callback);
    }
}
