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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "conversation_visabilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConversationVisabilities.findAll", query = "SELECT c FROM ConversationVisabilities c")
    , @NamedQuery(name = "ConversationVisabilities.findById", query = "SELECT c FROM ConversationVisabilities c WHERE c.id = :id")
    , @NamedQuery(name = "ConversationVisabilities.findByUnread", query = "SELECT c FROM ConversationVisabilities c WHERE c.unread = :unread")
    , @NamedQuery(name = "ConversationVisabilities.findByCreatedAt", query = "SELECT c FROM ConversationVisabilities c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "ConversationVisabilities.findByUpdatedAt", query = "SELECT c FROM ConversationVisabilities c WHERE c.updatedAt = :updatedAt")})
public class ConversationVisabilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "unread")
    private Integer unread;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "conversations_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conversations conversationsId;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People personId;

    public ConversationVisabilities() {
    }

    public ConversationVisabilities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
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

    public Conversations getConversationsId() {
        return conversationsId;
    }

    public void setConversationsId(Conversations conversationsId) {
        this.conversationsId = conversationsId;
    }

    public People getPersonId() {
        return personId;
    }

    public void setPersonId(People personId) {
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
        if (!(object instanceof ConversationVisabilities)) {
            return false;
        }
        ConversationVisabilities other = (ConversationVisabilities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ConversationVisabilities[ id=" + id + " ]";
    }
    
}
