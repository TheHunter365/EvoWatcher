package fr.evogames.evoconnector.messaging;

import com.google.gson.Gson;
import fr.evogames.evoconnector.messaging.bus.MessagingBus;
import fr.evogames.evoconnector.messaging.packet.AbstractPacket;
import fr.evogames.evoconnector.messaging.packet.MalFormedPacketException;
import fr.evogames.evoconnector.messaging.protocol.Protocol;

public class ConnectionManager {

    private String channel;
    private Gson gson;
    private MessagingBus messagingBus;

    public ConnectionManager(String channel, Gson gson, MessagingBus messagingBus) {
        this.channel = channel;
        this.gson = gson;
        this.messagingBus = messagingBus;
    }

    public void sendPacket(AbstractPacket packet) {
        int id = Protocol.ProtocolMap.getId(packet.getClass());
        String raw = this.gson.toJson(packet);

        if (id == 0) {
            try {
                throw new MalFormedPacketException(raw);
            } catch (MalFormedPacketException e) {
                e.printStackTrace();
            }
        }
        String message = id + Protocol.SPLIT_CHAR + raw;
        this.messagingBus.write(channel, message);
    }
}
