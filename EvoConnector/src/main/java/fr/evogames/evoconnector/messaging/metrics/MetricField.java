package fr.evogames.evoconnector.messaging.metrics;

public class MetricField {

    private String name;
    private Object value;

    public MetricField(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
