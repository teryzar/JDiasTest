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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "mentions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mentions.findAll", query = "SELECT m FROM Mentions m")
    , @NamedQuery(name = "Mentions.findById", query = "SELECT m FROM Mentions m WHERE m.id = :id")
    , @NamedQuery(name = "Mentions.findByPostId", query = "SELECT m FROM Mentions m WHERE m.postId = :postId")
    , @NamedQuery(name = "Mentions.findByPersonId", query = "SELECT m FROM Mentions m WHERE m.personId = :personId")})
public class Mentions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "person_id")
    private Integer personId;

    public Mentions() {
    }

    public Mentions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
        if (!(object instanceof Mentions)) {
            return false;
        }
        Mentions other = (Mentions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Mentions[ id=" + id + " ]";
    }
    
}
