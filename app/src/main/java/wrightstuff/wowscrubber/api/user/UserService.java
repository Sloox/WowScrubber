package wrightstuff.wowscrubber.api.user;

import android.content.Context;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wrightstuff.wowscrubber.api.BaseService;
import wrightstuff.wowscrubber.model.user.User;


public class UserService extends BaseService {

    private UserService.UserApi userApi;

    public UserService.UserApi getApi() {
        return userApi;
    }

    public UserService(@NonNull final Context context) {
        super(context, ServiceType.EU_BASE);//creates the retrofit class
        userApi = mRetrofit.create(UserService.UserApi.class);
    }

    public interface UserApi {

        @GET("wow/character/{realm}/{username}")
        Observable<User> retrieveUser(@Path("realm") String realm, @Path("username") String username, @Query("fields") String fields, @Query("locale") String locale, @Query("apikey") String apiKey);
    }
}
