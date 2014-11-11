package com.imagine.world.models;

/**
 * Created by tuanlhd on 11/11/14.
 */
public class Post {
    public Post(){}

    public Post(PostsEntity p){
        this.setPostId(p.getPostId());
        this.setTopicId(p.getTopicId());
        this.setForumId(p.getForumId());
        this.setPosterId(p.getPosterId());
        this.setPosterIp(p.getPosterIp());
        this.setPostTime(p.getPostTime());
        this.setPostApproved(p.getPostApproved());
        this.setPostUsername(p.getPostUsername());
        this.setPostSubject(p.getPostSubject());
        this.setPostText(p.getPostText());
        this.setPostChecksum(p.getPostChecksum());
        this.setPostEditCount(p.getPostEditCount());
        this.setPostEditTime(p.getPostEditTime());
    }

    private int postId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    private int topicId;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    private int forumId;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    private int posterId;

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    private int iconId;

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    private String posterIp;

    public String getPosterIp() {
        return posterIp;
    }

    public void setPosterIp(String posterIp) {
        this.posterIp = posterIp;
    }

    private int postTime;

    public int getPostTime() {
        return postTime;
    }

    public void setPostTime(int postTime) {
        this.postTime = postTime;
    }

    private byte postApproved;

    public byte getPostApproved() {
        return postApproved;
    }

    public void setPostApproved(byte postApproved) {
        this.postApproved = postApproved;
    }

    private byte postReported;

    public byte getPostReported() {
        return postReported;
    }

    public void setPostReported(byte postReported) {
        this.postReported = postReported;
    }

    private byte enableBbcode;

    public byte getEnableBbcode() {
        return enableBbcode;
    }

    public void setEnableBbcode(byte enableBbcode) {
        this.enableBbcode = enableBbcode;
    }

    private byte enableSmilies;

    public byte getEnableSmilies() {
        return enableSmilies;
    }

    public void setEnableSmilies(byte enableSmilies) {
        this.enableSmilies = enableSmilies;
    }

    private byte enableMagicUrl;

    public byte getEnableMagicUrl() {
        return enableMagicUrl;
    }

    public void setEnableMagicUrl(byte enableMagicUrl) {
        this.enableMagicUrl = enableMagicUrl;
    }

    private byte enableSig;

    public byte getEnableSig() {
        return enableSig;
    }

    public void setEnableSig(byte enableSig) {
        this.enableSig = enableSig;
    }

    private String postUsername;

    public String getPostUsername() {
        return postUsername;
    }

    public void setPostUsername(String postUsername) {
        this.postUsername = postUsername;
    }

    private String postSubject;

    public String getPostSubject() {
        return postSubject;
    }

    public void setPostSubject(String postSubject) {
        this.postSubject = postSubject;
    }

    private String postText;

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    private String postChecksum;

    public String getPostChecksum() {
        return postChecksum;
    }

    public void setPostChecksum(String postChecksum) {
        this.postChecksum = postChecksum;
    }

    private byte postAttachment;

    public byte getPostAttachment() {
        return postAttachment;
    }

    public void setPostAttachment(byte postAttachment) {
        this.postAttachment = postAttachment;
    }

    private String bbcodeBitfield;

    public String getBbcodeBitfield() {
        return bbcodeBitfield;
    }

    public void setBbcodeBitfield(String bbcodeBitfield) {
        this.bbcodeBitfield = bbcodeBitfield;
    }

    private String bbcodeUid;

    public String getBbcodeUid() {
        return bbcodeUid;
    }

    public void setBbcodeUid(String bbcodeUid) {
        this.bbcodeUid = bbcodeUid;
    }

    private byte postPostcount;

    public byte getPostPostcount() {
        return postPostcount;
    }

    public void setPostPostcount(byte postPostcount) {
        this.postPostcount = postPostcount;
    }

    private int postEditTime;

    public int getPostEditTime() {
        return postEditTime;
    }

    public void setPostEditTime(int postEditTime) {
        this.postEditTime = postEditTime;
    }

    private String postEditReason;

    public String getPostEditReason() {
        return postEditReason;
    }

    public void setPostEditReason(String postEditReason) {
        this.postEditReason = postEditReason;
    }

    private int postEditUser;

    public int getPostEditUser() {
        return postEditUser;
    }

    public void setPostEditUser(int postEditUser) {
        this.postEditUser = postEditUser;
    }

    private short postEditCount;

    public short getPostEditCount() {
        return postEditCount;
    }

    public void setPostEditCount(short postEditCount) {
        this.postEditCount = postEditCount;
    }    private byte postEditLocked;

    public byte getPostEditLocked() {
        return postEditLocked;
    }

    public void setPostEditLocked(byte postEditLocked) {
        this.postEditLocked = postEditLocked;
    }

}
