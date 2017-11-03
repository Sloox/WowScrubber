package wrightstuff.wowscrubber.ui.user;

import android.content.Context;
import android.util.Log;

import retrofit2.HttpException;
import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.user.UserRepository;
import wrightstuff.wowscrubber.api.user.UserRepositoryMVP;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.user.User;


public class UserPresenter implements UserContract.Presenter {
    private UserContract.View mView;
    private UserRepository mUserRepository;

    public UserPresenter(final Context context) {
        mUserRepository = new UserRepositoryMVP(context);

    }

    @Override
    public void bind(UserContract.View view) {
        mView = view;
    }

    @Override
    public void unBind() {
        mView = null;
    }

    @Override
    public void refreshUserDetails(final News news) {
        mUserRepository.retrieveUser("Dragonblight", news.getCharacter())
                .doOnComplete(() -> mView.hideLoading())
                .subscribe(userNews -> {
                    updateUserView(userNews, news);
                }, error -> {
                    if (error instanceof HttpException) {
                        mView.showMessage("Failed to retrieve " + news.getCharacter() + ", trying connected realm...");
                        retrieveUserAlternative(news.getCharacter(), "Ghostlands", news);
                    } else {
                        Log.d("UserPresenter", "Failed to retrieve guild news - " + error);
                        mView.showMessage(R.string.text_internet_error);
                    }

                });

    }

    public void retrieveUserAlternative(final String character, final String realm, final News news) {
        mUserRepository.retrieveUser(realm, character)
                .doOnComplete(() -> mView.hideLoading())
                .subscribe(userResult -> {
                    updateUserView(userResult, news);
                }, error -> {
                    Log.d("UserPresenter", "Failed to retrieve guild news - " + error);
                    mView.showMessage(R.string.text_internet_error);
                });

    }

    private void updateUserView(final User userNews, final News news) {
        mView.updateUserNewsView(userNews, news);
        mView.setUserNewsPicture("https://render-eu.worldofwarcraft.com/character/" + userNews.getThumbnail());
    }
}


