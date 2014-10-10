package com.imagine.world.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@javax.persistence.Table(name = "POSTS", schema = "", catalog = "blogs")
public class PostsEntity {
    private int postId;

    @Id
    @javax.persistence.Column(name = "post_id")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    private int topicId;

    @Basic
    @javax.persistence.Column(name = "topic_id")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    private int forumId;

    @Basic
    @javax.persistence.Column(name = "forum_id")
    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    private int posterId;

    @Basic
    @javax.persistence.Column(name = "poster_id")
    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    private int iconId;

    @Basic
    @javax.persistence.Column(name = "icon_id")
    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    private String posterIp;

    @Basic
    @javax.persistence.Column(name = "poster_ip")
    public String getPosterIp() {
        return posterIp;
    }

    public void setPosterIp(String posterIp) {
        this.posterIp = posterIp;
    }

    private int postTime;

    @Basic
    @javax.persistence.Column(name = "post_time")
    public int getPostTime() {
        return postTime;
    }

    public void setPostTime(int postTime) {
        this.postTime = postTime;
    }

    private byte postApproved;

    @Basic
    @javax.persistence.Column(name = "post_approved")
    public byte getPostApproved() {
        return postApproved;
    }

    public void setPostApproved(byte postApproved) {
        this.postApproved = postApproved;
    }

    private byte postReported;

    @Basic
    @javax.persistence.Column(name = "post_reported")
    public byte getPostReported() {
        return postReported;
    }

    public void setPostReported(byte postReported) {
        this.postReported = postReported;
    }

    private byte enableBbcode;

    @Basic
    @javax.persistence.Column(name = "enable_bbcode")
    public byte getEnableBbcode() {
        return enableBbcode;
    }

    public void setEnableBbcode(byte enableBbcode) {
        this.enableBbcode = enableBbcode;
    }

    private byte enableSmilies;

    @Basic
    @javax.persistence.Column(name = "enable_smilies")
    public byte getEnableSmilies() {
        return enableSmilies;
    }

    public void setEnableSmilies(byte enableSmilies) {
        this.enableSmilies = enableSmilies;
    }

    private byte enableMagicUrl;

    @Basic
    @javax.persistence.Column(name = "enable_magic_url")
    public byte getEnableMagicUrl() {
        return enableMagicUrl;
    }

    public void setEnableMagicUrl(byte enableMagicUrl) {
        this.enableMagicUrl = enableMagicUrl;
    }

    private byte enableSig;

    @Basic
    @javax.persistence.Column(name = "enable_sig")
    public byte getEnableSig() {
        return enableSig;
    }

    public void setEnableSig(byte enableSig) {
        this.enableSig = enableSig;
    }

    private String postUsername;

    @Basic
    @javax.persistence.Column(name = "post_username")
    public String getPostUsername() {
        return postUsername;
    }

    public void setPostUsername(String postUsername) {
        this.postUsername = postUsername;
    }

    private String postSubject;

    @Basic
    @javax.persistence.Column(name = "post_subject")
    public String getPostSubject() {
        return postSubject;
    }

    public void setPostSubject(String postSubject) {
        this.postSubject = postSubject;
    }

    private String postText;

    @Basic
    @javax.persistence.Column(name = "post_text")
    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    private String postChecksum;

    @Basic
    @javax.persistence.Column(name = "post_checksum")
    public String getPostChecksum() {
        return postChecksum;
    }

    public void setPostChecksum(String postChecksum) {
        this.postChecksum = postChecksum;
    }

    private byte postAttachment;

    @Basic
    @javax.persistence.Column(name = "post_attachment")
    public byte getPostAttachment() {
        return postAttachment;
    }

    public void setPostAttachment(byte postAttachment) {
        this.postAttachment = postAttachment;
    }

    private String bbcodeBitfield;

    @Basic
    @javax.persistence.Column(name = "bbcode_bitfield")
    public String getBbcodeBitfield() {
        return bbcodeBitfield;
    }

    public void setBbcodeBitfield(String bbcodeBitfield) {
        this.bbcodeBitfield = bbcodeBitfield;
    }

    private String bbcodeUid;

    @Basic
    @javax.persistence.Column(name = "bbcode_uid")
    public String getBbcodeUid() {
        return bbcodeUid;
    }

    public void setBbcodeUid(String bbcodeUid) {
        this.bbcodeUid = bbcodeUid;
    }

    private byte postPostcount;

    @Basic
    @javax.persistence.Column(name = "post_postcount")
    public byte getPostPostcount() {
        return postPostcount;
    }

    public void setPostPostcount(byte postPostcount) {
        this.postPostcount = postPostcount;
    }

