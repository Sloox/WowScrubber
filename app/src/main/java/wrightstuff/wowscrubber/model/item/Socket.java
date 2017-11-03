
package wrightstuff.wowscrubber.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Socket {

    @SerializedName("socketType")
    @Expose
    private String socketType;

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

}
