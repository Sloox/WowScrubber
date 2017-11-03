package wrightstuff.wowscrubber.ui.user;

import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.user.User;
import wrightstuff.wowscrubber.ui.base.BasePresenter;
import wrightstuff.wowscrubber.ui.base.BaseView;


interface UserContract {
    interface View extends BaseView {
        void updateUserNewsView(final User userDetails, final News news);

        void setUserNewsPicture(String url);
    }

    interface Presenter extends BasePresenter<UserContract.View> {
        void refreshUserDetails(final News news);
    }
}
