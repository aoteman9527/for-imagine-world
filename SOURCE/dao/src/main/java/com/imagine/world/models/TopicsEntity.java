package com.imagine.world.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@javax.persistence.Table(name = "TOPICS", schema = "", catalog = "blogs")
public class TopicsEntity {
    private int topicId;

    @Id
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

    private int iconId;

    @Basic
    @javax.persistence.Column(name = "icon_id")
    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    private byte topicAttachment;

    @Basic
    @javax.persistence.Column(name = "topic_attachment")
    public byte getTopicAttachment() {
        return topicAttachment;
    }

    public void setTopicAttachment(byte topicAttachment) {
        this.topicAttachment = topicAttachment;
    }

    private byte topicApproved;

    @Basic
    @javax.persistence.Column(name = "topic_approved")
    public byte getTopicApproved() {
        return topicApproved;
    }

    public void setTopicApproved(byte topicApproved) {
        this.topicApproved = topicApproved;
    }

    private byte topicReported;

    @Basic
    @javax.persistence.Column(name = "topic_reported")
    public byte getTopicReported() {
        return topicReported;
    }

    public void setTopicReported(byte topicReported) {
        this.topicReported = topicReported;
    }

    private String topicTitle;

    @Basic
    @javax.persistence.Column(name = "topic_title")
    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    private int topicPoster;

    @Basic
    @javax.persistence.Column(name = "topic_poster")
    public int getTopicPoster() {
        return topicPoster;
    }

    public void setTopicPoster(int topicPoster) {
        this.topicPoster = topicPoster;
    }

    private int topicTime;

    @Basic
    @javax.persistence.Column(name = "topic_time")
    public int getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(int topicTime) {
        this.topicTime = topicTime;
    }

    private int topicTimeLimit;

    @Basic
    @javax.persistence.Column(name = "topic_time_limit")
    public int getTopicTimeLimit() {
        return topicTimeLimit;
    }

    public void setTopicTimeLimit(int topicTimeLimit) {
        this.topicTimeLimit = topicTimeLimit;
    }

    private int topicViews;

    @Basic
    @javax.persistence.Column(name = "topic_views")
    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    private int topicReplies;

    @Basic
    @javax.persistence.Column(name = "topic_replies")
    public int getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(int topicReplies) {
        this.topicReplies = topicReplies;
    }

    private int topicRepliesReal;

    @Basic
    @javax.persistence.Column(name = "topic_replies_real")
    public int getTopicRepliesReal() {
        return topicRepliesReal;
    }

    public void setTopicRepliesReal(int topicRepliesReal) {
        this.topicRepliesReal = topicRepliesReal;
    }

    private byte topicStatus;

    @Basic
    @javax.persistence.Column(name = "topic_status")
    public byte getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(byte topicStatus) {
        this.topicStatus = topicStatus;
    }

    private byte topicType;

    @Basic
    @javax.persistence.Column(name = "topic_type")
    public byte getTopicType() {
        return topicType;
    }

    public void setTopicType(byte topicType) {
        this.topicType = topicType;
    }

    private int topicFirstPostId;

    @Basic
    @javax.persistence.Column(name = "topic_first_post_id")
    public int getTopicFirstPostId() {
        return topicFirstPostId;
    }

    public void setTopicFirstPostId(int topicFirstPostId) {
        this.topicFirstPostId = topicFirstPostId;
    }

    private String topicFirstPosterName;

    @Basic
    @javax.persistence.Column(name = "topic_first_poster_name")
    public String getTopicFirstPosterName() {
        return topicFirstPosterName;
    }

    public void setTopicFirstPosterName(String topicFirstPosterName) {
        this.topicFirstPosterName = topicFirstPosterName;
    }

    private String topicFirstPosterColour;

    @Basic
    @javax.persistence.Column(name = "topic_first_poster_colour")
    public String getTopicFirstPosterColour() {
        return topicFirstPosterColour;
    }

    public void setTopicFirstPosterColour(String topicFirstPosterColour) {
        this.topicFirstPosterColour = topicFirstPosterColour;
    }

    private int topicLastPostId;

    @Basic
    @javax.persistence.Column(name = "topic_last_post_id")
    public int getTopicLastPostId() {
        return topicLastPostId;
    }

