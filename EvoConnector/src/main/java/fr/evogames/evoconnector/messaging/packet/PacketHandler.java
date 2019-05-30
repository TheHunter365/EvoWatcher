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
                AbstractPacket packet = this.decoder.decodeRaw(message);
                PacketReceiveEvent event = new PacketReceiveEvent(channel, packet);

                this.eventManager.callEvent(event);
            } catch (MalFormedPacketException e) {
                e.printStackTrace();
            }
        }
    }
}
