
package wrightstuff.wowscrubber.model.guild;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Achievement {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rewardItems")
    @Expose
    private List<Object> rewardItems = null;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("criteria")
    @Expose
    private List<Criterium> criteria = null;
    @SerializedName("accountWide")
    @Expose
    private Boolean accountWide;
    @SerializedName("factionId")
    @Expose
    private Integer factionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleBold() {
        return "<b>" + getTitle() + "</b>";
    }

    public String getTitleColored() {
        return "<font color='#FFD100'>[" + getTitle() + "]</font>";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getRewardItems() {
        return rewardItems;
    }

    public void setRewardItems(List<Object> rewardItems) {
        this.rewardItems = rewardItems;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Criterium> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criterium> criteria) {
        this.criteria = criteria;
    }

    public Boolean getAccountWide() {
        return accountWide;
    }

    public void setAccountWide(Boolean accountWide) {
        this.accountWide = accountWide;
    }

    public Integer getFactionId() {
        return factionId;
    }

    public void setFactionId(Integer factionId) {
        this.factionId = factionId;
    }

}
