package fr.evogames.evoconnector.messaging.metrics;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MetricPoint {

    private String measurement;

    private long time;
    private TimeUnit unit;

    private Set<MetricField> fields;

    public MetricPoint(String measurement) {
        this.measurement = measurement;
        this.fields = new HashSet<>();
    }

    public MetricPoint time(long time, TimeUnit timeUnit) {
        this.time = time;
        this.unit = timeUnit;
        return this;
    }

    public MetricPoint addField(String name, Object value) {
        this.fields.add(
                new MetricField(name, value)
        );
        return this;
    }

    public String getMeasurement() {
        return measurement;
    }

    public long getTime() {
        return time;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public Set<MetricField> getFields() {
        return fields;
    }
}
