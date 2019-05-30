package fr.evogames.evoconnector.messaging.packet;

import com.google.gson.Gson;
import fr.evogames.evoconnector.event.EventManager;
import redis.clients.jedis.JedisPubSub;

public class PacketHandler extends JedisPubSub {

    private EventManager eventManager;
    private PacketDecoder decoder;
    private String channel;

    public PacketHandler(EventManager eventManager, String channel, Gson gson) {
        this.eventManager = eventManager;
        this.channel = channel;
        this.decoder = new PacketDecoder(gson);
    }

    @Override
    public void onMessage(String channel, String message) {
        if (this.channel.equals(channel)) {
            try {
                System.out.println("EvoConnector: Deconding packet !");
                AbstractPacket packet = this.decoder.decodeRaw(message);

                this.eventManager.callEvent(packet);
            } catch (MalFormedPacketException e) {
                e.printStackTrace();
            }
        }
    }
}
