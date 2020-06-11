package db.movie.test.screens.topRated;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import db.movie.test.R;
import db.movie.test.common.ui.BaseFragment;
import db.movie.test.common.ui.BasePresenter;
import db.movie.test.net.models.Movie;
import db.movie.test.screens.home.MovieAdapter;
import db.movie.test.screens.home.MovieCallback;
import db.movie.test.screens.topRated.mvp.TopRatedPresenter;
import db.movie.test.util.network.NetworkState;
import db.movie.test.util.ui.RecyclerViewItemDecoration;

import static db.movie.test.util.ui.UIUtils.getPostcardListInnerPadding;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends BaseFragment implements TopRatedView, MovieCallback {

    private static TopRatedFragment fragment;
    @BindView(R.id.top_recycler)
    RecyclerView recyclerView;
    @Inject
    TopRatedPresenter presenter;
    @Inject
    MovieAdapter adapter;

    public static TopRatedFragment newInstance() {
        fragment = new TopRatedFragment();

        return fragment;
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration(
                getPostcardListInnerPadding(getContext())));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_rated;
    }

    @Override
    protected void initViewComponents() {
        presenter.attach(this);
        setAdapter();
        presenter.freshLoad();
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

    @Override
    public void onClick(Movie movie) {
        router.goToDetails(movie);
    }

    @Override
    public void setData(List<Movie> movies) {
        adapter.setData(movies);
    }
}
