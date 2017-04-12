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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aspect_memberships")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AspectMemberships.findAll", query = "SELECT a FROM AspectMemberships a")
    , @NamedQuery(name = "AspectMemberships.findById", query = "SELECT a FROM AspectMemberships a WHERE a.id = :id")
    , @NamedQuery(name = "AspectMemberships.findByCreatedAt", query = "SELECT a FROM AspectMemberships a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "AspectMemberships.findByUpdatedAt", query = "SELECT a FROM AspectMemberships a WHERE a.updatedAt = :updatedAt")})
public class AspectMemberships implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "aspects_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aspects aspectsId;
    @JoinColumn(name = "contacts_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contacts contactsId;

    public AspectMemberships() {
    }

    public AspectMemberships(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Aspects getAspectsId() {
        return aspectsId;
    }

    public void setAspectsId(Aspects aspectsId) {
        this.aspectsId = aspectsId;
    }

    public Contacts getContactsId() {
        return contactsId;
    }

    public void setContactsId(Contacts contactsId) {
        this.contactsId = contactsId;
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
        if (!(object instanceof AspectMemberships)) {
            return false;
        }
        AspectMemberships other = (AspectMemberships) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.AspectMemberships[ id=" + id + " ]";
    }
    
}
