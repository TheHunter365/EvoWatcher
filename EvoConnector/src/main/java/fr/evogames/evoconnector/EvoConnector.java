package fr.evogames.evoconnector;

import redis.clients.jedis.JedisPool;

public class EvoConnector {

    private JedisPool jedisPool;

    public EvoConnector(String redisHost, int port) {
        this.jedisPool = new JedisPool(redisHost, port);
    }
}
