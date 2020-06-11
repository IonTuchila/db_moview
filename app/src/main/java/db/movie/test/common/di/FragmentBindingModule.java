package db.movie.test.common.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import db.movie.test.screens.details.DetailsFragment;
import db.movie.test.screens.details.di.DetailsFragmentScope;
import db.movie.test.screens.details.di.DetailsModule;
import db.movie.test.screens.home.HomeFragment;
import db.movie.test.screens.home.di.HomeFragmentScope;
import db.movie.test.screens.home.di.HomeModule;
import db.movie.test.screens.popular.PopularFragment;
import db.movie.test.screens.popular.di.PopularFragmentScope;
import db.movie.test.screens.popular.di.PopularModule;
import db.movie.test.screens.topRated.TopRatedFragment;
import db.movie.test.screens.topRated.di.TopRatedFragmentScope;
import db.movie.test.screens.topRated.di.TopRatedModule;

@Module
public abstract class FragmentBindingModule {

    @HomeFragmentScope
    @ContributesAndroidInjector(modules = {HomeModule.class})
    abstract HomeFragment bindHomeFragment();

    @PopularFragmentScope
    @ContributesAndroidInjector(modules = {PopularModule.class})
    abstract PopularFragment bindPopularFragment();

    @TopRatedFragmentScope
    @ContributesAndroidInjector(modules = {TopRatedModule.class})
    abstract TopRatedFragment bindTopRatedFragment();

    @DetailsFragmentScope
    @ContributesAndroidInjector(modules = {DetailsModule.class})
    abstract DetailsFragment bindDetailsFragment();

}
