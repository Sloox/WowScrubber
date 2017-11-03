package wrightstuff.wowscrubber.api.realm;

import io.reactivex.Observable;
import wrightstuff.wowscrubber.model.guild.GuildNews;

/**
 * Created by michaelwright on 01/08/2017.
 */

public interface RealmRepository {
    Observable<GuildNews> retrieveGuildNews(String realm, String guild);
}

