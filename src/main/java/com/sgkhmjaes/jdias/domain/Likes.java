/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l")
    , @NamedQuery(name = "Likes.findById", query = "SELECT l FROM Likes l WHERE l.id = :id")
    , @NamedQuery(name = "Likes.findByPositive", query = "SELECT l FROM Likes l WHERE l.positive = :positive")
    , @NamedQuery(name = "Likes.findByTargetId", query = "SELECT l FROM Likes l WHERE l.targetId = :targetId")
    , @NamedQuery(name = "Likes.findByGuid", query = "SELECT l FROM Likes l WHERE l.guid = :guid")
    , @NamedQuery(name = "Likes.findByCreatedAt", query = "SELECT l FROM Likes l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "Likes.findByUpdatedAt", query = "SELECT l FROM Likes l WHERE l.updatedAt = :updatedAt")
    , @NamedQuery(name = "Likes.findByLikescol", query = "SELECT l FROM Likes l WHERE l.likescol = :likescol")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "positive")
    private Boolean positive;
    @Column(name = "target_id")
    private Integer targetId;
    @Column(name = "guid")
    private String guid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "likescol")
    private String likescol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "likesId")
    private Collection<LikeSignatures> likeSignaturesCollection;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People authorId;

    public Likes() {
    }

    public Likes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getLikescol() {
        return likescol;
    }

    public void setLikescol(String likescol) {
        this.likescol = likescol;
    }

    @XmlTransient
    public Collection<LikeSignatures> getLikeSignaturesCollection() {
        return likeSignaturesCollection;
    }

    public void setLikeSignaturesCollection(Collection<LikeSignatures> likeSignaturesCollection) {
        this.likeSignaturesCollection = likeSignaturesCollection;
    }

    public People getAuthorId() {
        return authorId;
    }

    public void setAuthorId(People authorId) {
        this.authorId = authorId;
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
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Likes[ id=" + id + " ]";
    }
    
}
