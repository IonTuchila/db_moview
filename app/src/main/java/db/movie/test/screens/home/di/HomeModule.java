package db.movie.test.screens.home.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import db.movie.test.screens.home.mvp.HomeModel;
import db.movie.test.screens.home.mvp.HomePresenter;

@Module
public class HomeModule {

    @HomeFragmentScope
    @Provides
    HomeModel providesFavoritesModel() {
        return new HomeModel();
    }

    @HomeFragmentScope
    @Provides
    HomePresenter providesHomePresenter() {
        return new HomePresenter();
    }

}
