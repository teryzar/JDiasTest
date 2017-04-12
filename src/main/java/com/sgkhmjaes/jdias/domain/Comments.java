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
import javax.persistence.Lob;
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
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c")
    , @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id")
    , @NamedQuery(name = "Comments.findByCommentableId", query = "SELECT c FROM Comments c WHERE c.commentableId = :commentableId")
    , @NamedQuery(name = "Comments.findByGuid", query = "SELECT c FROM Comments c WHERE c.guid = :guid")
    , @NamedQuery(name = "Comments.findByCreatedAt", query = "SELECT c FROM Comments c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Comments.findByUpdatedAt", query = "SELECT c FROM Comments c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Comments.findByLikesCount", query = "SELECT c FROM Comments c WHERE c.likesCount = :likesCount")
    , @NamedQuery(name = "Comments.findByCommentableType", query = "SELECT c FROM Comments c WHERE c.commentableType = :commentableType")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "text")
    private String text;
    @Column(name = "commentable_id")
    private Integer commentableId;
    @Column(name = "guid")
    private String guid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "likes_count")
    private Integer likesCount;
    @Column(name = "commentable_type")
    private String commentableType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentsId")
    private Collection<CommentSignatures> commentSignaturesCollection;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People authorId;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCommentableId() {
        return commentableId;
    }

    public void setCommentableId(Integer commentableId) {
        this.commentableId = commentableId;
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

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public String getCommentableType() {
        return commentableType;
    }

    public void setCommentableType(String commentableType) {
        this.commentableType = commentableType;
    }

    @XmlTransient
    public Collection<CommentSignatures> getCommentSignaturesCollection() {
        return commentSignaturesCollection;
    }

    public void setCommentSignaturesCollection(Collection<CommentSignatures> commentSignaturesCollection) {
        this.commentSignaturesCollection = commentSignaturesCollection;
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
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Comments[ id=" + id + " ]";
    }
    
}
