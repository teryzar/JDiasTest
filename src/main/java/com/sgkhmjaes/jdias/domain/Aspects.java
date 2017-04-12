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
@Table(name = "aspects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspects.findAll", query = "SELECT a FROM Aspects a")
    , @NamedQuery(name = "Aspects.findById", query = "SELECT a FROM Aspects a WHERE a.id = :id")
    , @NamedQuery(name = "Aspects.findByName", query = "SELECT a FROM Aspects a WHERE a.name = :name")
    , @NamedQuery(name = "Aspects.findByUserId", query = "SELECT a FROM Aspects a WHERE a.userId = :userId")
    , @NamedQuery(name = "Aspects.findByCreatedAt", query = "SELECT a FROM Aspects a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "Aspects.findByUpdatedAt", query = "SELECT a FROM Aspects a WHERE a.updatedAt = :updatedAt")
    , @NamedQuery(name = "Aspects.findByContactsVisible", query = "SELECT a FROM Aspects a WHERE a.contactsVisible = :contactsVisible")
    , @NamedQuery(name = "Aspects.findByOrderId", query = "SELECT a FROM Aspects a WHERE a.orderId = :orderId")
    , @NamedQuery(name = "Aspects.findByChatEnebled", query = "SELECT a FROM Aspects a WHERE a.chatEnebled = :chatEnebled")
    , @NamedQuery(name = "Aspects.findByPostDefault", query = "SELECT a FROM Aspects a WHERE a.postDefault = :postDefault")})
public class Aspects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "contacts_visible")
    private Boolean contactsVisible;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "chat_enebled")
    private Boolean chatEnebled;
    @Column(name = "post_default")
    private Boolean postDefault;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspectId")
    private Collection<AspectVisibilities> aspectVisibilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspectsId")
    private Collection<AspectMemberships> aspectMembershipsCollection;

    public Aspects() {
    }

    public Aspects(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getContactsVisible() {
        return contactsVisible;
    }

    public void setContactsVisible(Boolean contactsVisible) {
        this.contactsVisible = contactsVisible;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Boolean getChatEnebled() {
        return chatEnebled;
    }

    public void setChatEnebled(Boolean chatEnebled) {
        this.chatEnebled = chatEnebled;
    }

    public Boolean getPostDefault() {
        return postDefault;
    }

    public void setPostDefault(Boolean postDefault) {
        this.postDefault = postDefault;
    }

    @XmlTransient
    public Collection<AspectVisibilities> getAspectVisibilitiesCollection() {
        return aspectVisibilitiesCollection;
    }

    public void setAspectVisibilitiesCollection(Collection<AspectVisibilities> aspectVisibilitiesCollection) {
        this.aspectVisibilitiesCollection = aspectVisibilitiesCollection;
    }

    @XmlTransient
    public Collection<AspectMemberships> getAspectMembershipsCollection() {
        return aspectMembershipsCollection;
    }

    public void setAspectMembershipsCollection(Collection<AspectMemberships> aspectMembershipsCollection) {
        this.aspectMembershipsCollection = aspectMembershipsCollection;
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
        if (!(object instanceof Aspects)) {
            return false;
        }
        Aspects other = (Aspects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Aspects[ id=" + id + " ]";
    }
    
}
