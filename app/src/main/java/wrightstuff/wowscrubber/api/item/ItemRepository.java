package wrightstuff.wowscrubber.api.item;

import io.reactivex.Observable;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.item.Item;
import wrightstuff.wowscrubber.model.user.Feed;


public interface ItemRepository {
    Observable<Item> retrieveItem(String itemCode, String bonusList);

    Observable<Item> retrieveItem(String itemCode, String bonusList, String context);

    Observable<Item> retrieveItem(News userNews);

    Observable<Item> retrieveItem(Feed userFeed);
}

