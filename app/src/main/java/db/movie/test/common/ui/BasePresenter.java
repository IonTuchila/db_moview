package db.movie.test.common.ui;

/**
 * Base presenter interface.
 *
 * @param <V> view placeholder.
 */
public class BasePresenter<V extends BaseView> {

    protected V view;

    /**
     * Attaches view to presenter.
     *
     * @param view view.
     */
    public void attach(V view) {
        this.view = view;
    }

    /**
     * Detaches view.
     */
    public void detach() {
        this.view = null;
    }

}

