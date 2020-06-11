package db.movie.test.screens.details;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import butterknife.BindView;
import db.movie.test.R;
import db.movie.test.common.ui.BaseFragment;
import db.movie.test.common.ui.BasePresenter;
import db.movie.test.common.ui.BaseView;
import db.movie.test.net.models.Movie;
import db.movie.test.screens.details.mvp.DetailPresenter;
import db.movie.test.util.ImageLoader;
import db.movie.test.util.network.NetworkState;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends BaseFragment implements BaseView {

    private static DetailsFragment fragment;
    public static String MOVIE_KEY = "movie_key";
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView desc;
    @BindView(R.id.voteCount)
    TextView voteCount;
    @BindView(R.id.originalLang)
    TextView lang;
    @BindView(R.id.releaseDate)
    TextView release;
    @Inject
    DetailPresenter presenter;
    @Inject
    ImageLoader imageLoader;
    Movie movie;

    public static DetailsFragment newInstance(Movie movie) {
        fragment = new DetailsFragment();
        Bundle arg = new Bundle();
        arg.putParcelable(MOVIE_KEY, movie);
        fragment.setArguments(arg);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(MOVIE_KEY);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    protected void initViewComponents() {
        presenter.attach(this);
        imageLoader.loadImage(imageView,movie.getPosterPath());
        title.setText(movie.getTitle());
        desc.setText(movie.getOverview());
        voteCount.setText("Vote aver.: " + movie.getVoteAverage());
        lang.setText("Original language: "+ movie.getOriginalLanguage());
        release.setText("Release: " + movie.getReleaseDate());
    }

    @NonNull
    @Override
    public String getFullSlug() {
        return null;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setState(NetworkState networkState) {

    }

    @Override
    public void showDataLayout() {

    }

    @Override
    public void hideServiceLayout() {

    }

}
