package db.movie.test.screens.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import db.movie.test.R;

public class MovieVH extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_photo)
    ImageView imageView;
    @BindView(R.id.movie_title)
    TextView textView;

    public MovieVH(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
