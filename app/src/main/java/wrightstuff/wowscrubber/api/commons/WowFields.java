package wrightstuff.wowscrubber.api.commons;

/**
 * Created by michaelwright on 01/08/2017.
 */

public enum WowFields {
    NEWS,
    ACHIEVEMENT,
    ACHIEVEMENTS,
    AUDIT,
    ITEMS,
    TALENTS,
    FEED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
