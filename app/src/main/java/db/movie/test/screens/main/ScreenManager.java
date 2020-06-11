package db.movie.test.screens.main;

import android.os.Handler;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ScreenManager {

    private FragmentManager fragmentManager;
    private MainActivity activity;

    public ScreenManager(MainActivity activity) {
        this.activity = activity;
        this.fragmentManager = activity.getSupportFragmentManager();
    }

    /**
     * Replaces container with fragment and add that fragment to back stack.
     *
     * @param containerId a {@link android.view.View} id that is container for fragment.
     * @param fragment    a {@link Fragment} that should be displayed.
     */
    public void navigateToFragment(@IdRes int containerId, Fragment fragment) {
        new Handler().post(() -> fragmentManager
                .beginTransaction()
                .replace(containerId, fragment, getFragmentTag(fragment))
                .addToBackStack(getFragmentTag(fragment))
                .commitAllowingStateLoss());
    }

    /**
     * Returns fragment tag.
     *
     * @param fragment {@link Fragment} current fragment.
     * @return {@link String} representation of Fragment canonical name, used as a tag, or in case fragment is not
     * found null.
     */
    private String getFragmentTag(@Nullable Fragment fragment) {
        return fragment != null ? fragment.getClass().getCanonicalName() : null;
    }

}
