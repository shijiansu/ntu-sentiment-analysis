package ci.entity;

import java.util.Date;

public class CollectionPost {
    private String type;
    private String by;
    private String postMessage;
    private String picture;
    private String link;
    private String linkDomain;
    private String postPublished;
    private int postPublishedUnix;
    private int likes;
    private int likesCountFb;
    private int commentsAll;
    private int commentBase;
    private int commentsReplies;
    private int share;
    private int comentLikes;
    private int engagement;
    private String postId;
    private String postLink;
    private String facebookPage;
    private int id;
    private Date sysdate;

    private int processStatus;

    public int getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkDomain() {
        return linkDomain;
    }

    public void setLinkDomain(String linkDomain) {
        this.linkDomain = linkDomain;
    }

    public String getPostPublished() {
        return postPublished;
    }

    public void setPostPublished(String postPublished) {
        this.postPublished = postPublished;
    }

    public int getPostPublishedUnix() {
        return postPublishedUnix;
    }

    public void setPostPublishedUnix(int postPublishedUnix) {
        this.postPublishedUnix = postPublishedUnix;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikesCountFb() {
        return likesCountFb;
    }

    public void setLikesCountFb(int likesCountFb) {
        this.likesCountFb = likesCountFb;
    }

    public int getCommentsAll() {
        return commentsAll;
    }

    public void setCommentsAll(int commentsAll) {
        this.commentsAll = commentsAll;
    }

    public int getCommentBase() {
        return commentBase;
    }

    public void setCommentBase(int commentBase) {
        this.commentBase = commentBase;
    }

    public int getCommentsReplies() {
        return commentsReplies;
    }

    public void setCommentsReplies(int commentsReplies) {
        this.commentsReplies = commentsReplies;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getComentLikes() {
        return comentLikes;
    }

    public void setComentLikes(int comentLikes) {
        this.comentLikes = comentLikes;
    }

    public int getEngagement() {
        return engagement;
    }

    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getFacebookPage() {
        return facebookPage;
    }

    public void setFacebookPage(String facebookPage) {
        this.facebookPage = facebookPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSysdate() {
        return sysdate;
    }

    public void setSysdate(Date sysdate) {
        this.sysdate = sysdate;
    }

    @Override
    public String toString() {
        return "CollectionPost [type=" + type + ", by=" + by + ", postMessage=" + postMessage + ", picture=" + picture
                + ", link=" + link + ", linkDomain=" + linkDomain + ", postPublished=" + postPublished
                + ", postPublishedUnix=" + postPublishedUnix + ", likes=" + likes + ", likesCountFb=" + likesCountFb
                + ", commentsAll=" + commentsAll + ", commentBase=" + commentBase + ", commentsReplies="
                + commentsReplies + ", share=" + share + ", comentLikes=" + comentLikes + ", engagement=" + engagement
                + ", postId=" + postId + ", postLink=" + postLink + ", facebookPage=" + facebookPage + ", id=" + id
                + ", sysdate=" + sysdate + ", processStatus=" + processStatus + "]";
    }

}
