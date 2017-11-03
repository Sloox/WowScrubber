package wrightstuff.wowscrubber.api.user;

import android.content.Context;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.commons.WowFields;
import wrightstuff.wowscrubber.model.user.User;

public class UserRepositoryMVP implements UserRepository {

    private UserService mUserService;
    private final String apiKey;

    public UserRepositoryMVP(final Context context) {
        this.apiKey = context.getString(R.string.api_key);
        mUserService = new UserService(context);
    }

    @Override
    public Observable<User> retrieveUser(String realm, String user) {
        final String fields = WowFields.FEED + "," + WowFields.ACHIEVEMENTS + "," + WowFields.ITEMS + "," + WowFields.TALENTS;
        final String locale = "en_GB";
        return mUserService.getApi().retrieveUser(realm, user, fields, locale, apiKey).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
