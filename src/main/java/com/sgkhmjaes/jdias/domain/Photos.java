/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p")
    , @NamedQuery(name = "Photos.findById", query = "SELECT p FROM Photos p WHERE p.id = :id")
    , @NamedQuery(name = "Photos.findByIdAuthor", query = "SELECT p FROM Photos p WHERE p.idAuthor = :idAuthor")
    , @NamedQuery(name = "Photos.findByPublics", query = "SELECT p FROM Photos p WHERE p.publics = :publics")
    , @NamedQuery(name = "Photos.findByGuid", query = "SELECT p FROM Photos p WHERE p.guid = :guid")
    , @NamedQuery(name = "Photos.findByPending", query = "SELECT p FROM Photos p WHERE p.pending = :pending")
    , @NamedQuery(name = "Photos.findByRemotePhotoName", query = "SELECT p FROM Photos p WHERE p.remotePhotoName = :remotePhotoName")
    , @NamedQuery(name = "Photos.findByRandomString", query = "SELECT p FROM Photos p WHERE p.randomString = :randomString")
    , @NamedQuery(name = "Photos.findByProcessedImage", query = "SELECT p FROM Photos p WHERE p.processedImage = :processedImage")
    , @NamedQuery(name = "Photos.findByCreatedAt", query = "SELECT p FROM Photos p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Photos.findByUpdatedAt", query = "SELECT p FROM Photos p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Photos.findByUnprocessedImage", query = "SELECT p FROM Photos p WHERE p.unprocessedImage = :unprocessedImage")
    , @NamedQuery(name = "Photos.findByStatusMessageGuid", query = "SELECT p FROM Photos p WHERE p.statusMessageGuid = :statusMessageGuid")
    , @NamedQuery(name = "Photos.findByCommentsCount", query = "SELECT p FROM Photos p WHERE p.commentsCount = :commentsCount")
    , @NamedQuery(name = "Photos.findByHeight", query = "SELECT p FROM Photos p WHERE p.height = :height")
    , @NamedQuery(name = "Photos.findByWidth", query = "SELECT p FROM Photos p WHERE p.width = :width")})
public class Photos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_author")
    private Integer idAuthor;
    @Column(name = "publics")
    private Boolean publics;
    @Column(name = "guid")
    private String guid;
    @Column(name = "pending")
    private Boolean pending;
    @Lob
    @Column(name = "text")
    private String text;
    @Lob
    @Column(name = "remote_photo_path")
    private String remotePhotoPath;
    @Column(name = "remote_photo_name")
    private String remotePhotoName;
    @Column(name = "random_string")
    private String randomString;
    @Column(name = "processed_image")
    private String processedImage;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "unprocessed_image")
    private String unprocessedImage;
    @Column(name = "status_message_guid")
    private String statusMessageGuid;
    @Column(name = "comments_count")
    private Integer commentsCount;
    @Column(name = "height")
    private Integer height;
    @Column(name = "width")
    private Integer width;

    public Photos() {
    }

    public Photos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Boolean getPublics() {
        return publics;
    }

    public void setPublics(Boolean publics) {
        this.publics = publics;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRemotePhotoPath() {
        return remotePhotoPath;
    }

    public void setRemotePhotoPath(String remotePhotoPath) {
        this.remotePhotoPath = remotePhotoPath;
    }

    public String getRemotePhotoName() {
        return remotePhotoName;
    }

    public void setRemotePhotoName(String remotePhotoName) {
        this.remotePhotoName = remotePhotoName;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public String getProcessedImage() {
        return processedImage;
    }

    public void setProcessedImage(String processedImage) {
        this.processedImage = processedImage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUnprocessedImage() {
        return unprocessedImage;
    }

    public void setUnprocessedImage(String unprocessedImage) {
        this.unprocessedImage = unprocessedImage;
    }

    public String getStatusMessageGuid() {
        return statusMessageGuid;
    }

    public void setStatusMessageGuid(String statusMessageGuid) {
        this.statusMessageGuid = statusMessageGuid;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Photos[ id=" + id + " ]";
    }
    
}
