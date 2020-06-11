package db.movie.test.util;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class NetExceptionHandlerInterceptor implements Interceptor {

    /**
     * Intercept of IOException.
     *
     * @param chain Application interceptors.
     * @return Chain request.
     * @throws IOException Exception message.
     */
    @NonNull
    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

}
