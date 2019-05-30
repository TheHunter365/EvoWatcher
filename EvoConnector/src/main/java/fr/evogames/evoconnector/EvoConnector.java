package fr.evogames.evoconnector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.evogames.evoconnector.event.EventManager;
import fr.evogames.evoconnector.messaging.ConnectionManager;
import fr.evogames.evoconnector.messaging.bus.MessagingBus;
import fr.evogames.evoconnector.messaging.bus.RedisBus;
import fr.evogames.evoconnector.messaging.packet.PacketHandler;
import fr.evogames.evoconnector.messaging.protocol.Protocol;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class EvoConnector {

    private Gson gson;
    private MessagingBus messagingBus;

    private final String CHANNEL = "Metric";

    private ConnectionManager connectionManager;
    private EventManager eventManager;

    public EvoConnector() {

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.messagingBus = new RedisBus(new JedisPool());

        this.connectionManager = new ConnectionManager(this.CHANNEL, this.gson, this.messagingBus);

        if (messagingBus instanceof RedisBus) {
            RedisBus bus = (RedisBus) messagingBus;
            Jedis jedis = bus.getResource();
            System.out.println("Start packet decoding");
            new Thread(()->
                    jedis
                            .subscribe(
                                    new PacketHandler(this.eventManager, Protocol.CHANNEL, this.gson),
                                    Protocol.CHANNEL))
                    .start();
        }
        this.eventManager = new EventManager();

    }

    public Gson getGson() {
        return gson;
    }

    public MessagingBus getMessagingBus() {
        return messagingBus;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

}