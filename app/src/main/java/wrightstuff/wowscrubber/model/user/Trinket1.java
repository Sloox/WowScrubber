
package wrightstuff.wowscrubber.model.user;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trinket1 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("quality")
    @Expose
    private Integer quality;
    @SerializedName("itemLevel")
    @Expose
    private Integer itemLevel;
    @SerializedName("tooltipParams")
    @Expose
    private TooltipParams tooltipParams;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("armor")
    @Expose
    private Integer armor;
    @SerializedName("context")
    @Expose
    private String context;
    @SerializedName("bonusLists")
    @Expose
    private List<Integer> bonusLists = null;
    @SerializedName("artifactId")
    @Expose
    private Integer artifactId;
    @SerializedName("displayInfoId")
    @Expose
    private Integer displayInfoId;
    @SerializedName("artifactAppearanceId")
    @Expose
    private Integer artifactAppearanceId;
    @SerializedName("artifactTraits")
    @Expose
    private List<Object> artifactTraits = null;
    @SerializedName("relics")
    @Expose
    private List<Object> relics = null;
    @SerializedName("appearance")
    @Expose
    private Appearance appearance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public TooltipParams getTooltipParams() {
        return tooltipParams;
    }

    public void setTooltipParams(TooltipParams tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
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

    public Integer getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(Integer artifactId) {
        this.artifactId = artifactId;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public Integer getArtifactAppearanceId() {
        return artifactAppearanceId;
    }

    public void setArtifactAppearanceId(Integer artifactAppearanceId) {
        this.artifactAppearanceId = artifactAppearanceId;
    }

    public List<Object> getArtifactTraits() {
        return artifactTraits;
    }

    public void setArtifactTraits(List<Object> artifactTraits) {
        this.artifactTraits = artifactTraits;
    }

    public List<Object> getRelics() {
        return relics;
    }

    public void setRelics(List<Object> relics) {
        this.relics = relics;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

}
