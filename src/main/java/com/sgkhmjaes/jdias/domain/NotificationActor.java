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
@Table(name = "notification_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationActor.findAll", query = "SELECT n FROM NotificationActor n")
    , @NamedQuery(name = "NotificationActor.findById", query = "SELECT n FROM NotificationActor n WHERE n.id = :id")
    , @NamedQuery(name = "NotificationActor.findByPersonId", query = "SELECT n FROM NotificationActor n WHERE n.personId = :personId")
    , @NamedQuery(name = "NotificationActor.findByCreatedAt", query = "SELECT n FROM NotificationActor n WHERE n.createdAt = :createdAt")
    , @NamedQuery(name = "NotificationActor.findByUpdatedAt", query = "SELECT n FROM NotificationActor n WHERE n.updatedAt = :updatedAt")})
public class NotificationActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Notifications notificationId;

    public NotificationActor() {
    }

    public NotificationActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    public Notifications getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Notifications notificationId) {
        this.notificationId = notificationId;
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
        if (!(object instanceof NotificationActor)) {
            return false;
        }
        NotificationActor other = (NotificationActor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.NotificationActor[ id=" + id + " ]";
    }
    
}
