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
@Table(name = "account_deletions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDeletions.findAll", query = "SELECT a FROM AccountDeletions a")
    , @NamedQuery(name = "AccountDeletions.findById", query = "SELECT a FROM AccountDeletions a WHERE a.id = :id")
    , @NamedQuery(name = "AccountDeletions.findByDiasporaHendle", query = "SELECT a FROM AccountDeletions a WHERE a.diasporaHendle = :diasporaHendle")
    , @NamedQuery(name = "AccountDeletions.findByPersonId", query = "SELECT a FROM AccountDeletions a WHERE a.personId = :personId")
    , @NamedQuery(name = "AccountDeletions.findByCompletedAt", query = "SELECT a FROM AccountDeletions a WHERE a.completedAt = :completedAt")})
public class AccountDeletions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diaspora_hendle")
    private String diasporaHendle;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "completed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    public AccountDeletions() {
    }

    public AccountDeletions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiasporaHendle() {
        return diasporaHendle;
    }

    public void setDiasporaHendle(String diasporaHendle) {
        this.diasporaHendle = diasporaHendle;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
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
        if (!(object instanceof AccountDeletions)) {
            return false;
        }
        AccountDeletions other = (AccountDeletions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.AccountDeletions[ id=" + id + " ]";
    }
    
}
