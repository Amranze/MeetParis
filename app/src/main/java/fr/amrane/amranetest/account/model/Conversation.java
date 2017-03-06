package fr.amrane.amranetest.account.model;

import java.util.List;

/**
 * Created by Amrane Ait Zeouay on 28-Feb-17.
 */

public class Conversation {
    private long _id;
    //XXX should I use User or long
    private long userGetter;
    private long userSender;
    private List<Message> conversation;

    public Conversation(long _id, long userGetter, long userSender, List<Message> conversation) {
        super();
        this._id = _id;
        this.userGetter = userGetter;
        this.userSender = userSender;
        this.conversation = conversation;
    }
    @Override
    public String toString() {
        return "Conversation [_id=" + _id + ", userGetter=" + userGetter + ", userSender=" + userSender
                + ", conversation=" + conversation + "]";
    }
    public long get_id() {
        return _id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public long getUserGetter() {
        return userGetter;
    }
    public void setUserGetter(long userGetter) {
        this.userGetter = userGetter;
    }
    public long getUserSender() {
        return userSender;
    }
    public void setUserSender(long userSender) {
        this.userSender = userSender;
    }
    public List<Message> getConversation() {
        return conversation;
    }
    public void setConversation(List<Message> conversation) {
        this.conversation = conversation;
    }
}
