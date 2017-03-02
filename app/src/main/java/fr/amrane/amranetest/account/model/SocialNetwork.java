package fr.amrane.amranetest.account.model;

/**
 * Created by aaitzeouay on 01/03/2017.
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

    public SocialNetwork(String facebookUrl, String facebookAccountName, String twitterUrl, String twitterAccountName,
                         String instagramUrl, String instagramAccountName, String snapchatUrl, String snapchatAccountName) {
        super();
        this.facebookUrl = facebookUrl;
        this.facebookAccountName = facebookAccountName;
        this.twitterUrl = twitterUrl;
        this.twitterAccountName = twitterAccountName;
        this.instagramUrl = instagramUrl;
        this.instagramAccountName = instagramAccountName;
        this.snapchatUrl = snapchatUrl;
        this.snapchatAccountName = snapchatAccountName;
    }

    public SocialNetwork() {
    }

    @Override
    public String toString() {
        return "SocialNetwork [facebookUrl=" + facebookUrl + ", facebookAccountName=" + facebookAccountName
                + ", twitterUrl=" + twitterUrl + ", twitterAccountName=" + twitterAccountName + ", instagramUrl="
                + instagramUrl + ", instagramAccountName=" + instagramAccountName + ", snapchatUrl=" + snapchatUrl
                + ", snapchatAccountName=" + snapchatAccountName + "]";
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }
    public String getFacebookAccountName() {
        return facebookAccountName;
    }
    public void setFacebookAccountName(String facebookAccountName) {
        this.facebookAccountName = facebookAccountName;
    }
    public String getTwitterUrl() {
        return twitterUrl;
    }
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }
    public String getTwitterAccountName() {
        return twitterAccountName;
    }
    public void setTwitterAccountName(String twitterAccountName) {
        this.twitterAccountName = twitterAccountName;
    }
    public String getInstagramUrl() {
        return instagramUrl;
    }
    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }
    public String getInstagramAccountName() {
        return instagramAccountName;
    }
    public void setInstagramAccountName(String instagramAccountName) {
        this.instagramAccountName = instagramAccountName;
    }
    public String getSnapchatUrl() {
        return snapchatUrl;
    }
    public void setSnapchatUrl(String snapchatUrl) {
        this.snapchatUrl = snapchatUrl;
    }
    public String getSnapchatAccountName() {
        return snapchatAccountName;
    }
    public void setSnapchatAccountName(String snapchatAccountName) {
        this.snapchatAccountName = snapchatAccountName;
    }
}
