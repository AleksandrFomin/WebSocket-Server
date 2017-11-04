package websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ServerEndpoint(value="/chat/{chatName}", encoders =ChatMessageEncoder.class, decoders = ChatMessageDecoder.class )
public class ChatServer {
   // private Map<String, String> usernames = new HashMap<String, String>();
    Logger logger=Logger.getLogger(getClass().getName());

    @OnOpen
    public void open(Session session, @PathParam("chatName") String chatName) throws IOException, EncodeException {
        logger.info("connected");
        session.getUserProperties().put("chatName",chatName);
    }

    @OnClose
    public void close(Session session) throws IOException, EncodeException {
//        String userId = session.getId();
//        if (usernames.containsKey(userId)) {
//            String username = usernames.get(userId);
//            usernames.remove(userId);
//            for (Session peer : session.getOpenSessions())
//                peer.getBasicRemote().sendText("(Server): " + username + " left the chat room.");
//        }
    }

    @OnMessage
    public void handleMessage(Session session,ChatMessage chatMessage) throws IOException, EncodeException {
        logger.info("recieved = " + chatMessage.getMessage());
        String chatName=(String)session.getUserProperties().get("chatName");
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()
                        && chatName.equals(s.getUserProperties().get("chatName"))) {
                    s.getBasicRemote().sendObject(chatMessage);
                }
            }
        } catch (EncodeException e) {
        }
    }
}