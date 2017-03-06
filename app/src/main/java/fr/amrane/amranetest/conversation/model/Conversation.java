package fr.amrane.amranetest.conversation.model;

import java.util.List;

import fr.amrane.amranetest.message.model.Message;

/**
 * Created by aaitzeouay on 01/03/2017.
 */

public class Conversation {
    private long id;
    //XXX should I use User or long
    private long idBuddy;
    private long idUser;
    private List<Message> conversation;

    public Conversation(long id, long idBuddy, long idUser, List<Message> conversation) {
        super();
        this.id = id;
        this.idBuddy = idBuddy;
        this.idUser = idUser;
        this.conversation = conversation;
    }
    @Override
    public String toString() {
        return "Conversation [id=" + id + ", idBuddy=" + idBuddy + ", idUser=" + idUser
                + ", conversation=" + conversation + "]";
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdBuddy() {
        return idBuddy;
    }
    public void setIdBuddy(long idBuddy) {
        this.idBuddy = idBuddy;
    }
    public long getIdUser() {
        return idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public List<Message> getConversation() {
        return conversation;
    }
    public void setConversation(List<Message> conversation) {
        this.conversation = conversation;
    }
}
