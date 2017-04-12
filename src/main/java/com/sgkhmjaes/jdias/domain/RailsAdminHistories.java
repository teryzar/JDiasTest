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
@Table(name = "rails_admin_histories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RailsAdminHistories.findAll", query = "SELECT r FROM RailsAdminHistories r")
    , @NamedQuery(name = "RailsAdminHistories.findById", query = "SELECT r FROM RailsAdminHistories r WHERE r.id = :id")
    , @NamedQuery(name = "RailsAdminHistories.findByUsername", query = "SELECT r FROM RailsAdminHistories r WHERE r.username = :username")
    , @NamedQuery(name = "RailsAdminHistories.findByItem", query = "SELECT r FROM RailsAdminHistories r WHERE r.item = :item")
    , @NamedQuery(name = "RailsAdminHistories.findByTable", query = "SELECT r FROM RailsAdminHistories r WHERE r.table = :table")
    , @NamedQuery(name = "RailsAdminHistories.findByMonth", query = "SELECT r FROM RailsAdminHistories r WHERE r.month = :month")
    , @NamedQuery(name = "RailsAdminHistories.findByYear", query = "SELECT r FROM RailsAdminHistories r WHERE r.year = :year")
    , @NamedQuery(name = "RailsAdminHistories.findByCreatedAt", query = "SELECT r FROM RailsAdminHistories r WHERE r.createdAt = :createdAt")
    , @NamedQuery(name = "RailsAdminHistories.findByUpdatedAt", query = "SELECT r FROM RailsAdminHistories r WHERE r.updatedAt = :updatedAt")})
public class RailsAdminHistories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "username")
    private String username;
    @Column(name = "item")
    private Integer item;
    @Column(name = "table")
    private String table;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public RailsAdminHistories() {
    }

    public RailsAdminHistories(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        if (!(object instanceof RailsAdminHistories)) {
            return false;
        }
        RailsAdminHistories other = (RailsAdminHistories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.RailsAdminHistories[ id=" + id + " ]";
    }
    
}
