package fr.evogames.evoconnector.messaging.metrics;

public class MetricTag {

    private String tagKey;
    private String tagValue;

    public MetricTag(String tagKey, String tagValue) {
        this.tagKey = tagKey;
        this.tagValue = tagValue;
    }

    public String getTagKey() {
        return tagKey;
    }

    public String getTagValue() {
        return tagValue;
    }
}
