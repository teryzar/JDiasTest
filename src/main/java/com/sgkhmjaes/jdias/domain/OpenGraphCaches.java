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
@Table(name = "open_graph_caches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpenGraphCaches.findAll", query = "SELECT o FROM OpenGraphCaches o")
    , @NamedQuery(name = "OpenGraphCaches.findById", query = "SELECT o FROM OpenGraphCaches o WHERE o.id = :id")
    , @NamedQuery(name = "OpenGraphCaches.findByTitle", query = "SELECT o FROM OpenGraphCaches o WHERE o.title = :title")
    , @NamedQuery(name = "OpenGraphCaches.findByObType", query = "SELECT o FROM OpenGraphCaches o WHERE o.obType = :obType")})
public class OpenGraphCaches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "ob_type")
    private String obType;
    @Lob
    @Column(name = "image")
    private String image;
    @Lob
    @Column(name = "url")
    private String url;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "video_url")
    private String videoUrl;

    public OpenGraphCaches() {
    }

    public OpenGraphCaches(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObType() {
        return obType;
    }

    public void setObType(String obType) {
        this.obType = obType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
        if (!(object instanceof OpenGraphCaches)) {
            return false;
        }
        OpenGraphCaches other = (OpenGraphCaches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.OpenGraphCaches[ id=" + id + " ]";
    }
    
}
