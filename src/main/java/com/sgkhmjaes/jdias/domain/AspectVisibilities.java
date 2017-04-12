/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "aspect_visibilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AspectVisibilities.findAll", query = "SELECT a FROM AspectVisibilities a")
    , @NamedQuery(name = "AspectVisibilities.findById", query = "SELECT a FROM AspectVisibilities a WHERE a.id = :id")
    , @NamedQuery(name = "AspectVisibilities.findByShareableId", query = "SELECT a FROM AspectVisibilities a WHERE a.shareableId = :shareableId")
    , @NamedQuery(name = "AspectVisibilities.findByShareableType", query = "SELECT a FROM AspectVisibilities a WHERE a.shareableType = :shareableType")})
public class AspectVisibilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "shareable_id")
    private Integer shareableId;
    @Column(name = "shareable_type")
    private String shareableType;
    @JoinColumn(name = "aspect_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aspects aspectId;

    public AspectVisibilities() {
    }

    public AspectVisibilities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareableId() {
        return shareableId;
    }

    public void setShareableId(Integer shareableId) {
        this.shareableId = shareableId;
    }

    public String getShareableType() {
        return shareableType;
    }

    public void setShareableType(String shareableType) {
        this.shareableType = shareableType;
    }

    public Aspects getAspectId() {
        return aspectId;
    }

    public void setAspectId(Aspects aspectId) {
        this.aspectId = aspectId;
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
        if (!(object instanceof AspectVisibilities)) {
            return false;
        }
        AspectVisibilities other = (AspectVisibilities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.AspectVisibilities[ id=" + id + " ]";
    }
    
}
