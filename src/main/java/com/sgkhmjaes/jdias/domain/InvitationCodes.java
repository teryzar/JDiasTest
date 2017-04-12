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
@Table(name = "invitation_codes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvitationCodes.findAll", query = "SELECT i FROM InvitationCodes i")
    , @NamedQuery(name = "InvitationCodes.findById", query = "SELECT i FROM InvitationCodes i WHERE i.id = :id")
    , @NamedQuery(name = "InvitationCodes.findByToken", query = "SELECT i FROM InvitationCodes i WHERE i.token = :token")
    , @NamedQuery(name = "InvitationCodes.findByUserId", query = "SELECT i FROM InvitationCodes i WHERE i.userId = :userId")
    , @NamedQuery(name = "InvitationCodes.findByCount", query = "SELECT i FROM InvitationCodes i WHERE i.count = :count")
    , @NamedQuery(name = "InvitationCodes.findByCreatedAt", query = "SELECT i FROM InvitationCodes i WHERE i.createdAt = :createdAt")
    , @NamedQuery(name = "InvitationCodes.findByUpdatedAt", query = "SELECT i FROM InvitationCodes i WHERE i.updatedAt = :updatedAt")})
public class InvitationCodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "count")
    private Integer count;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public InvitationCodes() {
    }

    public InvitationCodes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        if (!(object instanceof InvitationCodes)) {
            return false;
        }
        InvitationCodes other = (InvitationCodes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.InvitationCodes[ id=" + id + " ]";
    }
    
}
