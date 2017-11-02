package websocket;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by sasha on 01.11.17.
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {

    public void init(EndpointConfig config) {}

    public void destroy() {}


    public String encode(ChatMessage chatMessage) throws EncodeException {
        return Json.createObjectBuilder()
                .add("message", chatMessage.getMessage())
                .add("sender", chatMessage.getSender())
                .add("received", chatMessage.getReceived().toString()).build()
                .toString();
    }
}