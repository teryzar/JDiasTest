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
import javax.persistence.Lob;
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
@Table(name = "ar_internal_metadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArInternalMetadata.findAll", query = "SELECT a FROM ArInternalMetadata a")
    , @NamedQuery(name = "ArInternalMetadata.findByCreatedAt", query = "SELECT a FROM ArInternalMetadata a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "ArInternalMetadata.findByUpdatedAt", query = "SELECT a FROM ArInternalMetadata a WHERE a.updatedAt = :updatedAt")
    , @NamedQuery(name = "ArInternalMetadata.findById", query = "SELECT a FROM ArInternalMetadata a WHERE a.id = :id")})
public class ArInternalMetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "key")
    private String key;
    @Lob
    @Column(name = "value")
    private String value;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public ArInternalMetadata() {
    }

    public ArInternalMetadata(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof ArInternalMetadata)) {
            return false;
        }
        ArInternalMetadata other = (ArInternalMetadata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ArInternalMetadata[ id=" + id + " ]";
    }
    
}
