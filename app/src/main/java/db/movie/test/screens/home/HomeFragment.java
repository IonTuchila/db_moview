package db.movie.test.screens.home;

import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import db.movie.test.R;
import db.movie.test.common.ui.BaseFragment;
import db.movie.test.common.ui.BasePresenter;
import db.movie.test.common.ui.BaseView;
import db.movie.test.screens.home.mvp.HomePresenter;
import db.movie.test.screens.popular.PopularFragment;
import db.movie.test.screens.topRated.TopRatedFragment;
import db.movie.test.util.network.NetworkState;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements BaseView {

    private static HomeFragment fragment;
    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;
    @BindView(R.id.fragment_layout)
    FrameLayout fragmentLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @Inject
    HomePresenter presenter;
    TabAdapter adapter;

    public static HomeFragment newInstance() {
        fragment = new HomeFragment();

        return fragment;
    }

    /**
     * Get layout id.
     *
     * @return {@link Integer}
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * Init fragment data.
     */
    @Override
    protected void initViewComponents() {
        presenter.attach(this);
        setupAdapter();
    }

    private void setupAdapter() {
        if (getActivity() != null) {
            adapter = new TabAdapter(getChildFragmentManager());
        }

        adapter.addFragment(new PopularFragment(), getString(R.string.popular));
        adapter.addFragment(new TopRatedFragment(), getString(R.string.topRated));
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
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
