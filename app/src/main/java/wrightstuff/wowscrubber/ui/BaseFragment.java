package wrightstuff.wowscrubber.ui;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import wrightstuff.wowscrubber.R;


/**
 * This is the BaseFragment for all Fragments in our App.
 */
public abstract class BaseFragment extends Fragment {

    protected View mLoadingView;
    protected View mContentView;

    public void unknownError() {
        Toast.makeText(getContext(), R.string.text_unknown_error, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(int messageResId) {
        Toast.makeText(getContext(), messageResId, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    /**
     * Default implementation of loading view showLoading
     * Override if different implementation is needed
     * As per default behaviour the expects a content view & a loading view to be present
     * Content view is what is shown after the load has completed
     */
    public void showLoading() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);

        }
        if (mContentView != null) {
            mContentView.setVisibility(View.GONE);
        }
    }

    /**
     * Default implementation of loading view HideLoading
     * Override if different implementation is needed
     * As per default behaviour the expects a content view & a loading view to be present
     * Content view is what is shown after the load has completed
     */
    public void hideLoading() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
        if (mContentView != null) {
            mContentView.setVisibility(View.VISIBLE);
        }
    }

    public abstract String getCurrentTag();
}
