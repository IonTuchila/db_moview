package db.movie.test.common.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;
import db.movie.test.screens.main.NavigationCallback;

public abstract class BaseFragment extends DaggerFragment implements BaseView {

    protected NavigationCallback router;
    private Unbinder unbinder;

    /**
     * Returns an int representation of layout resource id.
     *
     * @return layout resource id.
     */
    protected abstract int getLayoutId();

    /**
     * System callback method is called when creates view.
     *
     * @param inflater           {@link LayoutInflater} used to inflate Views of this Fragment.
     * @param container          {@link ViewGroup}  this is the parent view that the fragment's UI should be attached
     *                           to.
     * @param savedInstanceState {@link Bundle} if non-null, this fragment is being re-constructed from a previous
     *                           saved state as given here.
     * @return {@link View} return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = getView() != null ? getView() : inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof NavigationCallback) {
            router = ((NavigationCallback) context);
        } else {
            throw new RuntimeException("Activity must implement " + NavigationCallback.class.getSimpleName());
        }
    }

    /**
     * System callback method is called when view is created.
     *
     * @param view               {@link View} inflated with layout.
     * @param savedInstanceState {@link Bundle} that contains view state if it was saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // It Will be used globally,
        // DO NOT REMOVE IT ELSE WILL HAVE BUGS WITH DISABLE ADS
        initViewComponents();
    }

    /**
     * System callback method, called when the Fragment is visible to the user.
     */
    @Override
    public void onStart() {
        super.onStart();
        attachPresenter();
    }


    /**
     * Attaches view to presenter.
     */
    protected void attachPresenter() {
        getPresenter().attach(this);
    }

    /**
     * Called when view is ready. Here we init view components and stats network requests.
     */
    protected abstract void initViewComponents();


    /**
     * Returns the root level of the activity to calculate height of the view.
     *
     * @param activity is the MainActivity.
     * @return root view.
     */
    private View getActivityRoot(Activity activity) {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }

    /**
     * System callback method is called when view is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    /**
     * Returns fullslug link for current screen;
     *
     * @return {@link String} fullslug link.
     */
    @NonNull
    public abstract String getFullSlug();

    /**
     * System method is called when the Fragment is no longer started.
     */
    @Override
    public void onStop() {
        getPresenter().detach();
        super.onStop();
    }

    /**
     * Returns presenter.
     *
     * @return an implementation of {@link BasePresenter}
     */
    protected abstract BasePresenter getPresenter();

    /**
     * System callback method is called when view is put in back stack.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }

    }
}
