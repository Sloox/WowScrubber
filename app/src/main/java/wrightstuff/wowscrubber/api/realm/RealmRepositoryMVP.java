package wrightstuff.wowscrubber.api.realm;

import android.content.Context;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.commons.WowFields;
import wrightstuff.wowscrubber.model.guild.GuildNews;


public class RealmRepositoryMVP implements RealmRepository {

    private RealmService mRealmService;
    private final String apiKey;

    public RealmRepositoryMVP(@NonNull final Context context) {
        this.apiKey = context.getString(R.string.api_key);
        mRealmService = new RealmService(context);
    }


    @Override
    public Observable<GuildNews> retrieveGuildNews(String realm, String guild) {
        final String fields = WowFields.NEWS + "," + WowFields.AUDIT + "," + WowFields.ACHIEVEMENT;
        final String locale = "en_GB";
        return mRealmService.getApi().retrieveNews(realm, guild, fields, locale, apiKey).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
