package fr.evogames.evoconnector.messaging.packet;

import com.google.gson.Gson;
import fr.evogames.evoconnector.messaging.protocol.Protocol;

public class PacketDecoder {

    private Gson gson;

    public PacketDecoder(Gson gson) {
        this.gson = gson;
    }


    public AbstractPacket decodeRaw(String raw) throws MalFormedPacketException {
        AbstractPacket packet;

        String[] split = raw.split(Protocol.SPLIT_CHAR);
        int id = Integer.parseInt(split[0]);
        Class<? extends AbstractPacket> packetClass = Protocol.ProtocolMap.getPacketClass(id);
        if (packetClass == null) throw new MalFormedPacketException(raw);
        packet = this.gson.fromJson(split[1], packetClass);
        return packet;
    }
}
