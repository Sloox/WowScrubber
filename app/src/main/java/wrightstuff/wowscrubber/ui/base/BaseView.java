package wrightstuff.wowscrubber.ui.base;

import android.content.Context;

/**
 * This is the base interface for MVP view component
 */
public interface BaseView {

    Context getContext();

    void unknownError();

    void showMessage(int messageResId);

    void showMessage(String message);

    void showLoading();

    void hideLoading();
}
