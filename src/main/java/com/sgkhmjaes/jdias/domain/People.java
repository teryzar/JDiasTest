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
import javax.persistence.Lob;
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
@Table(name = "people")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id")
    , @NamedQuery(name = "People.findByGuide", query = "SELECT p FROM People p WHERE p.guide = :guide")
    , @NamedQuery(name = "People.findByDiasporaHandle", query = "SELECT p FROM People p WHERE p.diasporaHandle = :diasporaHandle")
    , @NamedQuery(name = "People.findByOwnerId", query = "SELECT p FROM People p WHERE p.ownerId = :ownerId")
    , @NamedQuery(name = "People.findByCreatedAt", query = "SELECT p FROM People p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "People.findByUpdatedAt", query = "SELECT p FROM People p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "People.findByClosedAccount", query = "SELECT p FROM People p WHERE p.closedAccount = :closedAccount")
    , @NamedQuery(name = "People.findByFetchStatus", query = "SELECT p FROM People p WHERE p.fetchStatus = :fetchStatus")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "guide")
    private String guide;
    @Column(name = "diaspora_handle")
    private String diasporaHandle;
    @Lob
    @Column(name = "serialized_public_key")
    private String serializedPublicKey;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "closed_account")
    private Boolean closedAccount;
    @Column(name = "fetch_status")
    private Integer fetchStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<Posts> postsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<ConversationVisabilities> conversationVisabilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<Likes> likesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Profiles> profilesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peopleId")
    private Collection<Messages> messagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peopleId")
    private Collection<Conversations> conversationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<Comments> commentsCollection;
    @JoinColumn(name = "pods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pods podsId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peopleId")
    private Collection<Contacts> contactsCollection;

    public People() {
    }

    public People(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getDiasporaHandle() {
        return diasporaHandle;
    }

    public void setDiasporaHandle(String diasporaHandle) {
        this.diasporaHandle = diasporaHandle;
    }

    public String getSerializedPublicKey() {
        return serializedPublicKey;
    }

    public void setSerializedPublicKey(String serializedPublicKey) {
        this.serializedPublicKey = serializedPublicKey;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    public Boolean getClosedAccount() {
        return closedAccount;
    }

    public void setClosedAccount(Boolean closedAccount) {
        this.closedAccount = closedAccount;
    }

    public Integer getFetchStatus() {
        return fetchStatus;
    }

    public void setFetchStatus(Integer fetchStatus) {
        this.fetchStatus = fetchStatus;
    }

    @XmlTransient
    public Collection<Posts> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Posts> postsCollection) {
        this.postsCollection = postsCollection;
    }

    @XmlTransient
    public Collection<ConversationVisabilities> getConversationVisabilitiesCollection() {
        return conversationVisabilitiesCollection;
    }

    public void setConversationVisabilitiesCollection(Collection<ConversationVisabilities> conversationVisabilitiesCollection) {
        this.conversationVisabilitiesCollection = conversationVisabilitiesCollection;
    }

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }

    @XmlTransient
    public Collection<Profiles> getProfilesCollection() {
        return profilesCollection;
    }

    public void setProfilesCollection(Collection<Profiles> profilesCollection) {
        this.profilesCollection = profilesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    @XmlTransient
    public Collection<Conversations> getConversationsCollection() {
        return conversationsCollection;
    }

    public void setConversationsCollection(Collection<Conversations> conversationsCollection) {
        this.conversationsCollection = conversationsCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public Pods getPodsId() {
        return podsId;
    }

    public void setPodsId(Pods podsId) {
        this.podsId = podsId;
    }

    @XmlTransient
    public Collection<Contacts> getContactsCollection() {
        return contactsCollection;
    }

    public void setContactsCollection(Collection<Contacts> contactsCollection) {
        this.contactsCollection = contactsCollection;
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
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.People[ id=" + id + " ]";
    }
    
}
