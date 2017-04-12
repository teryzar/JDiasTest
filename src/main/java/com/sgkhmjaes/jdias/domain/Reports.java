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
@Table(name = "reports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r")
    , @NamedQuery(name = "Reports.findById", query = "SELECT r FROM Reports r WHERE r.id = :id")
    , @NamedQuery(name = "Reports.findByItemId", query = "SELECT r FROM Reports r WHERE r.itemId = :itemId")
    , @NamedQuery(name = "Reports.findByItemType", query = "SELECT r FROM Reports r WHERE r.itemType = :itemType")
    , @NamedQuery(name = "Reports.findByReviewed", query = "SELECT r FROM Reports r WHERE r.reviewed = :reviewed")
    , @NamedQuery(name = "Reports.findByCreatedAt", query = "SELECT r FROM Reports r WHERE r.createdAt = :createdAt")
    , @NamedQuery(name = "Reports.findByUpdatedAt", query = "SELECT r FROM Reports r WHERE r.updatedAt = :updatedAt")
    , @NamedQuery(name = "Reports.findByUserId", query = "SELECT r FROM Reports r WHERE r.userId = :userId")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "item_type")
    private String itemType;
    @Column(name = "reviewed")
    private Boolean reviewed;
    @Lob
    @Column(name = "text")
    private String text;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "user_id")
    private Integer userId;

    public Reports() {
    }

    public Reports(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Boolean getReviewed() {
        return reviewed;
    }

    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Reports[ id=" + id + " ]";
    }
    
}
