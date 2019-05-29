package fr.evogames.evoconnector.messaging.bus;

public interface MessagingBus {

    void write(String channel, String data);
}
