
package wrightstuff.wowscrubber.model.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appearance {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("itemAppearanceModId")
    @Expose
    private Integer itemAppearanceModId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemAppearanceModId() {
        return itemAppearanceModId;
    }

    public void setItemAppearanceModId(Integer itemAppearanceModId) {
        this.itemAppearanceModId = itemAppearanceModId;
    }

    @SerializedName("enchantDisplayInfoId")
    @Expose
    private Integer enchantDisplayInfoId;

    public Integer getEnchantDisplayInfoId() {
        return enchantDisplayInfoId;
    }

    public void setEnchantDisplayInfoId(Integer enchantDisplayInfoId) {
        this.enchantDisplayInfoId = enchantDisplayInfoId;
    }


}
