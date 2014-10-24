package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by tuan on 10/9/14.
 */
@Entity
@Table(name = "FORUMS", schema = "", catalog = "blogs")
public class ForumsEntity {
    private int forumId;
    private int parentId;
    private int leftId;
    private int rightId;
    private String forumParents;
    private String forumName;
    private String forumDesc;
    private String forumDescBitfield;
    private int forumDescOptions;
    private String forumDescUid;
    private String forumLink;
    private String forumPassword;
    private int forumStyle;
    private String forumImage;
    private String forumRules;
    private String forumRulesLink;
    private String forumRulesBitfield;
    private int forumRulesOptions;
    private String forumRulesUid;
    private byte forumTopicsPerPage;
    private byte forumType;
    private byte forumStatus;
    private int forumPosts;
    private int forumTopics;
    private int forumTopicsReal;
    private int forumLastPostId;
    private int forumLastPosterId;
    private String forumLastPostSubject;
    private int forumLastPostTime;
    private String forumLastPosterName;
    private String forumLastPosterColour;
    private byte forumFlags;
    private int forumOptions;
    private byte displaySubforumList;
    private byte displayOnIndex;
    private byte enableIndexing;
    private byte enableIcons;
    private byte enablePrune;
    private int pruneNext;
    private int pruneDays;
    private int pruneViewed;
    private int pruneFreq;

