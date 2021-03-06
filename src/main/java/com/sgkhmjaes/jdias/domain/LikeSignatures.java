/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "like_signatures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikeSignatures.findAll", query = "SELECT l FROM LikeSignatures l")
    , @NamedQuery(name = "LikeSignatures.findById", query = "SELECT l FROM LikeSignatures l WHERE l.id = :id")})
public class LikeSignatures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "author_signature")
    private String authorSignature;
    @Lob
    @Column(name = "additional_data")
    private String additionalData;
    @JoinColumn(name = "likes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Likes likesId;
    @JoinColumn(name = "signature_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SignatureOrder signatureOrderId;

    public LikeSignatures() {
    }

    public LikeSignatures(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorSignature() {
        return authorSignature;
    }

    public void setAuthorSignature(String authorSignature) {
        this.authorSignature = authorSignature;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public Likes getLikesId() {
        return likesId;
    }

    public void setLikesId(Likes likesId) {
        this.likesId = likesId;
    }

    public SignatureOrder getSignatureOrderId() {
        return signatureOrderId;
    }

    public void setSignatureOrderId(SignatureOrder signatureOrderId) {
        this.signatureOrderId = signatureOrderId;
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
        if (!(object instanceof LikeSignatures)) {
            return false;
        }
        LikeSignatures other = (LikeSignatures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.LikeSignatures[ id=" + id + " ]";
    }
    
}
