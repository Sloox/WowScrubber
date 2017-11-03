
package wrightstuff.wowscrubber.model.guild;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Criterium {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("orderIndex")
    @Expose
    private Integer orderIndex;
    @SerializedName("max")
    @Expose
    private Integer max;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

}
