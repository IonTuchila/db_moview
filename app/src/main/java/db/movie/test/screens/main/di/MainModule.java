package db.movie.test.screens.main.di;

import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;
import db.movie.test.screens.main.MainActivity;
import db.movie.test.screens.main.ScreenManager;

@Module
public class MainModule {

    /**
     * Creates {@link ScreenManager} that takes care about navigation between screens.
     *
     * @param activity {@link MainActivity} that hosts all {@link Fragment}.
     * @return {@link ScreenManager} instance.
     */
    @Provides
    ScreenManager provideScreenManager(MainActivity activity) {
        return new ScreenManager(activity);
    }

}
