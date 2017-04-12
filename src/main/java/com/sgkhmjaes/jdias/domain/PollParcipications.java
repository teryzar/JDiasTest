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
@Table(name = "poll_parcipications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PollParcipications.findAll", query = "SELECT p FROM PollParcipications p")
    , @NamedQuery(name = "PollParcipications.findById", query = "SELECT p FROM PollParcipications p WHERE p.id = :id")
    , @NamedQuery(name = "PollParcipications.findByPollAnserId", query = "SELECT p FROM PollParcipications p WHERE p.pollAnserId = :pollAnserId")
    , @NamedQuery(name = "PollParcipications.findByAuthorId", query = "SELECT p FROM PollParcipications p WHERE p.authorId = :authorId")
    , @NamedQuery(name = "PollParcipications.findByPollId", query = "SELECT p FROM PollParcipications p WHERE p.pollId = :pollId")
    , @NamedQuery(name = "PollParcipications.findByGuid", query = "SELECT p FROM PollParcipications p WHERE p.guid = :guid")
    , @NamedQuery(name = "PollParcipications.findByCreatedAt", query = "SELECT p FROM PollParcipications p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "PollParcipications.findByUpdatedAt", query = "SELECT p FROM PollParcipications p WHERE p.updatedAt = :updatedAt")})
public class PollParcipications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "poll_anser_id")
    private Integer pollAnserId;
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "poll_id")
    private Integer pollId;
    @Column(name = "guid")
    private String guid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pollParcipicationsId")
    private Collection<PoleParticipationSignatures> poleParticipationSignaturesCollection;

    public PollParcipications() {
    }

    public PollParcipications(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPollAnserId() {
        return pollAnserId;
    }

    public void setPollAnserId(Integer pollAnserId) {
        this.pollAnserId = pollAnserId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
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
    public Collection<PoleParticipationSignatures> getPoleParticipationSignaturesCollection() {
        return poleParticipationSignaturesCollection;
    }

    public void setPoleParticipationSignaturesCollection(Collection<PoleParticipationSignatures> poleParticipationSignaturesCollection) {
        this.poleParticipationSignaturesCollection = poleParticipationSignaturesCollection;
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
        if (!(object instanceof PollParcipications)) {
            return false;
        }
        PollParcipications other = (PollParcipications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.PollParcipications[ id=" + id + " ]";
    }
    
}
