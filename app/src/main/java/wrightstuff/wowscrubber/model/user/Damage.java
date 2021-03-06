
package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Damage {

    @SerializedName("min")
    @Expose
    private Integer min;
    @SerializedName("max")
    @Expose
    private Integer max;
    @SerializedName("exactMin")
    @Expose
    private Double exactMin;
    @SerializedName("exactMax")
    @Expose
    private Double exactMax;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getExactMin() {
        return exactMin;
    }

    public void setExactMin(Double exactMin) {
        this.exactMin = exactMin;
    }

    public Double getExactMax() {
        return exactMax;
    }

    public void setExactMax(Double exactMax) {
        this.exactMax = exactMax;
    }

}