    public void setTopicLastPostId(int topicLastPostId) {
        this.topicLastPostId = topicLastPostId;
    }

    private int topicLastPosterId;

    @Basic
    @javax.persistence.Column(name = "topic_last_poster_id")
    public int getTopicLastPosterId() {
        return topicLastPosterId;
    }

    public void setTopicLastPosterId(int topicLastPosterId) {
        this.topicLastPosterId = topicLastPosterId;
    }

    private String topicLastPosterName;

    @Basic
    @javax.persistence.Column(name = "topic_last_poster_name")
    public String getTopicLastPosterName() {
        return topicLastPosterName;
    }

    public void setTopicLastPosterName(String topicLastPosterName) {
        this.topicLastPosterName = topicLastPosterName;
    }

    private String topicLastPosterColour;

    @Basic
    @javax.persistence.Column(name = "topic_last_poster_colour")
    public String getTopicLastPosterColour() {
        return topicLastPosterColour;
    }

    public void setTopicLastPosterColour(String topicLastPosterColour) {
        this.topicLastPosterColour = topicLastPosterColour;
    }

    private String topicLastPostSubject;

    @Basic
    @javax.persistence.Column(name = "topic_last_post_subject")
    public String getTopicLastPostSubject() {
        return topicLastPostSubject;
    }

    public void setTopicLastPostSubject(String topicLastPostSubject) {
        this.topicLastPostSubject = topicLastPostSubject;
    }

    private int topicLastPostTime;

    @Basic
    @javax.persistence.Column(name = "topic_last_post_time")
    public int getTopicLastPostTime() {
        return topicLastPostTime;
    }

    public void setTopicLastPostTime(int topicLastPostTime) {
        this.topicLastPostTime = topicLastPostTime;
    }

    private int topicLastViewTime;

    @Basic
    @javax.persistence.Column(name = "topic_last_view_time")
    public int getTopicLastViewTime() {
        return topicLastViewTime;
    }

    public void setTopicLastViewTime(int topicLastViewTime) {
        this.topicLastViewTime = topicLastViewTime;
    }

    private int topicMovedId;

    @Basic
    @javax.persistence.Column(name = "topic_moved_id")
    public int getTopicMovedId() {
        return topicMovedId;
    }

    public void setTopicMovedId(int topicMovedId) {
        this.topicMovedId = topicMovedId;
    }

    private byte topicBumped;

    @Basic
    @javax.persistence.Column(name = "topic_bumped")
    public byte getTopicBumped() {
        return topicBumped;
    }

    public void setTopicBumped(byte topicBumped) {
        this.topicBumped = topicBumped;
    }

    private int topicBumper;

    @Basic
    @javax.persistence.Column(name = "topic_bumper")
    public int getTopicBumper() {
        return topicBumper;
    }

    public void setTopicBumper(int topicBumper) {
        this.topicBumper = topicBumper;
    }

    private String pollTitle;

    @Basic
    @javax.persistence.Column(name = "poll_title")
    public String getPollTitle() {
        return pollTitle;
    }

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    private int pollStart;

    @Basic
    @javax.persistence.Column(name = "poll_start")
    public int getPollStart() {
        return pollStart;
    }

    public void setPollStart(int pollStart) {
        this.pollStart = pollStart;
    }

    private int pollLength;

    @Basic
    @javax.persistence.Column(name = "poll_length")
    public int getPollLength() {
        return pollLength;
    }

    public void setPollLength(int pollLength) {
        this.pollLength = pollLength;
    }

    private byte pollMaxOptions;

    @Basic
    @javax.persistence.Column(name = "poll_max_options")
    public byte getPollMaxOptions() {
        return pollMaxOptions;
    }

    public void setPollMaxOptions(byte pollMaxOptions) {
        this.pollMaxOptions = pollMaxOptions;
    }

    private int pollLastVote;

    @Basic
    @javax.persistence.Column(name = "poll_last_vote")
    public int getPollLastVote() {
        return pollLastVote;
    }

    public void setPollLastVote(int pollLastVote) {
        this.pollLastVote = pollLastVote;
    }

    private byte pollVoteChange;

    @Basic
    @javax.persistence.Column(name = "poll_vote_change")
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
