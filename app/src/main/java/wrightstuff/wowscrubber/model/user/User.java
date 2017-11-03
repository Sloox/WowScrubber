
package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import wrightstuff.wowscrubber.model.guild.News;

public class User {

    @SerializedName("lastModified")
    @Expose
    private Long lastModified;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("realm")
    @Expose
    private String realm;
    @SerializedName("battlegroup")
    @Expose
    private String battlegroup;
    @SerializedName("class")
    @Expose
    private Integer _class;
    @SerializedName("race")
    @Expose
    private Integer race;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("achievementPoints")
    @Expose
    private Integer achievementPoints;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("calcClass")
    @Expose
    private String calcClass;
    @SerializedName("faction")
    @Expose
    private Integer faction;
    @SerializedName("feed")
    @Expose
    private List<Feed> feed = null;
    @SerializedName("totalHonorableKills")
    @Expose
    private Integer totalHonorableKills;
    @SerializedName("items")
    @Expose
    private Items items;

    @SerializedName("talents")
    @Expose
    private List<Talent> talents = null;

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(Integer achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCalcClass() {
        return calcClass;
    }

    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }

    public Integer getFaction() {
        return faction;
    }

    public void setFaction(Integer faction) {
        this.faction = faction;
    }

    public List<Feed> getFeed() {
        if (feed == null) {
            feed = new ArrayList<>();
        }
        return feed;
    }

    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }

    public Integer getTotalHonorableKills() {
        return totalHonorableKills;
    }

    public void setTotalHonorableKills(Integer totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    public String getClassAsString() {
        switch (getClass_()) {
            case 1:
                return "Warrior";
            case 2:
                return "Paladin";
            case 3:
                return "Hunter";
            case 4:
                return "Rogue";
            case 5:
                return "Priest";
            case 6:
                return "Death Knight";
            case 7:
                return "Shaman";
            case 8:
                return "Mage";
            case 11:
                return "Druid";
            case 9:
                return "Warlock";
            case 10:
                return "Monk";
            case 12:
                return "Demon Hunter";
            default:
                return "Unknown";
        }
    }

    public String getClassTalentTypeString() {
        if (talents == null || talents.isEmpty()) {
            return getClassAsString();
        }
        for (Talent t : talents) {
            if (t.getSelected()) {
                return t.getSpec().getName() + " " + getClassAsString();
            }
        }

        return getClassAsString();
    }

    public String getGenderAsString() {
        switch (getGender()) {
            case 0:
                return "Male";
            case 1:
                return "Female";
            default:
                return "Apache Helicopter";
        }
    }

    public String getRaceAsString() {

        switch (getRace()) {
            case 1:
                return "Human";
            case 2:
                return "Orc";
            case 3:
                return "Dwarf";
            case 4:
                return "Nightelf";
            case 5:
                return "Undead";
            case 6:
                return "Tauren";
            case 7:
                return "Gnome";
            case 8:
                return "Troll";
            case 9:
                return "Unused";
            case 10:
                return "Bloodelf";
            case 11:
                return "Draenei";
            default:
                return "Alien";
        }
    }

    public String getLastOnline(final long newsTimeStamp) {
        String onlineResult = "";
        if (newsTimeStamp > lastModified) {
            onlineResult = "<br/><font color='#86FF33'>Online</font>";
        } else {
            onlineResult = "<br/><font color='#FF3333'>Offline</font>";
        }
        long time = Long.valueOf(lastModified);
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
            result += days + " d, ";
        }
        if (hours > 0) {
            result += hours + "h:";
        }
        result += minutes + "m:" + seconds + "s";

        return "Last online:<br/>" + result + onlineResult;
    }


    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Talent> getTalents() {
        return talents;
    }

    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }
}
