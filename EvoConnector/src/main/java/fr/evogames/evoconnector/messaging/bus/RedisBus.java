package fr.evogames.evoconnector.messaging.bus;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBus implements MessagingBus {

    private JedisPool jedisPool;

    private Jedis jedisInstance;

    public RedisBus(JedisPool jedisPool) {
        this.jedisPool = jedisPool;

        this.jedisInstance = this.getResource();
    }

    public Jedis getResource() {
        return this.jedisPool.getResource();
    }

    @Override
    public void write(String channel, String data) {
        this.jedisInstance.publish(channel, data);
    }
}
