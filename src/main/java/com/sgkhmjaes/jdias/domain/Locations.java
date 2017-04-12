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
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id")
    , @NamedQuery(name = "Locations.findByAddress", query = "SELECT l FROM Locations l WHERE l.address = :address")
    , @NamedQuery(name = "Locations.findByLat", query = "SELECT l FROM Locations l WHERE l.lat = :lat")
    , @NamedQuery(name = "Locations.findByLng", query = "SELECT l FROM Locations l WHERE l.lng = :lng")
    , @NamedQuery(name = "Locations.findByStatusMessageId", query = "SELECT l FROM Locations l WHERE l.statusMessageId = :statusMessageId")
    , @NamedQuery(name = "Locations.findByCreates", query = "SELECT l FROM Locations l WHERE l.creates = :creates")
    , @NamedQuery(name = "Locations.findByUpdatedAt", query = "SELECT l FROM Locations l WHERE l.updatedAt = :updatedAt")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "address")
    private String address;
    @Column(name = "lat")
    private String lat;
    @Column(name = "lng")
    private String lng;
    @Column(name = "status_message_id")
    private Integer statusMessageId;
    @Column(name = "creates")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creates;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Locations() {
    }

    public Locations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getStatusMessageId() {
        return statusMessageId;
    }

    public void setStatusMessageId(Integer statusMessageId) {
        this.statusMessageId = statusMessageId;
    }

    public Date getCreates() {
        return creates;
    }

    public void setCreates(Date creates) {
        this.creates = creates;
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
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Locations[ id=" + id + " ]";
    }
    
}
