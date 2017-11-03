package wrightstuff.wowscrubber.ui.guild;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.realm.RealmRepository;
import wrightstuff.wowscrubber.api.realm.RealmRepositoryMVP;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.ui.MainGuildActivity;

public class GuildPresenter implements GuildContract.Presenter {

    private GuildContract.View mView;

    private RealmRepository realmRepository;

    public GuildPresenter(final Context appContext) {
        realmRepository = new RealmRepositoryMVP(appContext);
    }


    @Override
    public void bind(GuildContract.View view) {
        mView = view;
    }

    @Override
    public void unBind() {
        mView = null;
    }

    @Override
    public void updateGuildNews() {
        mView.showLoading();
        realmRepository.retrieveGuildNews("Dragonblight", "Almost Useful")
                .doOnComplete(() -> mView.hideLoading())
                .subscribe(guildNews -> {
                    mView.setDataToAdapter(guildNews);
                }, error -> {
                    Log.d("GuildPresenter", "Failed to retrieve guild news - " + error);
                    mView.showMessage(R.string.text_internet_error);
                });

    }

    @Override
    public void sendNewsItemMessage(final Context context, News userNews) {
        Intent intent = new Intent(MainGuildActivity.ITEM_NEWS_BROADCAST_EVENT);
        intent.putExtra(MainGuildActivity.ITEM_NEWS_BROADCAST_MESSAGE, userNews.toStringJson());
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

}
