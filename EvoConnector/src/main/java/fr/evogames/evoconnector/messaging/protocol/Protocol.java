package fr.evogames.evoconnector.messaging.protocol;

import fr.evogames.evoconnector.messaging.packet.AbstractPacket;

public class Protocol {


    public static final String SPLIT_CHAR = "|";


    public enum ProtocolMap {

        ;
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

        public Class<? extends AbstractPacket> getPacketClass(int id) {
            Class<? extends AbstractPacket> packetClass = null;
            for (ProtocolMap map : values()) {
                if (map.getId() == id) {
                    packetClass = map.packetClass;
                    break;
                }
            }
            return packetClass;
        }
    }
}
