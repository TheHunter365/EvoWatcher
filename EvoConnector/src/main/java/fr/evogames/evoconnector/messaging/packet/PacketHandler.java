package fr.evogames.evoconnector.messaging.packet;

import com.google.gson.Gson;
import redis.clients.jedis.JedisPubSub;

public class PacketHandler extends JedisPubSub {

    private PacketDecoder decoder;
    private PacketListenerManager packetListenerManager;
    private String channel;

    public PacketHandler(String channel, Gson gson, PacketListenerManager listenerManager) {
        this.channel = channel;
        this.packetListenerManager = listenerManager;
        this.decoder = new PacketDecoder(gson);
    }

    @Override
    public void onMessage(String channel, String message) {
        if (channel.equals(this.channel)) {

        }
    }
}
