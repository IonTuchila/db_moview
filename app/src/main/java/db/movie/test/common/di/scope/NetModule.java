package db.movie.test.common.di.scope;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.conscrypt.Conscrypt;

import java.security.Security;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import db.movie.test.R;
import db.movie.test.net.MovieApi;
import db.movie.test.net.RequestInterceptor;
import db.movie.test.util.NetExceptionHandlerInterceptor;
import db.movie.test.util.NetworkHelper;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private static final String BASE_URL = "base_url";
    private static final String BASE_URL_KEY = "base_url_key";
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 30;

    private static final int CACHE_SIZE = 10 * 1024 * 1024;
    private static final int FIRST_POSITION = 1;

    /**
     * Creates {@link Gson} singleton object that is used to work with data in json format.
     *
     * @return {@link Gson} object instance.
     * @see Gson
     */
    @Provides
    @ApplicationScope
    Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }

    /**
     * Creates {@link Retrofit} singleton object that is used to simplify network calls.
     *
     * @param okHttpClient {@link OkHttpClient} that contains configurations for network calls.
     * @param baseUrl      a {@link String} a string representation of base location for each network call.
     * @return {@link Retrofit} object instance.
     * @see Retrofit
     */
    @Provides
    @Named(BASE_URL)
    @ApplicationScope
    Retrofit provideBaseUrlRetrofit(OkHttpClient okHttpClient, @Named(BASE_URL_KEY) String baseUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    /**
     * Creates {@link OkHttpClient} singleton object that can then be used for network calls.
     *
     * @param cache       {@link Cache} represents configuration object with place and size for caching network
     *                    responses.
     * @param interceptor {@link Interceptor} represent entity that modifies network requests.
     * @return {@link OkHttpClient} object instance.
     * @see OkHttpClient
     */
    @Provides
    @ApplicationScope
    @SuppressWarnings("deprecation")
    OkHttpClient provideOkhttpClient(Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache)
                .addNetworkInterceptor(new NetExceptionHandlerInterceptor());

        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            Security.insertProviderAt(Conscrypt.newProvider(), FIRST_POSITION);
        }

        return client.build();
    }

    /**
     * Creates {@link Cache} singleton object that contains configuration for caching response objects.
     *
     * @param context {@link Context} application context.
     * @return {@link Cache} object instance.
     * @see Cache
     */
    @Provides
    @ApplicationScope
    Cache provideHttpCache(Context context) {
        return new Cache(context.getCacheDir(), CACHE_SIZE);
    }

    /**
     * Creates {@link NetworkHelper} singleton object that contains utility method for checking network state.
     *
     * @param connectivityManager {@link ConnectivityManager} android platform class that contains info about network
     *                            state.
     * @return {@link NetworkHelper} instance object.
     * @see NetworkHelper
     */
    @Provides
    @ApplicationScope
    NetworkHelper providesNetworkHelper(ConnectivityManager connectivityManager) {
        return new NetworkHelper(connectivityManager);
    }

    /**
     * Returns an absolute {@link String} representation of base url.
     *
     * @param context {@link Context} application context.
     * @return {@link String} object instance.
     */
    @Provides
    @Named(BASE_URL_KEY)
    @ApplicationScope
    String providesBaseUrl(Context context) {
        return context != null ? context.getString(R.string.base_url) : null;
    }


    /**
     * Creates {@link MovieApi} singleton object that contains paths and request interfaces.
     *
     * @param retrofit {@link Retrofit}
     * @return {@link MovieApi} instance object.
     */
    @Provides
    @ApplicationScope
    MovieApi providesApi(@Named(BASE_URL) Retrofit retrofit) {
        return retrofit.create(MovieApi.class);
    }

    /**
     * Creates {@link Interceptor} singleton object that modifies request headers.
     *
     * @return {@link RequestInterceptor} instance object.
     */
    @Provides
    @ApplicationScope
    Interceptor providesRequestInterceptor() {
        return new RequestInterceptor();
    }

}
