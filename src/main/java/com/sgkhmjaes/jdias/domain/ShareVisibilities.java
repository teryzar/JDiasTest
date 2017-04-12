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
@Table(name = "share_visibilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShareVisibilities.findAll", query = "SELECT s FROM ShareVisibilities s")
    , @NamedQuery(name = "ShareVisibilities.findById", query = "SELECT s FROM ShareVisibilities s WHERE s.id = :id")
    , @NamedQuery(name = "ShareVisibilities.findByShereableId", query = "SELECT s FROM ShareVisibilities s WHERE s.shereableId = :shereableId")
    , @NamedQuery(name = "ShareVisibilities.findByHidden", query = "SELECT s FROM ShareVisibilities s WHERE s.hidden = :hidden")
    , @NamedQuery(name = "ShareVisibilities.findByShereableType", query = "SELECT s FROM ShareVisibilities s WHERE s.shereableType = :shereableType")})
public class ShareVisibilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "shereable_id")
    private Integer shereableId;
    @Column(name = "hidden")
    private Boolean hidden;
    @Column(name = "shereable_type")
    private String shereableType;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;

    public ShareVisibilities() {
    }

    public ShareVisibilities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShereableId() {
        return shereableId;
    }

    public void setShereableId(Integer shereableId) {
        this.shereableId = shereableId;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getShereableType() {
        return shereableType;
    }

    public void setShereableType(String shereableType) {
        this.shereableType = shereableType;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
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
        if (!(object instanceof ShareVisibilities)) {
            return false;
        }
        ShareVisibilities other = (ShareVisibilities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ShareVisibilities[ id=" + id + " ]";
    }
    
}
