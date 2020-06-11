package db.movie.test.util;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import db.movie.test.R;

public class ImageLoader {

    private static final int placeholder = R.drawable.placeholder_grey;
    private  String path = "https://image.tmdb.org/t/p/original";

    public void loadImage(@NonNull ImageView imageView, @Nullable String url) {
        if (url != null) {
                Glide.with(imageView)
                    .load(path+ url)
//                    TODO uncomment this row in case if is needed to disable caching
//                    .apply(getRequestOptions())
                    .placeholder(placeholder)
                    .error(placeholder)
                    .thumbnail(0.1f)
                    .into(imageView);
        }
    }

}
