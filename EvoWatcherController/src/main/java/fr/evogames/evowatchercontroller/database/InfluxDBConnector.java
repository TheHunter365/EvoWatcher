package fr.evogames.evowatchercontroller.database;

import fr.evogames.evoconnector.messaging.metrics.MetricPoint;
import fr.evogames.evoconnector.messaging.metrics.MetricTag;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.util.stream.Collectors;

public class InfluxDBConnector implements TimeSeriesDataBase {

    private InfluxDB influxDB;

    public InfluxDBConnector(String host, String user, String password) {
        this.influxDB = InfluxDBFactory.connect(host, user, password);
    }

    public InfluxDB getInfluxDB() {
        return influxDB;
    }

    public void setDatabase(String database) {
        this.influxDB.setDatabase(database);
    }

    public void write(MetricPoint metricPoint) {
        Point.Builder pointBuider = Point.measurement(metricPoint.getMeasurement())
                .time(metricPoint.getTime(), metricPoint.getUnit());

        metricPoint.getFields().forEach((field)->pointBuider.addField(field.getName(), field.getValue()));

        pointBuider.tag(metricPoint.getTags().stream().collect(
                Collectors.toMap(MetricTag::getTagKey, MetricTag::getTagValue)
        ));

    }
}
