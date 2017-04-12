/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "signature_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SignatureOrder.findAll", query = "SELECT s FROM SignatureOrder s")
    , @NamedQuery(name = "SignatureOrder.findById", query = "SELECT s FROM SignatureOrder s WHERE s.id = :id")
    , @NamedQuery(name = "SignatureOrder.findByOrder", query = "SELECT s FROM SignatureOrder s WHERE s.order = :order")})
public class SignatureOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "order")
    private String order;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "signatureOrderId")
    private Collection<LikeSignatures> likeSignaturesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "signatureOrderId")
    private Collection<PoleParticipationSignatures> poleParticipationSignaturesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "signatureOrderId")
    private Collection<CommentSignatures> commentSignaturesCollection;

    public SignatureOrder() {
    }

    public SignatureOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @XmlTransient
    public Collection<LikeSignatures> getLikeSignaturesCollection() {
        return likeSignaturesCollection;
    }

    public void setLikeSignaturesCollection(Collection<LikeSignatures> likeSignaturesCollection) {
        this.likeSignaturesCollection = likeSignaturesCollection;
    }

    @XmlTransient
    public Collection<PoleParticipationSignatures> getPoleParticipationSignaturesCollection() {
        return poleParticipationSignaturesCollection;
    }

    public void setPoleParticipationSignaturesCollection(Collection<PoleParticipationSignatures> poleParticipationSignaturesCollection) {
        this.poleParticipationSignaturesCollection = poleParticipationSignaturesCollection;
    }

    @XmlTransient
    public Collection<CommentSignatures> getCommentSignaturesCollection() {
        return commentSignaturesCollection;
    }

    public void setCommentSignaturesCollection(Collection<CommentSignatures> commentSignaturesCollection) {
        this.commentSignaturesCollection = commentSignaturesCollection;
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
        if (!(object instanceof SignatureOrder)) {
            return false;
        }
        SignatureOrder other = (SignatureOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.SignatureOrder[ id=" + id + " ]";
    }
    
}
