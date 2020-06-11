package db.movie.test.common.di;

import android.content.Context;
import android.net.ConnectivityManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import db.movie.test.DbMovieApp;
import db.movie.test.common.di.scope.ApplicationScope;
import db.movie.test.util.ImageLoader;

import static android.content.Context.CONNECTIVITY_SERVICE;

@Module
public abstract class AppModule {

    @Binds
    @ApplicationScope
    abstract Context provideAppContext(DbMovieApp app);

    @Provides
    @ApplicationScope
    static ConnectivityManager providesConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
    }

    @Provides
    static ImageLoader providesImageLoader() {
        return new ImageLoader();
    }

}
