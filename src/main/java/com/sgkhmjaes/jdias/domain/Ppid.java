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
@Table(name = "ppid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ppid.findAll", query = "SELECT p FROM Ppid p")
    , @NamedQuery(name = "Ppid.findById", query = "SELECT p FROM Ppid p WHERE p.id = :id")
    , @NamedQuery(name = "Ppid.findByGuid", query = "SELECT p FROM Ppid p WHERE p.guid = :guid")
    , @NamedQuery(name = "Ppid.findByString", query = "SELECT p FROM Ppid p WHERE p.string = :string")
    , @NamedQuery(name = "Ppid.findByIdentifier", query = "SELECT p FROM Ppid p WHERE p.identifier = :identifier")})
public class Ppid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "guid")
    private String guid;
    @Column(name = "string")
    private String string;
    @Column(name = "identifier")
    private String identifier;
    @JoinColumn(name = "o_auth_applications_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OAuthApplications oAuthApplicationsId;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;

    public Ppid() {
    }

    public Ppid(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public OAuthApplications getOAuthApplicationsId() {
        return oAuthApplicationsId;
    }

    public void setOAuthApplicationsId(OAuthApplications oAuthApplicationsId) {
        this.oAuthApplicationsId = oAuthApplicationsId;
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
        if (!(object instanceof Ppid)) {
            return false;
        }
        Ppid other = (Ppid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Ppid[ id=" + id + " ]";
    }
    
}
