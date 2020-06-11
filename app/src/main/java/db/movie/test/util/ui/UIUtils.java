package db.movie.test.util.ui;

import android.content.Context;

import java.util.Objects;

import db.movie.test.R;

public class UIUtils {
    /**
     * Gets integral value in pixels of spacing between postcards in list.
     *
     * @param context Link on the application context.
     * @return Integer as value in pixels of spacing between postcards in list.
     */
    public static int getPostcardListInnerPadding(Context context) {
        return Objects.requireNonNull(context).getResources()
                .getDimensionPixelSize(R.dimen._6sdp);
    }

}
