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

    public void unknownError() {
        Toast.makeText(getContext(), R.string.text_unknown_error, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(int messageResId) {
        Toast.makeText(getContext(), messageResId, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);
        }
    }

    public void hideLoading() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
    }

    public abstract String getCurrentTag();
}
