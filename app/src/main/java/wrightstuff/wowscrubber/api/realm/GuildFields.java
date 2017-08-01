package wrightstuff.wowscrubber.api.realm;

/**
 * Created by michaelwright on 01/08/2017.
 */

public enum GuildFields {
    NEWS,
    ACHIEVEMENT,
    AUDIT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
