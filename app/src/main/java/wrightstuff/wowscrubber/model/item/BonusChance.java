
package wrightstuff.wowscrubber.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BonusChance {

    @SerializedName("chanceType")
    @Expose
    private String chanceType;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("sockets")
    @Expose
    private List<Socket> sockets = null;

    public String getChanceType() {
        return chanceType;
    }

    public void setChanceType(String chanceType) {
        this.chanceType = chanceType;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Socket> getSockets() {
        return sockets;
    }

    public void setSockets(List<Socket> sockets) {
        this.sockets = sockets;
    }

}
