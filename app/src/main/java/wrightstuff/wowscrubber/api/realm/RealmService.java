package wrightstuff.wowscrubber.api.realm;

import android.content.Context;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wrightstuff.wowscrubber.api.BaseService;
import wrightstuff.wowscrubber.model.guild.GuildNews;


public class RealmService extends BaseService {

    private RealmApi realmApi;

    public RealmApi getApi() {
        return realmApi;
    }

    public RealmService(@NonNull final Context context) {
        super(context, ServiceType.EU_BASE);//creates the retrofit class, only EU supported for now
        realmApi = mRetrofit.create(RealmApi.class);
    }

    public interface RealmApi {

        @GET("wow/guild/{realm}/{guildname}")
        Observable<GuildNews> retrieveNews(@Path("realm") String realm, @Path("guildname") String guildname, @Query("fields") String fields, @Query("locale") String locale, @Query("apikey") String apiKey);
    }
}
