package fr.evogames.evoconnector.messaging.packet;

public abstract class AbstractPacket {

    private int header;
    private char divider;
    private String body;

    public String toString() {
        return new StringBuilder()
                .append(this.header)
                .append(this.divider)
                .append(this.body).toString();
    }
}
