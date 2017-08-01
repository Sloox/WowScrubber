package wrightstuff.wowscrubber.api.realm;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wrightstuff.wowscrubber.model.GuildNews;

/**
 * Created by michaelwright on 01/08/2017.
 */

public class RealmRepositoryMVP implements RealmRepository {

    private RealmService mRealmService;
    private final String apiKey;

    public RealmRepositoryMVP(String apiKey) {
        this.apiKey = apiKey;
        mRealmService = new RealmService();
    }


    @Override
    public Observable<GuildNews> retrieveGuildNews(String realm, String guild) {
        final String fields = GuildFields.NEWS + "," + GuildFields.AUDIT + "," + GuildFields.ACHIEVEMENT;
        final String locale = "en_GB";
        return mRealmService.getApi().retrieveNews(realm, guild, fields, locale, apiKey).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
