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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "o_embed_caches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OEmbedCaches.findAll", query = "SELECT o FROM OEmbedCaches o")
    , @NamedQuery(name = "OEmbedCaches.findById", query = "SELECT o FROM OEmbedCaches o WHERE o.id = :id")
    , @NamedQuery(name = "OEmbedCaches.findByUrl", query = "SELECT o FROM OEmbedCaches o WHERE o.url = :url")})
public class OEmbedCaches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "url")
    private String url;
    @Lob
    @Column(name = "data")
    private String data;

    public OEmbedCaches() {
    }

    public OEmbedCaches(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        if (!(object instanceof OEmbedCaches)) {
            return false;
        }
        OEmbedCaches other = (OEmbedCaches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.OEmbedCaches[ id=" + id + " ]";
    }
    
}
