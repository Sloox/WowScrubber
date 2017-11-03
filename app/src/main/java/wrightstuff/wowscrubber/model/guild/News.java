
package wrightstuff.wowscrubber.model.guild;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import wrightstuff.wowscrubber.model.item.Item;

public class News {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("context")
    @Expose
    private String context;
    @SerializedName("bonusLists")
    @Expose
    private List<Integer> bonusLists = null;
    @SerializedName("achievement")
    @Expose
    private Achievement achievement;

    private Item newsItem;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
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

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
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

    public String getHowItemWasRetrieved() {
        if (type == null || type.isEmpty()) return " item data is null ";
        switch (type) {
            case "itemLoot":
                return " aquired ";
            case "itemPurchase":
                return " bought ";
            case "guildAchievement":
            case "playerAchievement":
                return " achieved ";
            case "itemCraft":
                return " crafted";
            default:
                return " aquired ";
        }
    }

    public boolean isAchievement() {
        return "playerAchievement".equalsIgnoreCase(type) || "guildAchievement".equalsIgnoreCase(type);
    }

    public boolean hasItem() {
        return newsItem != null;
    }

    public Item getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(Item newsItem) {
        this.newsItem = newsItem;
    }

    public String toStringJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getCharacterColorCoded() {
        return getCharacter();
    }
}
