package wrightstuff.wowscrubber.ui.guild;

import java.util.List;

import wrightstuff.wowscrubber.model.GuildNews;
import wrightstuff.wowscrubber.ui.base.BasePresenter;
import wrightstuff.wowscrubber.ui.base.BaseView;

/**
 * Created by michaelwright on 01/08/2017.
 */

public interface GuildContract {

        interface View extends BaseView {
            void setDataToAdapter(GuildNews data);
        }

        interface Presenter extends BasePresenter<View> {
            void updateTracks();
        }
}
