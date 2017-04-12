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
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findById", query = "SELECT c FROM Contacts c WHERE c.id = :id")
    , @NamedQuery(name = "Contacts.findByUserId", query = "SELECT c FROM Contacts c WHERE c.userId = :userId")
    , @NamedQuery(name = "Contacts.findByCreatedAt", query = "SELECT c FROM Contacts c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Contacts.findByUpdatedAt", query = "SELECT c FROM Contacts c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Contacts.findBySharing", query = "SELECT c FROM Contacts c WHERE c.sharing = :sharing")
    , @NamedQuery(name = "Contacts.findByReceiving", query = "SELECT c FROM Contacts c WHERE c.receiving = :receiving")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "sharing")
    private Boolean sharing;
    @Column(name = "receiving")
    private Boolean receiving;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactsId")
    private Collection<AspectMemberships> aspectMembershipsCollection;
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People peopleId;

    public Contacts() {
    }

    public Contacts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Boolean getSharing() {
        return sharing;
    }

    public void setSharing(Boolean sharing) {
        this.sharing = sharing;
    }

    public Boolean getReceiving() {
        return receiving;
    }

    public void setReceiving(Boolean receiving) {
        this.receiving = receiving;
    }

    @XmlTransient
    public Collection<AspectMemberships> getAspectMembershipsCollection() {
        return aspectMembershipsCollection;
    }

    public void setAspectMembershipsCollection(Collection<AspectMemberships> aspectMembershipsCollection) {
        this.aspectMembershipsCollection = aspectMembershipsCollection;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
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
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Contacts[ id=" + id + " ]";
    }
    
}
