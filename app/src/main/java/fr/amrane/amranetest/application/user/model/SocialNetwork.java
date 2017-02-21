package fr.amrane.amranetest.application.user.model;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class SocialNetwork {
    private String facebookUrl;
    private String facebookAccountName;
    private String twitterUrl;
    private String twitterAccountName;
    private String instagramUrl;
    private String instagramAccountName;
    private String snapchatUrl;
    private String snapchatAccountName;

    public SocialNetwork(String facebookAccountName, String facebookUrl, String instagramAccountName,
                         String instagramUrl, String snapchatAccountName, String snapchatUrl, String twitterAccountName, String twitterUrl) {
        this.facebookAccountName = facebookAccountName;
        this.facebookUrl = facebookUrl;
        this.instagramAccountName = instagramAccountName;
        this.instagramUrl = instagramUrl;
        this.snapchatAccountName = snapchatAccountName;
        this.snapchatUrl = snapchatUrl;
        this.twitterAccountName = twitterAccountName;
        this.twitterUrl = twitterUrl;
    }

    public String getFacebookAccountName() {
        return facebookAccountName;
    }

    public void setFacebookAccountName(String facebookAccountName) {
        this.facebookAccountName = facebookAccountName;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramAccountName() {
        return instagramAccountName;
    }

    public void setInstagramAccountName(String instagramAccountName) {
        this.instagramAccountName = instagramAccountName;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getSnapchatAccountName() {
        return snapchatAccountName;
    }

    public void setSnapchatAccountName(String snapchatAccountName) {
        this.snapchatAccountName = snapchatAccountName;
    }

    public String getSnapchatUrl() {
        return snapchatUrl;
    }

    public void setSnapchatUrl(String snapchatUrl) {
        this.snapchatUrl = snapchatUrl;
    }

    public String getTwitterAccountName() {
        return twitterAccountName;
    }

    public void setTwitterAccountName(String twitterAccountName) {
        this.twitterAccountName = twitterAccountName;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }
}
