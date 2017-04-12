/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbModels;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "conversations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversations.findAll", query = "SELECT c FROM Conversations c")
    , @NamedQuery(name = "Conversations.findById", query = "SELECT c FROM Conversations c WHERE c.id = :id")
    , @NamedQuery(name = "Conversations.findBySubject", query = "SELECT c FROM Conversations c WHERE c.subject = :subject")
    , @NamedQuery(name = "Conversations.findByGuid", query = "SELECT c FROM Conversations c WHERE c.guid = :guid")
    , @NamedQuery(name = "Conversations.findByCreatedAt", query = "SELECT c FROM Conversations c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Conversations.findByUpdatedAt", query = "SELECT c FROM Conversations c WHERE c.updatedAt = :updatedAt")})
public class Conversations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "guid")
    private String guid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversationsId")
    private Collection<ConversationVisabilities> conversationVisabilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversationsId")
    private Collection<Messages> messagesCollection;
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People peopleId;

    public Conversations() {
    }

    public Conversations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    @XmlTransient
    public Collection<ConversationVisabilities> getConversationVisabilitiesCollection() {
        return conversationVisabilitiesCollection;
    }

    public void setConversationVisabilitiesCollection(Collection<ConversationVisabilities> conversationVisabilitiesCollection) {
        this.conversationVisabilitiesCollection = conversationVisabilitiesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
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
        if (!(object instanceof Conversations)) {
            return false;
        }
        Conversations other = (Conversations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Conversations[ id=" + id + " ]";
    }
    
}
