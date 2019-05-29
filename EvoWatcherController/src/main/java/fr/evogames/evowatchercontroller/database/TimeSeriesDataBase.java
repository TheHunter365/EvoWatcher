package fr.evogames.evowatchercontroller.database;

import fr.evogames.evoconnector.messaging.metrics.MetricPoint;

public interface TimeSeriesDataBase {

    void write(MetricPoint metricPoint);
}
