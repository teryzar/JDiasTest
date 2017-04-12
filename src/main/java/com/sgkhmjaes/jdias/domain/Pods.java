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
@Table(name = "pods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pods.findAll", query = "SELECT p FROM Pods p")
    , @NamedQuery(name = "Pods.findById", query = "SELECT p FROM Pods p WHERE p.id = :id")
    , @NamedQuery(name = "Pods.findByHost", query = "SELECT p FROM Pods p WHERE p.host = :host")
    , @NamedQuery(name = "Pods.findBySsl", query = "SELECT p FROM Pods p WHERE p.ssl = :ssl")
    , @NamedQuery(name = "Pods.findByCreatedAt", query = "SELECT p FROM Pods p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Pods.findByUpdatedAt", query = "SELECT p FROM Pods p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Pods.findByStatus", query = "SELECT p FROM Pods p WHERE p.status = :status")
    , @NamedQuery(name = "Pods.findByCheckedAt", query = "SELECT p FROM Pods p WHERE p.checkedAt = :checkedAt")
    , @NamedQuery(name = "Pods.findByOfflineSince", query = "SELECT p FROM Pods p WHERE p.offlineSince = :offlineSince")
    , @NamedQuery(name = "Pods.findByResponseTime", query = "SELECT p FROM Pods p WHERE p.responseTime = :responseTime")
    , @NamedQuery(name = "Pods.findBySoftware", query = "SELECT p FROM Pods p WHERE p.software = :software")
    , @NamedQuery(name = "Pods.findByError", query = "SELECT p FROM Pods p WHERE p.error = :error")
    , @NamedQuery(name = "Pods.findByPort", query = "SELECT p FROM Pods p WHERE p.port = :port")
    , @NamedQuery(name = "Pods.findByBlocked", query = "SELECT p FROM Pods p WHERE p.blocked = :blocked")
    , @NamedQuery(name = "Pods.findByScheduledCheck", query = "SELECT p FROM Pods p WHERE p.scheduledCheck = :scheduledCheck")})
public class Pods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "host")
    private String host;
    @Column(name = "ssl")
    private Boolean ssl;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "status")
    private Integer status;
    @Column(name = "checked_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedAt;
    @Column(name = "offline_since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date offlineSince;
    @Column(name = "response_time")
    private Integer responseTime;
    @Column(name = "software")
    private String software;
    @Column(name = "error")
    private String error;
    @Column(name = "port")
    private Integer port;
    @Column(name = "blocked")
    private Boolean blocked;
    @Column(name = "scheduled_check")
    private Boolean scheduledCheck;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "podsId")
    private Collection<People> peopleCollection;

    public Pods() {
    }

    public Pods(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Date checkedAt) {
        this.checkedAt = checkedAt;
    }

    public Date getOfflineSince() {
        return offlineSince;
    }

    public void setOfflineSince(Date offlineSince) {
        this.offlineSince = offlineSince;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getScheduledCheck() {
        return scheduledCheck;
    }

    public void setScheduledCheck(Boolean scheduledCheck) {
        this.scheduledCheck = scheduledCheck;
    }

    @XmlTransient
    public Collection<People> getPeopleCollection() {
        return peopleCollection;
    }

    public void setPeopleCollection(Collection<People> peopleCollection) {
        this.peopleCollection = peopleCollection;
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
        if (!(object instanceof Pods)) {
            return false;
        }
        Pods other = (Pods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Pods[ id=" + id + " ]";
    }
    
}
