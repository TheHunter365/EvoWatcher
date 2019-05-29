package fr.evogames.evoconnector.messaging.metrics;

import fr.evogames.evoconnector.messaging.packet.AbstractPacket;

public class MetricPacket extends AbstractPacket {

    private MetricPoint metricPoint;

    public MetricPacket(MetricPoint metricPoint) {
        this.metricPoint = metricPoint;
    }

    public MetricPoint getMetricPoint() {
        return metricPoint;
    }

}
