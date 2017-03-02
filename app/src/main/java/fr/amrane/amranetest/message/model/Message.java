package fr.amrane.amranetest.message.model;

/**
 * Created by aaitzeouay on 27/02/2017.
 */

public class Message {
    public static final int STATUS_SENDING  = 0;
    public static final int STATUS_SENT     = 1;
    public static final int STATUS_FAILED   = 2;
    public static final int STATUS_RECEIVED = 3;
    public static final int STATUS_READ     = 4;

    private long id;
    private long idSender;
    private long idReceiver;
    private String message;
    private long timeStamp;
    private String senderUrl;
    /*private boolean messageSent;
    private boolean messageRead;
    private boolean messageReceived;*/
    private int status;

    public Message() {
    }

    public Message(long id, long idSender, long idReceiver, String message, long timeStamp, String senderUrl, int status) {
        this.id = id;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.message = message;
        this.timeStamp = timeStamp;
        this.senderUrl = senderUrl;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
