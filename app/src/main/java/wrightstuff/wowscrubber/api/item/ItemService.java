package wrightstuff.wowscrubber.api.item;

import android.content.Context;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wrightstuff.wowscrubber.api.BaseService;
import wrightstuff.wowscrubber.model.item.Item;


public class ItemService extends BaseService {

    private ItemApi realmApi;

    public ItemApi getApi() {
        return realmApi;
    }

    public ItemService(@NonNull final Context context) {
        super(context, ServiceType.EU_BASE);//creates the retrofit class, only EU supported for now
        realmApi = mRetrofit.create(ItemApi.class);
    }

    public interface ItemApi {
        @GET("wow/item/{item}")
        Observable<Item> retrieveItem(@Path("item") String item, @Query("bl") String bonusList, @Query("locale") String locale, @Query("apikey") String apiKey);

        @GET("wow/item/{item}/{context}")
        Observable<Item> retrieveItem(@Path("context") String context, @Path("item") String item, @Query("bl") String bonusList, @Query("locale") String locale, @Query("apikey") String apiKey);

    }
}
