package fr.amrane.amranetest.account.model;

/**
 * Created by Amrane Ait Zeouay on 28-Feb-17.
 */

public class Message {
    private long _id;
    //change String with long for id
    private String sender;
    private String receiver;
    private String message;
    private long timeStamp;
    private String senderUrl;
    private boolean messageSent;
    private boolean messageRead;
    private boolean messageReceived;

    public Message(long _id, String sender, String receiver, String message, long timeStamp, String senderUrl,
                   boolean messageSent, boolean messageRead, boolean messageReceived) {
        super();
        this._id = _id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timeStamp = timeStamp;
        this.senderUrl = senderUrl;
        this.messageSent = messageSent;
        this.messageRead = messageRead;
        this.messageReceived = messageReceived;
    }

    @Override
    public String toString() {
        return "Message [_id=" + _id + ", sender=" + sender + ", receiver=" + receiver + ", message=" + message
                + ", timeStamp=" + timeStamp + ", senderUrl=" + senderUrl + ", messageSent=" + messageSent
                + ", messageRead=" + messageRead + ", messageReceived=" + messageReceived +"]";
    }
    public long get_id() {
        return _id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getSenderUrl() {
        return senderUrl;
    }
    public void setSenderUrl(String senderUrl) {
        this.senderUrl = senderUrl;
    }
    public boolean isMessageSent() {
        return messageSent;
    }
    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }
    public boolean isMessageRead() {
        return messageRead;
    }
    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }
    public boolean isMessageReceived() {
        return messageReceived;
    }
    public void setMessageReceived(boolean messageReceived) {
        this.messageReceived = messageReceived;
    }
}
