package fr.evogames.evowatchercontroller.metrics;

import fr.evogames.evoconnector.event.EventHandler;
import fr.evogames.evoconnector.event.Listener;
import fr.evogames.evoconnector.messaging.metrics.MetricPacket;
import fr.evogames.evoconnector.messaging.metrics.MetricPoint;
import fr.evogames.evoconnector.messaging.packet.AbstractPacket;
import fr.evogames.evoconnector.messaging.packet.PacketReceiveEvent;
import fr.evogames.evowatchercontroller.database.TimeSeriesDataBase;

public class MetricsManager implements Listener {

    private TimeSeriesDataBase dataBase;

    public MetricsManager(TimeSeriesDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {
        AbstractPacket packet = event.getPacket();
        if (packet instanceof MetricPacket) {
            System.out.println("Event bling !");
            MetricPacket metric = (MetricPacket)packet;
            MetricPoint metricPoint = metric.getMetricPoint();
            dataBase.write(metricPoint);
        }
    }


}
