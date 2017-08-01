package wrightstuff.wowscrubber.api.realm;

import android.util.Base64;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wrightstuff.wowscrubber.api.BaseService;
import wrightstuff.wowscrubber.model.GuildNews;


public class RealmService extends BaseService {

    private RealmApi realmApi;

    public RealmApi getApi() {
        return realmApi;
    }

    public RealmService() {
        super();//creates the retrofit class
        realmApi = mRetrofit.create(RealmApi.class);
    }

    public interface RealmApi {

        @GET("wow/guild/{realm}/{guildname}")
        Observable<GuildNews> retrieveNews(@Path("realm") String realm, @Path("guildname") String guildname, @Query("fields") String fields, @Query("locale") String locale, @Query("apikey") String apiKey);
    }
}
