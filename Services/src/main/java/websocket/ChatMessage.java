package websocket;

import java.util.Date;

/**
 * Created by sasha on 01.11.17.
 */
public class ChatMessage {
    private String message;
    private String sender;
    private Date received;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }
}
