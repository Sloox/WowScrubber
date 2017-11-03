package wrightstuff.wowscrubber.api.user;

import io.reactivex.Observable;
import wrightstuff.wowscrubber.model.user.User;

/**
 * Created by michaelwright on 02/08/2017.
 */

public interface UserRepository {
    Observable<User> retrieveUser(String realm, String user);
}
