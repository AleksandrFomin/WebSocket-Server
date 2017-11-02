package websocket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by sasha on 01.11.17.
 */
public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

    public void init(EndpointConfig config){}

    public void destroy() {}

    public ChatMessage decode(String msg) throws DecodeException {
        ChatMessage chatMessage=new ChatMessage();
        JsonObject obj= Json.createReader(new StringReader(msg)).readObject();
        chatMessage.setMessage(obj.getString("message"));
        chatMessage.setSender(obj.getString("sender"));
        chatMessage.setReceived(new Date());
        return chatMessage;
    }

    public boolean willDecode(String s) {
        return true;
    }

}
