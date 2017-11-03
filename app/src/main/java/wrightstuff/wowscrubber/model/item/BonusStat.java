
package wrightstuff.wowscrubber.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BonusStat {

    @SerializedName("stat")
    @Expose
    private Integer stat;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
