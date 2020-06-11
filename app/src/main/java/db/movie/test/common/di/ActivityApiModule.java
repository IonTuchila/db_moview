package db.movie.test.common.di;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import db.movie.test.R;
import db.movie.test.common.di.scope.ApplicationScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ActivityApiModule {

    private static final String ACTIVITY_URL = "activity_url";
    private static final String ACTIVITY_URL_KEY = "activity_url_key";

    @Provides
    @Named(ACTIVITY_URL)
    @ApplicationScope
    Retrofit provideActivityUrlRetrofit(OkHttpClient okHttpClient, @Named(ACTIVITY_URL_KEY) String activityUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(activityUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Named(ACTIVITY_URL_KEY)
    @ApplicationScope
    String providesActivityUrl(Context context) {
        return context != null ? context.getString(R.string.app_name) : null;
    }

}
