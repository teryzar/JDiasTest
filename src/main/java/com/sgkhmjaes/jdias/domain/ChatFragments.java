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
@Table(name = "chat_fragments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatFragments.findAll", query = "SELECT c FROM ChatFragments c")
    , @NamedQuery(name = "ChatFragments.findById", query = "SELECT c FROM ChatFragments c WHERE c.id = :id")
    , @NamedQuery(name = "ChatFragments.findByUserId", query = "SELECT c FROM ChatFragments c WHERE c.userId = :userId")
    , @NamedQuery(name = "ChatFragments.findByRoot", query = "SELECT c FROM ChatFragments c WHERE c.root = :root")
    , @NamedQuery(name = "ChatFragments.findByNamespace", query = "SELECT c FROM ChatFragments c WHERE c.namespace = :namespace")})
public class ChatFragments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "root")
    private String root;
    @Column(name = "namespace")
    private String namespace;
    @Lob
    @Column(name = "xml")
    private String xml;

    public ChatFragments() {
    }

    public ChatFragments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
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
        if (!(object instanceof ChatFragments)) {
            return false;
        }
        ChatFragments other = (ChatFragments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ChatFragments[ id=" + id + " ]";
    }
    
}