    private int postEditTime;

    @Basic
    @javax.persistence.Column(name = "post_edit_time")
    public int getPostEditTime() {
        return postEditTime;
    }

    public void setPostEditTime(int postEditTime) {
        this.postEditTime = postEditTime;
    }

    private String postEditReason;

    @Basic
    @javax.persistence.Column(name = "post_edit_reason")
    public String getPostEditReason() {
        return postEditReason;
    }

    public void setPostEditReason(String postEditReason) {
        this.postEditReason = postEditReason;
    }

    private int postEditUser;

    @Basic
    @javax.persistence.Column(name = "post_edit_user")
    public int getPostEditUser() {
        return postEditUser;
    }

    public void setPostEditUser(int postEditUser) {
        this.postEditUser = postEditUser;
    }

    private short postEditCount;

    @Basic
    @javax.persistence.Column(name = "post_edit_count")
    public short getPostEditCount() {
        return postEditCount;
    }

    public void setPostEditCount(short postEditCount) {
        this.postEditCount = postEditCount;
    }

    private byte postEditLocked;

    @Basic
    @javax.persistence.Column(name = "post_edit_locked")
    public byte getPostEditLocked() {
        return postEditLocked;
    }

    public void setPostEditLocked(byte postEditLocked) {
        this.postEditLocked = postEditLocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsEntity that = (PostsEntity) o;

        if (enableBbcode != that.enableBbcode) return false;
        if (enableMagicUrl != that.enableMagicUrl) return false;
        if (enableSig != that.enableSig) return false;
        if (enableSmilies != that.enableSmilies) return false;
        if (forumId != that.forumId) return false;
        if (iconId != that.iconId) return false;
        if (postApproved != that.postApproved) return false;
        if (postAttachment != that.postAttachment) return false;
        if (postEditCount != that.postEditCount) return false;
        if (postEditLocked != that.postEditLocked) return false;
        if (postEditTime != that.postEditTime) return false;
        if (postEditUser != that.postEditUser) return false;
        if (postId != that.postId) return false;
        if (postPostcount != that.postPostcount) return false;
        if (postReported != that.postReported) return false;
        if (postTime != that.postTime) return false;
        if (posterId != that.posterId) return false;
        if (topicId != that.topicId) return false;
        if (bbcodeBitfield != null ? !bbcodeBitfield.equals(that.bbcodeBitfield) : that.bbcodeBitfield != null)
            return false;
        if (bbcodeUid != null ? !bbcodeUid.equals(that.bbcodeUid) : that.bbcodeUid != null) return false;
        if (postChecksum != null ? !postChecksum.equals(that.postChecksum) : that.postChecksum != null) return false;
        if (postEditReason != null ? !postEditReason.equals(that.postEditReason) : that.postEditReason != null)
            return false;
        if (postSubject != null ? !postSubject.equals(that.postSubject) : that.postSubject != null) return false;
        if (postText != null ? !postText.equals(that.postText) : that.postText != null) return false;
        if (postUsername != null ? !postUsername.equals(that.postUsername) : that.postUsername != null) return false;
        if (posterIp != null ? !posterIp.equals(that.posterIp) : that.posterIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + topicId;
        result = 31 * result + forumId;
        result = 31 * result + posterId;
        result = 31 * result + iconId;
        result = 31 * result + (posterIp != null ? posterIp.hashCode() : 0);
        result = 31 * result + postTime;
        result = 31 * result + (int) postApproved;
        result = 31 * result + (int) postReported;
        result = 31 * result + (int) enableBbcode;
        result = 31 * result + (int) enableSmilies;
        result = 31 * result + (int) enableMagicUrl;
        result = 31 * result + (int) enableSig;
        result = 31 * result + (postUsername != null ? postUsername.hashCode() : 0);
        result = 31 * result + (postSubject != null ? postSubject.hashCode() : 0);
        result = 31 * result + (postText != null ? postText.hashCode() : 0);
        result = 31 * result + (postChecksum != null ? postChecksum.hashCode() : 0);
        result = 31 * result + (int) postAttachment;
        result = 31 * result + (bbcodeBitfield != null ? bbcodeBitfield.hashCode() : 0);
        result = 31 * result + (bbcodeUid != null ? bbcodeUid.hashCode() : 0);
        result = 31 * result + (int) postPostcount;
        result = 31 * result + postEditTime;
        result = 31 * result + (postEditReason != null ? postEditReason.hashCode() : 0);
        result = 31 * result + postEditUser;
        result = 31 * result + (int) postEditCount;
        result = 31 * result + (int) postEditLocked;
        return result;
    }
}
