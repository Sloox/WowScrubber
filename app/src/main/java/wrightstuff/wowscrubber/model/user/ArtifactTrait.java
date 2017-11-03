
package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtifactTrait {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rank")
    @Expose
    private Integer rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
