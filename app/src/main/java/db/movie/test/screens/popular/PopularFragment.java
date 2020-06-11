package db.movie.test.screens.popular;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import db.movie.test.screens.popular.mvp.PopularPresenter;
import db.movie.test.util.network.NetworkState;
import db.movie.test.util.ui.RecyclerViewItemDecoration;

import static db.movie.test.util.ui.UIUtils.getPostcardListInnerPadding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends BaseFragment implements PopularView, MovieCallback {

    private static PopularFragment fragment;
    @BindView(R.id.recycler_popular)
    RecyclerView recyclerView;
    @BindView(R.id.fragment_layout)
    LinearLayout fragmentLayout;
    @Inject
    PopularPresenter presenter;
    @Inject
    MovieAdapter adapter;

    public static PopularFragment newInstance() {
        fragment = new PopularFragment();

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popular;
    }

    @Override
    protected void initViewComponents() {
        presenter.attach(this);
        setAdapter();
        presenter.freshLoad();
    }

    private void setAdapter() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration(
                getPostcardListInnerPadding(getContext())));
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
        fragmentLayout.setVisibility(View.VISIBLE);
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
