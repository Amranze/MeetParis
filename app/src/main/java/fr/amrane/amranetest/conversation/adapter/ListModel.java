package fr.amrane.amranetest.conversation.adapter;

/**
 * Created by Amrane Ait Zeouay on 01-Mar-17.
 */

public class ListModel {
    private int imgDrawable;
    private String name;
    private String message;

    public ListModel(int imgDrawable, String name, String message) {
        this.imgDrawable = imgDrawable;
        this.name = name;
        this.message = message;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
