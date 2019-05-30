package fr.evogames.evoconnector.messaging.protocol;

import fr.evogames.evoconnector.messaging.metrics.MetricPacket;
import fr.evogames.evoconnector.messaging.packet.AbstractPacket;

public class Protocol {

    public static final String SPLIT_CHAR = "!";
    public static final String CHANNEL = "Metric";

    public enum ProtocolMap {

        METRIC_PACKET(0x1, MetricPacket.class);


        private int id;
        private Class<? extends AbstractPacket> packetClass;

        ProtocolMap(int id, Class<? extends AbstractPacket> packetClass) {
            this.id = id;
            this.packetClass = packetClass;
        }

        public Class<? extends AbstractPacket> getPacketClass() {
            return packetClass;
        }

        public int getId() {
            return id;
        }

        public static Class<? extends AbstractPacket> getPacketClass(int id) {
            Class<? extends AbstractPacket> packetClass = null;
            for (ProtocolMap map : values()) {
                if (map.getId() == id) {
                    packetClass = map.packetClass;
                    break;
                }
            }
            return packetClass;
        }

        public static int getId(Class<? extends AbstractPacket> packetClass) {
            int id = 0;
            for (ProtocolMap map : values()) {
                if (map.getPacketClass().equals(packetClass)) {
                    id = map.id;
                    break;
                }
            }
            return id;
        }
    }
}
