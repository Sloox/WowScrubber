package wrightstuff.wowscrubber.ui.guild;

import android.content.Context;
import android.util.Log;

import java.util.Collection;
import java.util.Collections;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.realm.RealmRepository;
import wrightstuff.wowscrubber.api.realm.RealmRepositoryMVP;
import wrightstuff.wowscrubber.model.GuildNews;

/**
 * Created by michaelwright on 01/08/2017.
 */

public class GuildPresenter implements GuildContract.Presenter {

    private GuildContract.View mView;

    private RealmRepository realmRepository;

    public GuildPresenter(final Context appContext) {
        realmRepository = new RealmRepositoryMVP(appContext.getResources().getString(R.string.api_key));
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
    public void updateTracks() {
        mView.showLoading();
        realmRepository.retrieveGuildNews("Dragonblight", "Almost Useful").subscribe(guildNews -> {
            mView.hideLoading();
            mView.setDataToAdapter(guildNews);
        }, error -> {
            Log.d("GuildPresenter", "Failed to retrieve guild news - " + error);
            mView.hideLoading();
            mView.showMessage(R.string.text_internet_error);
        });

    }
}
