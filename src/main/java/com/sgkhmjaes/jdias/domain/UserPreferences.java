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
@Table(name = "user_preferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPreferences.findAll", query = "SELECT u FROM UserPreferences u")
    , @NamedQuery(name = "UserPreferences.findById", query = "SELECT u FROM UserPreferences u WHERE u.id = :id")
    , @NamedQuery(name = "UserPreferences.findByEmailType", query = "SELECT u FROM UserPreferences u WHERE u.emailType = :emailType")
    , @NamedQuery(name = "UserPreferences.findByUserId", query = "SELECT u FROM UserPreferences u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserPreferences.findByCreatedAt", query = "SELECT u FROM UserPreferences u WHERE u.createdAt = :createdAt")
    , @NamedQuery(name = "UserPreferences.findByUpdatedAt", query = "SELECT u FROM UserPreferences u WHERE u.updatedAt = :updatedAt")})
public class UserPreferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email_type")
    private String emailType;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public UserPreferences() {
    }

    public UserPreferences(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPreferences)) {
            return false;
        }
        UserPreferences other = (UserPreferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.UserPreferences[ id=" + id + " ]";
    }
    
}
