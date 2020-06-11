package db.movie.test.common.di;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import db.movie.test.DbMovieApp;
import db.movie.test.common.di.scope.ApplicationScope;
import db.movie.test.common.di.scope.NetModule;

@ApplicationScope
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        AppModule.class,
        NetModule.class,
        ActivityApiModule.class
})
public interface AppComponent extends AndroidInjector<DbMovieApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(DbMovieApp app);

        AppComponent build();
    }

}
