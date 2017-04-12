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
@Table(name = "taggings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taggings.findAll", query = "SELECT t FROM Taggings t")
    , @NamedQuery(name = "Taggings.findById", query = "SELECT t FROM Taggings t WHERE t.id = :id")
    , @NamedQuery(name = "Taggings.findByTagId", query = "SELECT t FROM Taggings t WHERE t.tagId = :tagId")
    , @NamedQuery(name = "Taggings.findByTaggableId", query = "SELECT t FROM Taggings t WHERE t.taggableId = :taggableId")
    , @NamedQuery(name = "Taggings.findByTaggableType", query = "SELECT t FROM Taggings t WHERE t.taggableType = :taggableType")
    , @NamedQuery(name = "Taggings.findByTaggerId", query = "SELECT t FROM Taggings t WHERE t.taggerId = :taggerId")
    , @NamedQuery(name = "Taggings.findByTaggerType", query = "SELECT t FROM Taggings t WHERE t.taggerType = :taggerType")
    , @NamedQuery(name = "Taggings.findByContext", query = "SELECT t FROM Taggings t WHERE t.context = :context")
    , @NamedQuery(name = "Taggings.findByCreatedAt", query = "SELECT t FROM Taggings t WHERE t.createdAt = :createdAt")})
public class Taggings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tag_id")
    private Integer tagId;
    @Column(name = "taggable_id")
    private Integer taggableId;
    @Column(name = "taggable_type")
    private String taggableType;
    @Column(name = "tagger_id")
    private Integer taggerId;
    @Column(name = "tagger_type")
    private String taggerType;
    @Column(name = "context")
    private String context;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Taggings() {
    }

    public Taggings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTaggableId() {
        return taggableId;
    }

    public void setTaggableId(Integer taggableId) {
        this.taggableId = taggableId;
    }

    public String getTaggableType() {
        return taggableType;
    }

    public void setTaggableType(String taggableType) {
        this.taggableType = taggableType;
    }

    public Integer getTaggerId() {
        return taggerId;
    }

    public void setTaggerId(Integer taggerId) {
        this.taggerId = taggerId;
    }

    public String getTaggerType() {
        return taggerType;
    }

    public void setTaggerType(String taggerType) {
        this.taggerType = taggerType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof Taggings)) {
            return false;
        }
        Taggings other = (Taggings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Taggings[ id=" + id + " ]";
    }
    
}
