
package wrightstuff.wowscrubber.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuildNews {

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
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("side")
    @Expose
    private Integer side;
    @SerializedName("achievementPoints")
    @Expose
    private Integer achievementPoints;
    @SerializedName("emblem")
    @Expose
    private Emblem emblem;
    @SerializedName("news")
    @Expose
    private List<News> news = null;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(Integer achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public void setEmblem(Emblem emblem) {
        this.emblem = emblem;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}
