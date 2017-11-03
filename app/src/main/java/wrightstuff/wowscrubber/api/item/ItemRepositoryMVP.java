package wrightstuff.wowscrubber.api.item;

import android.content.Context;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.item.Item;
import wrightstuff.wowscrubber.model.user.Feed;


public class ItemRepositoryMVP implements ItemRepository {

    private static final String TAG = ItemRepositoryMVP.class.getCanonicalName();
    private static final String EU_EN_locale = "en_GB";
    private ItemService mItemService;
    private final String apiKey;

    public ItemRepositoryMVP(@NonNull final Context context) {
        this.apiKey = context.getString(R.string.api_key);
        mItemService = new ItemService(context);
    }

    @Override
    public Observable<Item> retrieveItem(String itemCode, String bonusList) {
        return mItemService.getApi().retrieveItem(itemCode, bonusList, EU_EN_locale, apiKey).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Item> retrieveItem(String itemCode, String bonusList, String context) {
        return mItemService.getApi().retrieveItem(context, itemCode, bonusList, EU_EN_locale, apiKey).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Item> retrieveItem(News userNews) {
        String itemCode = userNews.getItemId().toString();
        String itemBonusList = userNews.getBonusListsForServiceCall();
        String context = userNews.getContext();
        if (context==null || context.isEmpty()){
            return retrieveItem(itemCode, itemBonusList);
        } else{
            return retrieveItem(itemCode, itemBonusList, context);
        }

    }

    @Override
    public Observable<Item> retrieveItem(Feed userFeed) {
        String itemCode = userFeed.getItemId().toString();
        String itemBonusList = userFeed.getBonusListsForServiceCall();
        String context = userFeed.getContext();
        if (context==null || context.isEmpty()){
            return retrieveItem(itemCode, itemBonusList);
        } else{
            return retrieveItem(itemCode, itemBonusList, context);
        }
    }
}
