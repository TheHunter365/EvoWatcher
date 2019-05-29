package fr.evogames.evoconnector.messaging.packet;

import com.google.gson.Gson;

public class PacketDecoder {

    private Gson gson;

    public PacketDecoder(Gson gson) {
        this.gson = gson;
    }


    public AbstractPacket decodeRaw(String raw) {
        AbstractPacket packet = null;

        return packet;
    }
}
