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
@Table(name = "simple_captcha_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimpleCaptchaData.findAll", query = "SELECT s FROM SimpleCaptchaData s")
    , @NamedQuery(name = "SimpleCaptchaData.findById", query = "SELECT s FROM SimpleCaptchaData s WHERE s.id = :id")
    , @NamedQuery(name = "SimpleCaptchaData.findByKey", query = "SELECT s FROM SimpleCaptchaData s WHERE s.key = :key")
    , @NamedQuery(name = "SimpleCaptchaData.findByValue", query = "SELECT s FROM SimpleCaptchaData s WHERE s.value = :value")
    , @NamedQuery(name = "SimpleCaptchaData.findByCreatedAt", query = "SELECT s FROM SimpleCaptchaData s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "SimpleCaptchaData.findByUpdatedAt", query = "SELECT s FROM SimpleCaptchaData s WHERE s.updatedAt = :updatedAt")})
public class SimpleCaptchaData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "key")
    private String key;
    @Column(name = "value")
    private String value;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public SimpleCaptchaData() {
    }

    public SimpleCaptchaData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SimpleCaptchaData)) {
            return false;
        }
        SimpleCaptchaData other = (SimpleCaptchaData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.SimpleCaptchaData[ id=" + id + " ]";
    }
    
}
