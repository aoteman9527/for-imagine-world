package com.imagine.world.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@javax.persistence.Table(name = "FORUMS", schema = "", catalog = "blogs")
public class ForumsEntity {
    private int forumId;

    @Id
    @javax.persistence.Column(name = "forum_id")
    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    private int parentId;

    @Basic
    @javax.persistence.Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    private int leftId;

    @Basic
    @javax.persistence.Column(name = "left_id")
    public int getLeftId() {
        return leftId;
    }

    public void setLeftId(int leftId) {
        this.leftId = leftId;
    }

    private int rightId;

    @Basic
    @javax.persistence.Column(name = "right_id")
    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }

    private String forumParents;

    @Basic
    @javax.persistence.Column(name = "forum_parents")
    public String getForumParents() {
        return forumParents;
    }

    public void setForumParents(String forumParents) {
        this.forumParents = forumParents;
    }

    private String forumName;

    @Basic
    @javax.persistence.Column(name = "forum_name")
    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    private String forumDesc;

    @Basic
    @javax.persistence.Column(name = "forum_desc")
    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    private String forumDescBitfield;

    @Basic
    @javax.persistence.Column(name = "forum_desc_bitfield")
    public String getForumDescBitfield() {
        return forumDescBitfield;
    }

    public void setForumDescBitfield(String forumDescBitfield) {
        this.forumDescBitfield = forumDescBitfield;
    }

    private int forumDescOptions;

    @Basic
    @javax.persistence.Column(name = "forum_desc_options")
    public int getForumDescOptions() {
        return forumDescOptions;
    }

    public void setForumDescOptions(int forumDescOptions) {
        this.forumDescOptions = forumDescOptions;
    }

    private String forumDescUid;

    @Basic
    @javax.persistence.Column(name = "forum_desc_uid")
    public String getForumDescUid() {
        return forumDescUid;
    }

    public void setForumDescUid(String forumDescUid) {
        this.forumDescUid = forumDescUid;
    }

    private String forumLink;

    @Basic
    @javax.persistence.Column(name = "forum_link")
    public String getForumLink() {
        return forumLink;
    }

    public void setForumLink(String forumLink) {
        this.forumLink = forumLink;
    }

    private String forumPassword;

    @Basic
    @javax.persistence.Column(name = "forum_password")
    public String getForumPassword() {
        return forumPassword;
    }

    public void setForumPassword(String forumPassword) {
        this.forumPassword = forumPassword;
    }

    private int forumStyle;

    @Basic
    @javax.persistence.Column(name = "forum_style")
    public int getForumStyle() {
        return forumStyle;
    }

    public void setForumStyle(int forumStyle) {
        this.forumStyle = forumStyle;
    }

    private String forumImage;

    @Basic
    @javax.persistence.Column(name = "forum_image")
    public String getForumImage() {
        return forumImage;
    }

    public void setForumImage(String forumImage) {
        this.forumImage = forumImage;
    }

    private String forumRules;

    @Basic
    @javax.persistence.Column(name = "forum_rules")
    public String getForumRules() {
        return forumRules;
    }

    public void setForumRules(String forumRules) {
        this.forumRules = forumRules;
    }

    private String forumRulesLink;

    @Basic
    @javax.persistence.Column(name = "forum_rules_link")
    public String getForumRulesLink() {
        return forumRulesLink;
    }

    public void setForumRulesLink(String forumRulesLink) {
        this.forumRulesLink = forumRulesLink;
    }

    private String forumRulesBitfield;

    @Basic
    @javax.persistence.Column(name = "forum_rules_bitfield")
    public String getForumRulesBitfield() {
        return forumRulesBitfield;
    }

    public void setForumRulesBitfield(String forumRulesBitfield) {
        this.forumRulesBitfield = forumRulesBitfield;
    }

    private int forumRulesOptions;

    @Basic
    @javax.persistence.Column(name = "forum_rules_options")
    public int getForumRulesOptions() {
        return forumRulesOptions;
    }

    public void setForumRulesOptions(int forumRulesOptions) {
        this.forumRulesOptions = forumRulesOptions;
    }

    private String forumRulesUid;

    @Basic
    @javax.persistence.Column(name = "forum_rules_uid")
    public String getForumRulesUid() {
        return forumRulesUid;
    }

    public void setForumRulesUid(String forumRulesUid) {
        this.forumRulesUid = forumRulesUid;
    }

    private byte forumTopicsPerPage;

    @Basic
    @javax.persistence.Column(name = "forum_topics_per_page")
    public byte getForumTopicsPerPage() {
        return forumTopicsPerPage;
    }

    public void setForumTopicsPerPage(byte forumTopicsPerPage) {
        this.forumTopicsPerPage = forumTopicsPerPage;
    }

    private byte forumType;

    @Basic
    @javax.persistence.Column(name = "forum_type")
    public byte getForumType() {
        return forumType;
    }

    public void setForumType(byte forumType) {
        this.forumType = forumType;
    }

    private byte forumStatus;

    @Basic
    @javax.persistence.Column(name = "forum_status")
    public byte getForumStatus() {
        return forumStatus;
    }

    public void setForumStatus(byte forumStatus) {
        this.forumStatus = forumStatus;
    }

    private int forumPosts;

    @Basic
    @javax.persistence.Column(name = "forum_posts")
    public int getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(int forumPosts) {
        this.forumPosts = forumPosts;
    }

    private int forumTopics;

    @Basic
    @javax.persistence.Column(name = "forum_topics")
    public int getForumTopics() {
        return forumTopics;
    }

    public void setForumTopics(int forumTopics) {
        this.forumTopics = forumTopics;
    }

    private int forumTopicsReal;

    @Basic
    @javax.persistence.Column(name = "forum_topics_real")
    public int getForumTopicsReal() {
        return forumTopicsReal;
    }

    public void setForumTopicsReal(int forumTopicsReal) {
        this.forumTopicsReal = forumTopicsReal;
    }

    private int forumLastPostId;

    @Basic
    @javax.persistence.Column(name = "forum_last_post_id")
    public int getForumLastPostId() {
        return forumLastPostId;
    }

    public void setForumLastPostId(int forumLastPostId) {
        this.forumLastPostId = forumLastPostId;
    }

    private int forumLastPosterId;

    @Basic
    @javax.persistence.Column(name = "forum_last_poster_id")
    public int getForumLastPosterId() {
        return forumLastPosterId;
    }

    public void setForumLastPosterId(int forumLastPosterId) {
        this.forumLastPosterId = forumLastPosterId;
    }

    private String forumLastPostSubject;

    @Basic
    @javax.persistence.Column(name = "forum_last_post_subject")
    public String getForumLastPostSubject() {
        return forumLastPostSubject;
    }

    public void setForumLastPostSubject(String forumLastPostSubject) {
        this.forumLastPostSubject = forumLastPostSubject;
    }

    private int forumLastPostTime;

    @Basic
    @javax.persistence.Column(name = "forum_last_post_time")
    public int getForumLastPostTime() {
        return forumLastPostTime;
    }

    public void setForumLastPostTime(int forumLastPostTime) {
        this.forumLastPostTime = forumLastPostTime;
    }

    private String forumLastPosterName;

    @Basic
    @javax.persistence.Column(name = "forum_last_poster_name")
    public String getForumLastPosterName() {
        return forumLastPosterName;
    }

    public void setForumLastPosterName(String forumLastPosterName) {
        this.forumLastPosterName = forumLastPosterName;
    }

    private String forumLastPosterColour;

    @Basic
    @javax.persistence.Column(name = "forum_last_poster_colour")
    public String getForumLastPosterColour() {
        return forumLastPosterColour;
    }

    public void setForumLastPosterColour(String forumLastPosterColour) {
        this.forumLastPosterColour = forumLastPosterColour;
    }

    private byte forumFlags;

    @Basic
    @javax.persistence.Column(name = "forum_flags")
    public byte getForumFlags() {
        return forumFlags;
    }

    public void setForumFlags(byte forumFlags) {
        this.forumFlags = forumFlags;
    }

    private int forumOptions;

    @Basic
    @javax.persistence.Column(name = "forum_options")
    public int getForumOptions() {
        return forumOptions;
    }

    public void setForumOptions(int forumOptions) {
        this.forumOptions = forumOptions;
    }

    private byte displaySubforumList;

    @Basic
    @javax.persistence.Column(name = "display_subforum_list")
    public byte getDisplaySubforumList() {
        return displaySubforumList;
    }

    public void setDisplaySubforumList(byte displaySubforumList) {
        this.displaySubforumList = displaySubforumList;
    }

    private byte displayOnIndex;

    @Basic
    @javax.persistence.Column(name = "display_on_index")
    public byte getDisplayOnIndex() {
        return displayOnIndex;
    }

    public void setDisplayOnIndex(byte displayOnIndex) {
        this.displayOnIndex = displayOnIndex;
    }

    private byte enableIndexing;

    @Basic
    @javax.persistence.Column(name = "enable_indexing")
    public byte getEnableIndexing() {
        return enableIndexing;
    }

    public void setEnableIndexing(byte enableIndexing) {
        this.enableIndexing = enableIndexing;
    }

    private byte enableIcons;

    @Basic
    @javax.persistence.Column(name = "enable_icons")
    public byte getEnableIcons() {
        return enableIcons;
    }

    public void setEnableIcons(byte enableIcons) {
        this.enableIcons = enableIcons;
    }

    private byte enablePrune;

    @Basic
    @javax.persistence.Column(name = "enable_prune")
    public byte getEnablePrune() {
        return enablePrune;
    }

    public void setEnablePrune(byte enablePrune) {
        this.enablePrune = enablePrune;
    }

    private int pruneNext;

    @Basic
    @javax.persistence.Column(name = "prune_next")
    public int getPruneNext() {
        return pruneNext;
    }

    public void setPruneNext(int pruneNext) {
        this.pruneNext = pruneNext;
    }

    private int pruneDays;

    @Basic
    @javax.persistence.Column(name = "prune_days")
    public int getPruneDays() {
        return pruneDays;
    }

    public void setPruneDays(int pruneDays) {
        this.pruneDays = pruneDays;
    }

    private int pruneViewed;

    @Basic
    @javax.persistence.Column(name = "prune_viewed")
    public int getPruneViewed() {
        return pruneViewed;
    }

    public void setPruneViewed(int pruneViewed) {
        this.pruneViewed = pruneViewed;
    }

    private int pruneFreq;

    @Basic
    @javax.persistence.Column(name = "prune_freq")
    public int getPruneFreq() {
        return pruneFreq;
    }

    public void setPruneFreq(int pruneFreq) {
        this.pruneFreq = pruneFreq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumsEntity that = (ForumsEntity) o;

        if (displayOnIndex != that.displayOnIndex) return false;
        if (displaySubforumList != that.displaySubforumList) return false;
        if (enableIcons != that.enableIcons) return false;
        if (enableIndexing != that.enableIndexing) return false;
        if (enablePrune != that.enablePrune) return false;
        if (forumDescOptions != that.forumDescOptions) return false;
        if (forumFlags != that.forumFlags) return false;
        if (forumId != that.forumId) return false;
        if (forumLastPostId != that.forumLastPostId) return false;
        if (forumLastPostTime != that.forumLastPostTime) return false;
        if (forumLastPosterId != that.forumLastPosterId) return false;
        if (forumOptions != that.forumOptions) return false;
        if (forumPosts != that.forumPosts) return false;
        if (forumRulesOptions != that.forumRulesOptions) return false;
        if (forumStatus != that.forumStatus) return false;
        if (forumStyle != that.forumStyle) return false;
        if (forumTopics != that.forumTopics) return false;
        if (forumTopicsPerPage != that.forumTopicsPerPage) return false;
        if (forumTopicsReal != that.forumTopicsReal) return false;
        if (forumType != that.forumType) return false;
        if (leftId != that.leftId) return false;
        if (parentId != that.parentId) return false;
        if (pruneDays != that.pruneDays) return false;
        if (pruneFreq != that.pruneFreq) return false;
        if (pruneNext != that.pruneNext) return false;
        if (pruneViewed != that.pruneViewed) return false;
        if (rightId != that.rightId) return false;
        if (forumDesc != null ? !forumDesc.equals(that.forumDesc) : that.forumDesc != null) return false;
        if (forumDescBitfield != null ? !forumDescBitfield.equals(that.forumDescBitfield) : that.forumDescBitfield != null)
            return false;
        if (forumDescUid != null ? !forumDescUid.equals(that.forumDescUid) : that.forumDescUid != null) return false;
        if (forumImage != null ? !forumImage.equals(that.forumImage) : that.forumImage != null) return false;
        if (forumLastPostSubject != null ? !forumLastPostSubject.equals(that.forumLastPostSubject) : that.forumLastPostSubject != null)
            return false;
        if (forumLastPosterColour != null ? !forumLastPosterColour.equals(that.forumLastPosterColour) : that.forumLastPosterColour != null)
            return false;
        if (forumLastPosterName != null ? !forumLastPosterName.equals(that.forumLastPosterName) : that.forumLastPosterName != null)
            return false;
        if (forumLink != null ? !forumLink.equals(that.forumLink) : that.forumLink != null) return false;
        if (forumName != null ? !forumName.equals(that.forumName) : that.forumName != null) return false;
        if (forumParents != null ? !forumParents.equals(that.forumParents) : that.forumParents != null) return false;
        if (forumPassword != null ? !forumPassword.equals(that.forumPassword) : that.forumPassword != null)
            return false;
        if (forumRules != null ? !forumRules.equals(that.forumRules) : that.forumRules != null) return false;
        if (forumRulesBitfield != null ? !forumRulesBitfield.equals(that.forumRulesBitfield) : that.forumRulesBitfield != null)
            return false;
        if (forumRulesLink != null ? !forumRulesLink.equals(that.forumRulesLink) : that.forumRulesLink != null)
            return false;
        if (forumRulesUid != null ? !forumRulesUid.equals(that.forumRulesUid) : that.forumRulesUid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = forumId;
        result = 31 * result + parentId;
        result = 31 * result + leftId;
        result = 31 * result + rightId;
        result = 31 * result + (forumParents != null ? forumParents.hashCode() : 0);
        result = 31 * result + (forumName != null ? forumName.hashCode() : 0);
        result = 31 * result + (forumDesc != null ? forumDesc.hashCode() : 0);
        result = 31 * result + (forumDescBitfield != null ? forumDescBitfield.hashCode() : 0);
        result = 31 * result + forumDescOptions;
        result = 31 * result + (forumDescUid != null ? forumDescUid.hashCode() : 0);
        result = 31 * result + (forumLink != null ? forumLink.hashCode() : 0);
        result = 31 * result + (forumPassword != null ? forumPassword.hashCode() : 0);
        result = 31 * result + forumStyle;
        result = 31 * result + (forumImage != null ? forumImage.hashCode() : 0);
        result = 31 * result + (forumRules != null ? forumRules.hashCode() : 0);
        result = 31 * result + (forumRulesLink != null ? forumRulesLink.hashCode() : 0);
        result = 31 * result + (forumRulesBitfield != null ? forumRulesBitfield.hashCode() : 0);
        result = 31 * result + forumRulesOptions;
        result = 31 * result + (forumRulesUid != null ? forumRulesUid.hashCode() : 0);
        result = 31 * result + (int) forumTopicsPerPage;
        result = 31 * result + (int) forumType;
        result = 31 * result + (int) forumStatus;
        result = 31 * result + forumPosts;
        result = 31 * result + forumTopics;
        result = 31 * result + forumTopicsReal;
        result = 31 * result + forumLastPostId;
        result = 31 * result + forumLastPosterId;
        result = 31 * result + (forumLastPostSubject != null ? forumLastPostSubject.hashCode() : 0);
        result = 31 * result + forumLastPostTime;
        result = 31 * result + (forumLastPosterName != null ? forumLastPosterName.hashCode() : 0);
        result = 31 * result + (forumLastPosterColour != null ? forumLastPosterColour.hashCode() : 0);
        result = 31 * result + (int) forumFlags;
        result = 31 * result + forumOptions;
        result = 31 * result + (int) displaySubforumList;
        result = 31 * result + (int) displayOnIndex;
        result = 31 * result + (int) enableIndexing;
        result = 31 * result + (int) enableIcons;
        result = 31 * result + (int) enablePrune;
        result = 31 * result + pruneNext;
        result = 31 * result + pruneDays;
        result = 31 * result + pruneViewed;
        result = 31 * result + pruneFreq;
        return result;
    }
}