    @Id
    @Column(name = "forum_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    @Basic
    @Column(name = "parent_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "left_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getLeftId() {
        return leftId;
    }

    public void setLeftId(int leftId) {
        this.leftId = leftId;
    }

    @Basic
    @Column(name = "right_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }

    @Basic
    @Column(name = "forum_parents", nullable = false, insertable = true, updatable = true, length = 16777215, precision = 0)
    public String getForumParents() {
        return forumParents;
    }

    public void setForumParents(String forumParents) {
        this.forumParents = forumParents;
    }

    @Basic
    @Column(name = "forum_name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    @Basic
    @Column(name = "forum_desc", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    @Basic
    @Column(name = "forum_desc_bitfield", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumDescBitfield() {
        return forumDescBitfield;
    }

    public void setForumDescBitfield(String forumDescBitfield) {
        this.forumDescBitfield = forumDescBitfield;
    }

    @Basic
    @Column(name = "forum_desc_options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getForumDescOptions() {
        return forumDescOptions;
    }

    public void setForumDescOptions(int forumDescOptions) {
        this.forumDescOptions = forumDescOptions;
    }

    @Basic
    @Column(name = "forum_desc_uid", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public String getForumDescUid() {
        return forumDescUid;
    }

    public void setForumDescUid(String forumDescUid) {
        this.forumDescUid = forumDescUid;
    }

    @Basic
    @Column(name = "forum_link", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumLink() {
        return forumLink;
    }

    public void setForumLink(String forumLink) {
        this.forumLink = forumLink;
    }

    @Basic
    @Column(name = "forum_password", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    public String getForumPassword() {
        return forumPassword;
    }

    public void setForumPassword(String forumPassword) {
        this.forumPassword = forumPassword;
    }

    @Basic
    @Column(name = "forum_style", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumStyle() {
        return forumStyle;
    }

    public void setForumStyle(int forumStyle) {
        this.forumStyle = forumStyle;
    }

    @Basic
    @Column(name = "forum_image", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumImage() {
        return forumImage;
    }

    public void setForumImage(String forumImage) {
        this.forumImage = forumImage;
    }

    @Basic
    @Column(name = "forum_rules", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    public String getForumRules() {
        return forumRules;
    }

    public void setForumRules(String forumRules) {
        this.forumRules = forumRules;
    }

    @Basic
    @Column(name = "forum_rules_link", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumRulesLink() {
        return forumRulesLink;
    }

    public void setForumRulesLink(String forumRulesLink) {
        this.forumRulesLink = forumRulesLink;
    }

    @Basic
    @Column(name = "forum_rules_bitfield", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumRulesBitfield() {
        return forumRulesBitfield;
    }

    public void setForumRulesBitfield(String forumRulesBitfield) {
        this.forumRulesBitfield = forumRulesBitfield;
    }

    @Basic
    @Column(name = "forum_rules_options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getForumRulesOptions() {
        return forumRulesOptions;
    }

    public void setForumRulesOptions(int forumRulesOptions) {
        this.forumRulesOptions = forumRulesOptions;
    }

    @Basic
    @Column(name = "forum_rules_uid", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public String getForumRulesUid() {
        return forumRulesUid;
    }

    public void setForumRulesUid(String forumRulesUid) {
        this.forumRulesUid = forumRulesUid;
    }

    @Basic
    @Column(name = "forum_topics_per_page", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getForumTopicsPerPage() {
        return forumTopicsPerPage;
    }

    public void setForumTopicsPerPage(byte forumTopicsPerPage) {
        this.forumTopicsPerPage = forumTopicsPerPage;
    }

    @Basic
    @Column(name = "forum_type", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getForumType() {
        return forumType;
    }

    public void setForumType(byte forumType) {
        this.forumType = forumType;
    }

    @Basic
    @Column(name = "forum_status", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getForumStatus() {
        return forumStatus;
    }

    public void setForumStatus(byte forumStatus) {
        this.forumStatus = forumStatus;
    }

    @Basic
    @Column(name = "forum_posts", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(int forumPosts) {
        this.forumPosts = forumPosts;
    }

    @Basic
    @Column(name = "forum_topics", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumTopics() {
        return forumTopics;
    }

    public void setForumTopics(int forumTopics) {
        this.forumTopics = forumTopics;
    }

    @Basic
    @Column(name = "forum_topics_real", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumTopicsReal() {
        return forumTopicsReal;
    }

    public void setForumTopicsReal(int forumTopicsReal) {
        this.forumTopicsReal = forumTopicsReal;
    }

    @Basic
    @Column(name = "forum_last_post_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumLastPostId() {
        return forumLastPostId;
    }

    public void setForumLastPostId(int forumLastPostId) {
        this.forumLastPostId = forumLastPostId;
    }

    @Basic
    @Column(name = "forum_last_poster_id", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getForumLastPosterId() {
        return forumLastPosterId;
    }

    public void setForumLastPosterId(int forumLastPosterId) {
        this.forumLastPosterId = forumLastPosterId;
    }

    @Basic
    @Column(name = "forum_last_post_subject", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumLastPostSubject() {
        return forumLastPostSubject;
    }

    public void setForumLastPostSubject(String forumLastPostSubject) {
        this.forumLastPostSubject = forumLastPostSubject;
    }

    @Basic
    @Column(name = "forum_last_post_time", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getForumLastPostTime() {
        return forumLastPostTime;
    }

    public void setForumLastPostTime(int forumLastPostTime) {
        this.forumLastPostTime = forumLastPostTime;
    }

    @Basic
    @Column(name = "forum_last_poster_name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    public String getForumLastPosterName() {
        return forumLastPosterName;
    }

    public void setForumLastPosterName(String forumLastPosterName) {
        this.forumLastPosterName = forumLastPosterName;
    }

    @Basic
    @Column(name = "forum_last_poster_colour", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public String getForumLastPosterColour() {
        return forumLastPosterColour;
    }

    public void setForumLastPosterColour(String forumLastPosterColour) {
        this.forumLastPosterColour = forumLastPosterColour;
    }

    @Basic
    @Column(name = "forum_flags", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getForumFlags() {
        return forumFlags;
    }

    public void setForumFlags(byte forumFlags) {
        this.forumFlags = forumFlags;
    }

    @Basic
    @Column(name = "forum_options", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getForumOptions() {
        return forumOptions;
    }

    public void setForumOptions(int forumOptions) {
        this.forumOptions = forumOptions;
    }

    @Basic
    @Column(name = "display_subforum_list", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getDisplaySubforumList() {
        return displaySubforumList;
    }

    public void setDisplaySubforumList(byte displaySubforumList) {
        this.displaySubforumList = displaySubforumList;
    }

    @Basic
    @Column(name = "display_on_index", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getDisplayOnIndex() {
        return displayOnIndex;
    }

    public void setDisplayOnIndex(byte displayOnIndex) {
        this.displayOnIndex = displayOnIndex;
    }

    @Basic
    @Column(name = "enable_indexing", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getEnableIndexing() {
        return enableIndexing;
    }

    public void setEnableIndexing(byte enableIndexing) {
        this.enableIndexing = enableIndexing;
    }

    @Basic
    @Column(name = "enable_icons", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getEnableIcons() {
        return enableIcons;
    }

    public void setEnableIcons(byte enableIcons) {
        this.enableIcons = enableIcons;
    }

    @Basic
    @Column(name = "enable_prune", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getEnablePrune() {
        return enablePrune;
    }

    public void setEnablePrune(byte enablePrune) {
        this.enablePrune = enablePrune;
    }

    @Basic
    @Column(name = "prune_next", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getPruneNext() {
        return pruneNext;
    }

    public void setPruneNext(int pruneNext) {
        this.pruneNext = pruneNext;
    }

    @Basic
    @Column(name = "prune_days", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getPruneDays() {
        return pruneDays;
    }

    public void setPruneDays(int pruneDays) {
        this.pruneDays = pruneDays;
    }

    @Basic
    @Column(name = "prune_viewed", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    public int getPruneViewed() {
        return pruneViewed;
    }

    public void setPruneViewed(int pruneViewed) {
        this.pruneViewed = pruneViewed;
    }

    @Basic
    @Column(name = "prune_freq", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
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
