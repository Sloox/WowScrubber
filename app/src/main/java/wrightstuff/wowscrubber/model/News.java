
package wrightstuff.wowscrubber.model;

import android.text.format.DateFormat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("CEST"));
        result = format.format(date);
        Log.d("date", format.format(date));

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

}
