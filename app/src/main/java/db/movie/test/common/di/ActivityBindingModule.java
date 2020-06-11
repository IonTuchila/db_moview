package db.movie.test.common.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import db.movie.test.screens.main.MainActivity;
import db.movie.test.common.di.scope.ActivityScope;
import db.movie.test.screens.main.di.MainModule;

@Module
public abstract  class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity bindMainActivity();

}
