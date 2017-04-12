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
@Table(name = "participations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participations.findAll", query = "SELECT p FROM Participations p")
    , @NamedQuery(name = "Participations.findById", query = "SELECT p FROM Participations p WHERE p.id = :id")
    , @NamedQuery(name = "Participations.findByGuid", query = "SELECT p FROM Participations p WHERE p.guid = :guid")
    , @NamedQuery(name = "Participations.findByTargetId", query = "SELECT p FROM Participations p WHERE p.targetId = :targetId")
    , @NamedQuery(name = "Participations.findByTargetType", query = "SELECT p FROM Participations p WHERE p.targetType = :targetType")
    , @NamedQuery(name = "Participations.findByAuthorId", query = "SELECT p FROM Participations p WHERE p.authorId = :authorId")
    , @NamedQuery(name = "Participations.findByCreatedAt", query = "SELECT p FROM Participations p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Participations.findByUpdatedAt", query = "SELECT p FROM Participations p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Participations.findByCount", query = "SELECT p FROM Participations p WHERE p.count = :count")})
public class Participations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "guid")
    private String guid;
    @Column(name = "target_id")
    private Integer targetId;
    @Column(name = "target_type")
    private String targetType;
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "count")
    private Integer count;

    public Participations() {
    }

    public Participations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        if (!(object instanceof Participations)) {
            return false;
        }
        Participations other = (Participations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Participations[ id=" + id + " ]";
    }
    
}
