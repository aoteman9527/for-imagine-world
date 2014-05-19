package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by letuan on 4/16/14.
 */
@Entity
@Table(name = "text", schema = "", catalog = "imagine_world")
public class TextEntity {
    private int nodeid;
    private String previewtext;
    private String previewimage;
    private String previewvideo;
    private Short imageheight;
    private Short imagewidth;
    private String rawtext;
    private String pagetextimages;
    private Short moderated;
    private String pagetext;
    private String htmlstate;
    private short allowsmilie;
    private short showsignature;
    private short attach;
    private short infraction;
    private int reportnodeid;

    @Id
    @Column(name = "nodeid")
    public int getNodeid() {
        return nodeid;
    }

    public void setNodeid(int nodeid) {
        this.nodeid = nodeid;
    }

    @Basic
    @Column(name = "previewtext")
    public String getPreviewtext() {
        return previewtext;
    }

    public void setPreviewtext(String previewtext) {
        this.previewtext = previewtext;
    }

    @Basic
    @Column(name = "previewimage")
    public String getPreviewimage() {
        return previewimage;
    }

    public void setPreviewimage(String previewimage) {
        this.previewimage = previewimage;
    }

    @Basic
    @Column(name = "previewvideo")
    public String getPreviewvideo() {
        return previewvideo;
    }

    public void setPreviewvideo(String previewvideo) {
        this.previewvideo = previewvideo;
    }

    @Basic
    @Column(name = "imageheight")
    public Short getImageheight() {
        return imageheight;
    }

    public void setImageheight(Short imageheight) {
        this.imageheight = imageheight;
    }

    @Basic
    @Column(name = "imagewidth")
    public Short getImagewidth() {
        return imagewidth;
    }

    public void setImagewidth(Short imagewidth) {
        this.imagewidth = imagewidth;
    }

    @Basic
    @Column(name = "rawtext")
    public String getRawtext() {
        return rawtext;
    }

    public void setRawtext(String rawtext) {
        this.rawtext = rawtext;
    }

    @Basic
    @Column(name = "pagetextimages")
    public String getPagetextimages() {
        return pagetextimages;
    }

    public void setPagetextimages(String pagetextimages) {
        this.pagetextimages = pagetextimages;
    }

    @Basic
    @Column(name = "moderated")
    public Short getModerated() {
        return moderated;
    }

    public void setModerated(Short moderated) {
        this.moderated = moderated;
    }

    @Basic
    @Column(name = "pagetext")
    public String getPagetext() {
        return pagetext;
    }

    public void setPagetext(String pagetext) {
        this.pagetext = pagetext;
    }

    @Basic
    @Column(name = "htmlstate")
    public String getHtmlstate() {
        return htmlstate;
    }

    public void setHtmlstate(String htmlstate) {
        this.htmlstate = htmlstate;
    }

    @Basic
    @Column(name = "allowsmilie")
    public short getAllowsmilie() {
        return allowsmilie;
    }

    public void setAllowsmilie(short allowsmilie) {
        this.allowsmilie = allowsmilie;
    }

    @Basic
    @Column(name = "showsignature")
    public short getShowsignature() {
        return showsignature;
    }

    public void setShowsignature(short showsignature) {
        this.showsignature = showsignature;
    }

    @Basic
    @Column(name = "attach")
    public short getAttach() {
        return attach;
    }

    public void setAttach(short attach) {
        this.attach = attach;
    }

    @Basic
    @Column(name = "infraction")
    public short getInfraction() {
        return infraction;
    }

    public void setInfraction(short infraction) {
        this.infraction = infraction;
    }

    @Basic
    @Column(name = "reportnodeid")
    public int getReportnodeid() {
        return reportnodeid;
    }

    public void setReportnodeid(int reportnodeid) {
        this.reportnodeid = reportnodeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextEntity that = (TextEntity) o;

        if (allowsmilie != that.allowsmilie) return false;
        if (attach != that.attach) return false;
        if (infraction != that.infraction) return false;
        if (nodeid != that.nodeid) return false;
        if (reportnodeid != that.reportnodeid) return false;
        if (showsignature != that.showsignature) return false;
        if (htmlstate != null ? !htmlstate.equals(that.htmlstate) : that.htmlstate != null) return false;
        if (imageheight != null ? !imageheight.equals(that.imageheight) : that.imageheight != null) return false;
        if (imagewidth != null ? !imagewidth.equals(that.imagewidth) : that.imagewidth != null) return false;
        if (moderated != null ? !moderated.equals(that.moderated) : that.moderated != null) return false;
        if (pagetext != null ? !pagetext.equals(that.pagetext) : that.pagetext != null) return false;
        if (pagetextimages != null ? !pagetextimages.equals(that.pagetextimages) : that.pagetextimages != null)
            return false;
        if (previewimage != null ? !previewimage.equals(that.previewimage) : that.previewimage != null) return false;
        if (previewtext != null ? !previewtext.equals(that.previewtext) : that.previewtext != null) return false;
        if (previewvideo != null ? !previewvideo.equals(that.previewvideo) : that.previewvideo != null) return false;
        if (rawtext != null ? !rawtext.equals(that.rawtext) : that.rawtext != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nodeid;
        result = 31 * result + (previewtext != null ? previewtext.hashCode() : 0);
        result = 31 * result + (previewimage != null ? previewimage.hashCode() : 0);
        result = 31 * result + (previewvideo != null ? previewvideo.hashCode() : 0);
        result = 31 * result + (imageheight != null ? imageheight.hashCode() : 0);
        result = 31 * result + (imagewidth != null ? imagewidth.hashCode() : 0);
        result = 31 * result + (rawtext != null ? rawtext.hashCode() : 0);
        result = 31 * result + (pagetextimages != null ? pagetextimages.hashCode() : 0);
        result = 31 * result + (moderated != null ? moderated.hashCode() : 0);
        result = 31 * result + (pagetext != null ? pagetext.hashCode() : 0);
        result = 31 * result + (htmlstate != null ? htmlstate.hashCode() : 0);
        result = 31 * result + (int) allowsmilie;
        result = 31 * result + (int) showsignature;
        result = 31 * result + (int) attach;
        result = 31 * result + (int) infraction;
        result = 31 * result + reportnodeid;
        return result;
    }
}
