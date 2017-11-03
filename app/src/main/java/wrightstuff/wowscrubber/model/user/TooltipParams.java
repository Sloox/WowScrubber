
package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TooltipParams {

    @SerializedName("transmogItem")
    @Expose
    private Integer transmogItem;

    @SerializedName("enchant")
    @Expose
    private Integer enchant;

    @SerializedName("gem0")
    @Expose
    private Integer gem0;
    @SerializedName("gem1")
    @Expose
    private Integer gem1;
    @SerializedName("gem2")
    @Expose
    private Integer gem2;
    @SerializedName("timewalkerLevel")
    @Expose
    private Integer timewalkerLevel;

    @SerializedName("set")
    @Expose
    private List<Integer> set = null;

    public List<Integer> getSet() {
        return set;
    }

    public void setSet(List<Integer> set) {
        this.set = set;
    }



    public Integer getTransmogItem() {
        return transmogItem;
    }

    public void setTransmogItem(Integer transmogItem) {
        this.transmogItem = transmogItem;
    }


    public Integer getGem0() {
        return gem0;
    }

    public void setGem0(Integer gem0) {
        this.gem0 = gem0;
    }

    public Integer getGem1() {
        return gem1;
    }

    public void setGem1(Integer gem1) {
        this.gem1 = gem1;
    }

    public Integer getGem2() {
        return gem2;
    }

    public void setGem2(Integer gem2) {
        this.gem2 = gem2;
    }

    public Integer getTimewalkerLevel() {
        return timewalkerLevel;
    }

    public void setTimewalkerLevel(Integer timewalkerLevel) {
        this.timewalkerLevel = timewalkerLevel;
    }

    public Integer getEnchant() {
        return enchant;
    }

    public void setEnchant(Integer enchant) {
        this.enchant = enchant;
    }


}
