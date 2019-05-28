package fr.evogames.evoconnector.messaging.protocol;

import fr.evogames.evoconnector.messaging.packet.AbstractPacket;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public abstract class Protocol {

    private String name;
    private Set<Consumer<AbstractPacket>> packetConsummer;

    public Protocol(String name) {
        this.name = name;
        this.packetConsummer = new HashSet<>();
    }

    public void addPacketConsumer(Consumer<AbstractPacket> packetConsumer) {
        this.packetConsummer.add(packetConsumer);
    }

}