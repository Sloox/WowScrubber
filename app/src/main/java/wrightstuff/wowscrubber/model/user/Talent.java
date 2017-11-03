
package wrightstuff.wowscrubber.model.user;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Talent {

    @SerializedName("selected")
    @Expose
    private Boolean selected;
    @SerializedName("talents")
    @Expose
    private List<Talents> talents = null;
    @SerializedName("spec")
    @Expose
    private Spec_ spec;
    @SerializedName("calcTalent")
    @Expose
    private String calcTalent;
    @SerializedName("calcSpec")
    @Expose
    private String calcSpec;

    public Boolean getSelected() {
        return (selected == null) ? false : selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public List<Talents> getTalents() {
        return talents;
    }

    public void setTalents(List<Talents> talents) {
        this.talents = talents;
    }

    public Spec_ getSpec() {
        return spec;
    }

    public void setSpec(Spec_ spec) {
        this.spec = spec;
    }

    public String getCalcTalent() {
        return calcTalent;
    }

    public void setCalcTalent(String calcTalent) {
        this.calcTalent = calcTalent;
    }

    public String getCalcSpec() {
        return calcSpec;
    }

    public void setCalcSpec(String calcSpec) {
        this.calcSpec = calcSpec;
    }

}
