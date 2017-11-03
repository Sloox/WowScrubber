
package wrightstuff.wowscrubber.model.user;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relic {

    @SerializedName("socket")
    @Expose
    private Integer socket;
    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("context")
    @Expose
    private Integer context;
    @SerializedName("bonusLists")
    @Expose
    private List<Integer> bonusLists = null;

    public Integer getSocket() {
        return socket;
    }

    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getContext() {
        return context;
    }

    public void setContext(Integer context) {
        this.context = context;
    }

    public List<Integer> getBonusLists() {
        return bonusLists;
    }

    public void setBonusLists(List<Integer> bonusLists) {
        this.bonusLists = bonusLists;
    }

}
