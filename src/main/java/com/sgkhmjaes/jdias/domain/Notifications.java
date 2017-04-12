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
@Table(name = "notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n")
    , @NamedQuery(name = "Notifications.findById", query = "SELECT n FROM Notifications n WHERE n.id = :id")
    , @NamedQuery(name = "Notifications.findByTargetType", query = "SELECT n FROM Notifications n WHERE n.targetType = :targetType")
    , @NamedQuery(name = "Notifications.findByTargetId", query = "SELECT n FROM Notifications n WHERE n.targetId = :targetId")
    , @NamedQuery(name = "Notifications.findByRecipientId", query = "SELECT n FROM Notifications n WHERE n.recipientId = :recipientId")
    , @NamedQuery(name = "Notifications.findByUnread", query = "SELECT n FROM Notifications n WHERE n.unread = :unread")
    , @NamedQuery(name = "Notifications.findByCreatedAt", query = "SELECT n FROM Notifications n WHERE n.createdAt = :createdAt")
    , @NamedQuery(name = "Notifications.findByUpdatedAt", query = "SELECT n FROM Notifications n WHERE n.updatedAt = :updatedAt")
    , @NamedQuery(name = "Notifications.findByType", query = "SELECT n FROM Notifications n WHERE n.type = :type")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "target_type")
    private String targetType;
    @Column(name = "target_id")
    private Integer targetId;
    @Column(name = "recipient_id")
    private Integer recipientId;
    @Column(name = "unread")
    private Boolean unread;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationId")
    private Collection<NotificationActor> notificationActorCollection;

    public Notifications() {
    }

    public Notifications(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<NotificationActor> getNotificationActorCollection() {
        return notificationActorCollection;
    }

    public void setNotificationActorCollection(Collection<NotificationActor> notificationActorCollection) {
        this.notificationActorCollection = notificationActorCollection;
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
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Notifications[ id=" + id + " ]";
    }
    
}
