package ci.entity;

import java.util.Date;

public class CollectionComments {
    private String postId;
    private String postBy;
    private String postText;
    private String postPublished;
    private String commentId;
    private String commentBy;
    private int isReply;
    private String commentMessage;
    private String commentPublished;
    private int commentLikeCount;
    private int id;
    private Date sysdate;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostPublished() {
        return postPublished;
    }

    public void setPostPublished(String postPublished) {
        this.postPublished = postPublished;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(String commentBy) {
        this.commentBy = commentBy;
    }

    public int getIsReply() {
        return isReply;
    }

    public void setIsReply(int isReply) {
        this.isReply = isReply;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getCommentPublished() {
        return commentPublished;
    }

    public void setCommentPublished(String commentPublished) {
        this.commentPublished = commentPublished;
    }

    public int getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(int commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
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
        return "CollectionComments [postId=" + postId + ", postBy=" + postBy + ", postText=" + postText
                + ", postPublished=" + postPublished + ", commentId=" + commentId + ", commentBy=" + commentBy
                + ", isReply=" + isReply + ", commentMessage=" + commentMessage + ", commentPublished="
                + commentPublished + ", commentLikeCount=" + commentLikeCount + ", id=" + id + ", sysdate=" + sysdate
                + "]";
    }

}
