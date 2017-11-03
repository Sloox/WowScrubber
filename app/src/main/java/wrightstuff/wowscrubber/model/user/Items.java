package wrightstuff.wowscrubber.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("averageItemLevel")
    @Expose
    private Integer averageItemLevel;
    @SerializedName("averageItemLevelEquipped")
    @Expose
    private Integer averageItemLevelEquipped;
    @SerializedName("head")
    @Expose
    private Head head;
    @SerializedName("neck")
    @Expose
    private Neck neck;
    @SerializedName("shoulder")
    @Expose
    private Shoulder shoulder;
    @SerializedName("back")
    @Expose
    private Back back;
    @SerializedName("chest")
    @Expose
    private Chest chest;
    @SerializedName("wrist")
    @Expose
    private Wrist wrist;
    @SerializedName("hands")
    @Expose
    private Hands hands;
    @SerializedName("waist")
    @Expose
    private Waist waist;
    @SerializedName("legs")
    @Expose
    private Legs legs;
    @SerializedName("feet")
    @Expose
    private Feet feet;
    @SerializedName("finger1")
    @Expose
    private Finger1 finger1;
    @SerializedName("finger2")
    @Expose
    private Finger2 finger2;
    @SerializedName("trinket1")
    @Expose
    private Trinket1 trinket1;
    @SerializedName("trinket2")
    @Expose
    private Trinket2 trinket2;
    @SerializedName("mainHand")
    @Expose
    private MainHand mainHand;
    @SerializedName("offHand")
    @Expose
    private OffHand offHand;

    public Integer getAverageItemLevel() {
        return averageItemLevel;
    }

    public void setAverageItemLevel(Integer averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    public Integer getAverageItemLevelEquipped() {
        return averageItemLevelEquipped;
    }

    public String getStringAverageItemLevelEquipped() {
        return averageItemLevelEquipped.toString();
    }

    public void setAverageItemLevelEquipped(Integer averageItemLevelEquipped) {
        this.averageItemLevelEquipped = averageItemLevelEquipped;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public Shoulder getShoulder() {
        return shoulder;
    }

    public void setShoulder(Shoulder shoulder) {
        this.shoulder = shoulder;
    }

    public Back getBack() {
        return back;
    }

    public void setBack(Back back) {
        this.back = back;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Wrist getWrist() {
        return wrist;
    }

    public void setWrist(Wrist wrist) {
        this.wrist = wrist;
    }

    public Hands getHands() {
        return hands;
    }

    public void setHands(Hands hands) {
        this.hands = hands;
    }

    public Waist getWaist() {
        return waist;
    }

    public void setWaist(Waist waist) {
        this.waist = waist;
    }

    public Legs getLegs() {
        return legs;
    }

    public void setLegs(Legs legs) {
        this.legs = legs;
    }

    public Feet getFeet() {
        return feet;
    }

    public void setFeet(Feet feet) {
        this.feet = feet;
    }

    public Finger1 getFinger1() {
        return finger1;
    }

    public void setFinger1(Finger1 finger1) {
        this.finger1 = finger1;
    }

    public Finger2 getFinger2() {
        return finger2;
    }

    public void setFinger2(Finger2 finger2) {
        this.finger2 = finger2;
    }

    public Trinket1 getTrinket1() {
        return trinket1;
    }

    public void setTrinket1(Trinket1 trinket1) {
        this.trinket1 = trinket1;
    }

    public Trinket2 getTrinket2() {
        return trinket2;
    }

    public void setTrinket2(Trinket2 trinket2) {
        this.trinket2 = trinket2;
    }

    public MainHand getMainHand() {
        return mainHand;
    }

    public void setMainHand(MainHand mainHand) {
        this.mainHand = mainHand;
    }

    public OffHand getOffHand() {
        return offHand;
    }

    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
    }

}