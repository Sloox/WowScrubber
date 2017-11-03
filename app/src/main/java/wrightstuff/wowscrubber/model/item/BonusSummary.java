
package wrightstuff.wowscrubber.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BonusSummary {

    @SerializedName("defaultBonusLists")
    @Expose
    private List<Object> defaultBonusLists = null;
    @SerializedName("chanceBonusLists")
    @Expose
    private List<Integer> chanceBonusLists = null;
    @SerializedName("bonusChances")
    @Expose
    private List<BonusChance> bonusChances = null;

    public List<Object> getDefaultBonusLists() {
        return defaultBonusLists;
    }

    public void setDefaultBonusLists(List<Object> defaultBonusLists) {
        this.defaultBonusLists = defaultBonusLists;
    }

    public List<Integer> getChanceBonusLists() {
        return chanceBonusLists;
    }

    public void setChanceBonusLists(List<Integer> chanceBonusLists) {
        this.chanceBonusLists = chanceBonusLists;
    }

    public List<BonusChance> getBonusChances() {
        return bonusChances;
    }

    public void setBonusChances(List<BonusChance> bonusChances) {
        this.bonusChances = bonusChances;
    }

}
