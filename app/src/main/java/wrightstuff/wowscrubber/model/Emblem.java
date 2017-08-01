
package wrightstuff.wowscrubber.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Emblem {

    @SerializedName("icon")
    @Expose
    private Integer icon;
    @SerializedName("iconColor")
    @Expose
    private String iconColor;
    @SerializedName("iconColorId")
    @Expose
    private Integer iconColorId;
    @SerializedName("border")
    @Expose
    private Integer border;
    @SerializedName("borderColor")
    @Expose
    private String borderColor;
    @SerializedName("borderColorId")
    @Expose
    private Integer borderColorId;
    @SerializedName("backgroundColor")
    @Expose
    private String backgroundColor;
    @SerializedName("backgroundColorId")
    @Expose
    private Integer backgroundColorId;

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public Integer getIconColorId() {
        return iconColorId;
    }

    public void setIconColorId(Integer iconColorId) {
        this.iconColorId = iconColorId;
    }

    public Integer getBorder() {
        return border;
    }

    public void setBorder(Integer border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getBorderColorId() {
        return borderColorId;
    }

    public void setBorderColorId(Integer borderColorId) {
        this.borderColorId = borderColorId;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getBackgroundColorId() {
        return backgroundColorId;
    }

    public void setBackgroundColorId(Integer backgroundColorId) {
        this.backgroundColorId = backgroundColorId;
    }

}
