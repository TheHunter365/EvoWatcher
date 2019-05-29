package fr.evogames.evoconnector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.evogames.evoconnector.messaging.bus.MessagingBus;
import fr.evogames.evoconnector.messaging.bus.RedisBus;
import redis.clients.jedis.JedisPool;

public class EvoConnector {

    private Gson gson;
    private MessagingBus messagingBus;

    public EvoConnector() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        this.messagingBus = new RedisBus(new JedisPool());
    }

    public MessagingBus getMessagingBus() {
        return messagingBus;
    }

    public Gson getGson() {
        return gson;
    }
}