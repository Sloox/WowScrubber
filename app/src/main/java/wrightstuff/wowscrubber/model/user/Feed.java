
package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import wrightstuff.wowscrubber.model.guild.Achievement;
import wrightstuff.wowscrubber.model.item.Item;

public class Feed {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("achievement")
    @Expose
    private Achievement achievement;
    @SerializedName("featOfStrength")
    @Expose
    private Boolean featOfStrength;
    @SerializedName("criteria")
    @Expose
    private Criteria criteria;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("context")
    @Expose
    private String context;
    @SerializedName("bonusLists")
    @Expose
    private List<Integer> bonusLists = null;

    private Item feedItem;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeStampAsDate() {
        long time = Long.valueOf(timestamp);
        String result = "";
        Date date = new Date(time);

        int gmtOffset = TimeZone.getDefault().getRawOffset();
        long now = System.currentTimeMillis() + gmtOffset;

        long diffInMillisec = now - date.getTime();
        long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
        long seconds = diffInSec % 60;
        diffInSec /= 60;
        long minutes = diffInSec % 60;
        diffInSec /= 60;
        long hours = diffInSec % 24;
        diffInSec /= 24;
        long days = diffInSec;

        if (days > 0) {
            result += days + "d:";
        }
        if (hours > 0) {
            result += hours + "h:";
        }
        result += minutes + "m:" + seconds + "s ago";

        return result;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Boolean getFeatOfStrength() {
        return featOfStrength;
    }

    public void setFeatOfStrength(Boolean featOfStrength) {
        this.featOfStrength = featOfStrength;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Integer> getBonusLists() {
        return bonusLists;
    }

    public void setBonusLists(List<Integer> bonusLists) {
        this.bonusLists = bonusLists;
    }

    public String getBonusListsForServiceCall() {
        String bonusListResult = "";
        if (bonusLists == null || bonusLists.isEmpty()) return null;
        for (Integer i : bonusLists) {
            bonusListResult += i.toString() + ",";
        }
        bonusListResult = bonusListResult.substring(0, bonusListResult.length() - 1);
        return bonusListResult;
    }

    public Item getFeedItem() {
        return feedItem;
    }

    public void setFeedItem(Item feedItem) {
        this.feedItem = feedItem;
    }

    public boolean hasItem() {
        return feedItem != null;
    }
}
