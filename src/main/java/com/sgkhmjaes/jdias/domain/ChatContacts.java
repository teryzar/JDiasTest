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
@Table(name = "chat_contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatContacts.findAll", query = "SELECT c FROM ChatContacts c")
    , @NamedQuery(name = "ChatContacts.findById", query = "SELECT c FROM ChatContacts c WHERE c.id = :id")
    , @NamedQuery(name = "ChatContacts.findByUserId", query = "SELECT c FROM ChatContacts c WHERE c.userId = :userId")
    , @NamedQuery(name = "ChatContacts.findByJid", query = "SELECT c FROM ChatContacts c WHERE c.jid = :jid")
    , @NamedQuery(name = "ChatContacts.findByName", query = "SELECT c FROM ChatContacts c WHERE c.name = :name")
    , @NamedQuery(name = "ChatContacts.findByAsk", query = "SELECT c FROM ChatContacts c WHERE c.ask = :ask")
    , @NamedQuery(name = "ChatContacts.findBySubscription", query = "SELECT c FROM ChatContacts c WHERE c.subscription = :subscription")})
public class ChatContacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "jid")
    private String jid;
    @Column(name = "name")
    private String name;
    @Column(name = "ask")
    private String ask;
    @Column(name = "subscription")
    private String subscription;

    public ChatContacts() {
    }

    public ChatContacts(Integer id) {
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

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
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
        if (!(object instanceof ChatContacts)) {
            return false;
        }
        ChatContacts other = (ChatContacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ChatContacts[ id=" + id + " ]";
    }
    
}
