package fr.evogames.evoconnector.messaging.packet;

public class MalFormedPacketException extends Exception {

    private String packetRaw;

    public MalFormedPacketException(String packetRaw) {
        this.packetRaw = packetRaw;
    }

    public String getPacketRaw() {
        return packetRaw;
    }
}
