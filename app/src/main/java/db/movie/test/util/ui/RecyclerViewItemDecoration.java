package db.movie.test.util.ui;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    /**
     * Simple constructor used to create instance of this class.
     *
     * @param spacing spacing size in int.
     */
    public RecyclerViewItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    /**
     * Retrieves any offsets for the given item. Each field of outRect specifies the number of pixels that the item
     * view should be inset by, similar to padding or margin. The default implementation sets the bounds of outRect
     * to 0 and returns.
     *
     * @param outRect {@link Rect} to receive the output.
     * @param view    {@link View} the child view to decorate.
     * @param parent  {@link RecyclerView} that has to be decorated.
     * @param state   {@link RecyclerView.State} the current state of RecyclerView.
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.left = spacing;
        outRect.right = 0;
        outRect.bottom = spacing;
        outRect.top = 0;
    }

}