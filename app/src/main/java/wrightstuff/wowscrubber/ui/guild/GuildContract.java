package wrightstuff.wowscrubber.ui.guild;

import android.content.Context;

import wrightstuff.wowscrubber.model.guild.GuildNews;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.ui.base.BasePresenter;
import wrightstuff.wowscrubber.ui.base.BaseView;

/**
 * Created by michaelwright on 01/08/2017.
 */

public interface GuildContract {

    interface View extends BaseView {
        void setDataToAdapter(GuildNews data);

        void enableFab(boolean visibility);
    }

    interface Presenter extends BasePresenter<View> {
        void updateGuildNews();

        void sendNewsItemMessage(final Context context, News userNews);
    }
}
