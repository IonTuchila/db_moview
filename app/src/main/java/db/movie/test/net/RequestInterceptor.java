package db.movie.test.net;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request()
                .newBuilder()
                .build());
    }

}
