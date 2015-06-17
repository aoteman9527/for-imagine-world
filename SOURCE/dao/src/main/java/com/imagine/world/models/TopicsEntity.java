package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@Table(name = "TOPICS", schema = "", catalog = "blogs")
public class TopicsEntity {
    private int topicId;

    @Id
    @Column(name = "topic_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    private int forumId;

    @Basic
    @Column(name = "forum_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    private int iconId;

    @Basic
    @Column(name = "icon_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    private byte topicAttachment;

    @Basic
    @Column(name = "topic_attachment", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicAttachment() {
        return topicAttachment;
    }

    public void setTopicAttachment(byte topicAttachment) {
        this.topicAttachment = topicAttachment;
    }

    private byte topicApproved;

    @Basic
    @Column(name = "topic_approved", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicApproved() {
        return topicApproved;
    }

    public void setTopicApproved(byte topicApproved) {
        this.topicApproved = topicApproved;
    }

    private byte topicReported;

    @Basic
    @Column(name = "topic_reported", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicReported() {
        return topicReported;
    }

    public void setTopicReported(byte topicReported) {
        this.topicReported = topicReported;
    }

    private String topicTitle;

    @Basic
    @Column(name = "topic_title", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    private int topicPoster;

    @Basic
    @Column(name = "topic_poster", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicPoster() {
        return topicPoster;
    }

    public void setTopicPoster(int topicPoster) {
        this.topicPoster = topicPoster;
    }

    private int topicTime;

    @Basic
    @Column(name = "topic_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(int topicTime) {
        this.topicTime = topicTime;
    }

    private int topicTimeLimit;

    @Basic
    @Column(name = "topic_time_limit", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getTopicTimeLimit() {
        return topicTimeLimit;
    }

    public void setTopicTimeLimit(int topicTimeLimit) {
        this.topicTimeLimit = topicTimeLimit;
    }

    private int topicViews;

    @Basic
    @Column(name = "topic_views", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    private int topicReplies;

    @Basic
    @Column(name = "topic_replies", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(int topicReplies) {
        this.topicReplies = topicReplies;
    }

    private int topicRepliesReal;

    @Basic
    @Column(name = "topic_replies_real", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicRepliesReal() {
        return topicRepliesReal;
    }

    public void setTopicRepliesReal(int topicRepliesReal) {
        this.topicRepliesReal = topicRepliesReal;
    }

    private byte topicStatus;

    @Basic
    @Column(name = "topic_status", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(byte topicStatus) {
        this.topicStatus = topicStatus;
    }

    private byte topicType;

    @Basic
    @Column(name = "topic_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicType() {
        return topicType;
    }

    public void setTopicType(byte topicType) {
        this.topicType = topicType;
    }

    private int topicFirstPostId;

    @Basic
    @Column(name = "topic_first_post_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicFirstPostId() {
        return topicFirstPostId;
    }

    public void setTopicFirstPostId(int topicFirstPostId) {
        this.topicFirstPostId = topicFirstPostId;
    }

    private String topicFirstPosterName;

    @Basic
    @Column(name = "topic_first_poster_name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getTopicFirstPosterName() {
        return topicFirstPosterName;
    }

    public void setTopicFirstPosterName(String topicFirstPosterName) {
        this.topicFirstPosterName = topicFirstPosterName;
    }

    private String topicFirstPosterColour;

    @Basic
    @Column(name = "topic_first_poster_colour", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public String getTopicFirstPosterColour() {
        return topicFirstPosterColour;
    }

    public void setTopicFirstPosterColour(String topicFirstPosterColour) {
        this.topicFirstPosterColour = topicFirstPosterColour;
    }

    private int topicLastPostId;

    @Basic
    @Column(name = "topic_last_post_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicLastPostId() {
        return topicLastPostId;
    }

    public void setTopicLastPostId(int topicLastPostId) {
        this.topicLastPostId = topicLastPostId;
    }

    private int topicLastPosterId;

    @Basic
    @Column(name = "topic_last_poster_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicLastPosterId() {
        return topicLastPosterId;
    }

    public void setTopicLastPosterId(int topicLastPosterId) {
        this.topicLastPosterId = topicLastPosterId;
    }

    private String topicLastPosterName;

    @Basic
    @Column(name = "topic_last_poster_name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getTopicLastPosterName() {
        return topicLastPosterName;
    }

    public void setTopicLastPosterName(String topicLastPosterName) {
        this.topicLastPosterName = topicLastPosterName;
    }

    private String topicLastPosterColour;

    @Basic
    @Column(name = "topic_last_poster_colour", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public String getTopicLastPosterColour() {
        return topicLastPosterColour;
    }

    public void setTopicLastPosterColour(String topicLastPosterColour) {
        this.topicLastPosterColour = topicLastPosterColour;
    }

    private String topicLastPostSubject;

    @Basic
    @Column(name = "topic_last_post_subject", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getTopicLastPostSubject() {
        return topicLastPostSubject;
    }

    public void setTopicLastPostSubject(String topicLastPostSubject) {
        this.topicLastPostSubject = topicLastPostSubject;
    }

    private int topicLastPostTime;

    @Basic
    @Column(name = "topic_last_post_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getTopicLastPostTime() {
        return topicLastPostTime;
    }

    public void setTopicLastPostTime(int topicLastPostTime) {
        this.topicLastPostTime = topicLastPostTime;
    }

    private int topicLastViewTime;

    @Basic
    @Column(name = "topic_last_view_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getTopicLastViewTime() {
        return topicLastViewTime;
    }

    public void setTopicLastViewTime(int topicLastViewTime) {
        this.topicLastViewTime = topicLastViewTime;
    }

    private int topicMovedId;

    @Basic
    @Column(name = "topic_moved_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicMovedId() {
        return topicMovedId;
    }

    public void setTopicMovedId(int topicMovedId) {
        this.topicMovedId = topicMovedId;
    }

    private byte topicBumped;

    @Basic
    @Column(name = "topic_bumped", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getTopicBumped() {
        return topicBumped;
    }

    public void setTopicBumped(byte topicBumped) {
        this.topicBumped = topicBumped;
    }

    private int topicBumper;

    @Basic
    @Column(name = "topic_bumper", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getTopicBumper() {
        return topicBumper;
    }

    public void setTopicBumper(int topicBumper) {
        this.topicBumper = topicBumper;
    }

    private String pollTitle;

    @Basic
    @Column(name = "poll_title", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getPollTitle() {
        return pollTitle;
    }

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    private int pollStart;

    @Basic
    @Column(name = "poll_start", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPollStart() {
        return pollStart;
    }

    public void setPollStart(int pollStart) {
        this.pollStart = pollStart;
    }

    private int pollLength;

    @Basic
    @Column(name = "poll_length", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPollLength() {
        return pollLength;
    }

    public void setPollLength(int pollLength) {
        this.pollLength = pollLength;
    }

    private byte pollMaxOptions;

    @Basic
    @Column(name = "poll_max_options", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getPollMaxOptions() {
        return pollMaxOptions;
    }

    public void setPollMaxOptions(byte pollMaxOptions) {
        this.pollMaxOptions = pollMaxOptions;
    }

    private int pollLastVote;

    @Basic
    @Column(name = "poll_last_vote", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPollLastVote() {
        return pollLastVote;
    }

    public void setPollLastVote(int pollLastVote) {
        this.pollLastVote = pollLastVote;
    }

    private byte pollVoteChange;

    @Basic
    @Column(name = "poll_vote_change", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getPollVoteChange() {
        return pollVoteChange;
    }

    public void setPollVoteChange(byte pollVoteChange) {
        this.pollVoteChange = pollVoteChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicsEntity that = (TopicsEntity) o;

        if (forumId != that.forumId) return false;
        if (iconId != that.iconId) return false;
        if (pollLastVote != that.pollLastVote) return false;
        if (pollLength != that.pollLength) return false;
        if (pollMaxOptions != that.pollMaxOptions) return false;
        if (pollStart != that.pollStart) return false;
        if (pollVoteChange != that.pollVoteChange) return false;
        if (topicApproved != that.topicApproved) return false;
        if (topicAttachment != that.topicAttachment) return false;
        if (topicBumped != that.topicBumped) return false;
        if (topicBumper != that.topicBumper) return false;
        if (topicFirstPostId != that.topicFirstPostId) return false;
        if (topicId != that.topicId) return false;
        if (topicLastPostId != that.topicLastPostId) return false;
        if (topicLastPostTime != that.topicLastPostTime) return false;
        if (topicLastPosterId != that.topicLastPosterId) return false;
        if (topicLastViewTime != that.topicLastViewTime) return false;
        if (topicMovedId != that.topicMovedId) return false;
        if (topicPoster != that.topicPoster) return false;
        if (topicReplies != that.topicReplies) return false;
        if (topicRepliesReal != that.topicRepliesReal) return false;
        if (topicReported != that.topicReported) return false;
        if (topicStatus != that.topicStatus) return false;
        if (topicTime != that.topicTime) return false;
        if (topicTimeLimit != that.topicTimeLimit) return false;
        if (topicType != that.topicType) return false;
        if (topicViews != that.topicViews) return false;
        if (pollTitle != null ? !pollTitle.equals(that.pollTitle) : that.pollTitle != null) return false;
        if (topicFirstPosterColour != null ? !topicFirstPosterColour.equals(that.topicFirstPosterColour) : that.topicFirstPosterColour != null)
            return false;
        if (topicFirstPosterName != null ? !topicFirstPosterName.equals(that.topicFirstPosterName) : that.topicFirstPosterName != null)
            return false;
        if (topicLastPostSubject != null ? !topicLastPostSubject.equals(that.topicLastPostSubject) : that.topicLastPostSubject != null)
            return false;
        if (topicLastPosterColour != null ? !topicLastPosterColour.equals(that.topicLastPosterColour) : that.topicLastPosterColour != null)
            return false;
        if (topicLastPosterName != null ? !topicLastPosterName.equals(that.topicLastPosterName) : that.topicLastPosterName != null)
            return false;
        if (topicTitle != null ? !topicTitle.equals(that.topicTitle) : that.topicTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId;
        result = 31 * result + forumId;
        result = 31 * result + iconId;
        result = 31 * result + (int) topicAttachment;
        result = 31 * result + (int) topicApproved;
        result = 31 * result + (int) topicReported;
        result = 31 * result + (topicTitle != null ? topicTitle.hashCode() : 0);
        result = 31 * result + topicPoster;
        result = 31 * result + topicTime;
        result = 31 * result + topicTimeLimit;
        result = 31 * result + topicViews;
        result = 31 * result + topicReplies;
        result = 31 * result + topicRepliesReal;
        result = 31 * result + (int) topicStatus;
        result = 31 * result + (int) topicType;
        result = 31 * result + topicFirstPostId;
        result = 31 * result + (topicFirstPosterName != null ? topicFirstPosterName.hashCode() : 0);
        result = 31 * result + (topicFirstPosterColour != null ? topicFirstPosterColour.hashCode() : 0);
        result = 31 * result + topicLastPostId;
        result = 31 * result + topicLastPosterId;
        result = 31 * result + (topicLastPosterName != null ? topicLastPosterName.hashCode() : 0);
        result = 31 * result + (topicLastPosterColour != null ? topicLastPosterColour.hashCode() : 0);
        result = 31 * result + (topicLastPostSubject != null ? topicLastPostSubject.hashCode() : 0);
        result = 31 * result + topicLastPostTime;
        result = 31 * result + topicLastViewTime;
        result = 31 * result + topicMovedId;
        result = 31 * result + (int) topicBumped;
        result = 31 * result + topicBumper;
        result = 31 * result + (pollTitle != null ? pollTitle.hashCode() : 0);
        result = 31 * result + pollStart;
        result = 31 * result + pollLength;
        result = 31 * result + (int) pollMaxOptions;
        result = 31 * result + pollLastVote;
        result = 31 * result + (int) pollVoteChange;
        return result;
    }
}
