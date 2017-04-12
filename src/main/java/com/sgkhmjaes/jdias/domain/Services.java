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
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s")
    , @NamedQuery(name = "Services.findById", query = "SELECT s FROM Services s WHERE s.id = :id")
    , @NamedQuery(name = "Services.findByType", query = "SELECT s FROM Services s WHERE s.type = :type")
    , @NamedQuery(name = "Services.findByUid", query = "SELECT s FROM Services s WHERE s.uid = :uid")
    , @NamedQuery(name = "Services.findByAccessToken", query = "SELECT s FROM Services s WHERE s.accessToken = :accessToken")
    , @NamedQuery(name = "Services.findByAccessSecret", query = "SELECT s FROM Services s WHERE s.accessSecret = :accessSecret")
    , @NamedQuery(name = "Services.findByNickname", query = "SELECT s FROM Services s WHERE s.nickname = :nickname")
    , @NamedQuery(name = "Services.findByCreatedAt", query = "SELECT s FROM Services s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "Services.findByUpdatedAt", query = "SELECT s FROM Services s WHERE s.updatedAt = :updatedAt")})
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "uid")
    private String uid;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "access_secret")
    private String accessSecret;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;

    public Services() {
    }

    public Services(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
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
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Services[ id=" + id + " ]";
    }
    
}
