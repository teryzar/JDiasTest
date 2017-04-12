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
@Table(name = "polls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polls.findAll", query = "SELECT p FROM Polls p")
    , @NamedQuery(name = "Polls.findById", query = "SELECT p FROM Polls p WHERE p.id = :id")
    , @NamedQuery(name = "Polls.findByQuestion", query = "SELECT p FROM Polls p WHERE p.question = :question")
    , @NamedQuery(name = "Polls.findByStatusMessageId", query = "SELECT p FROM Polls p WHERE p.statusMessageId = :statusMessageId")
    , @NamedQuery(name = "Polls.findByStatus", query = "SELECT p FROM Polls p WHERE p.status = :status")
    , @NamedQuery(name = "Polls.findByGuid", query = "SELECT p FROM Polls p WHERE p.guid = :guid")
    , @NamedQuery(name = "Polls.findByCreatedAt", query = "SELECT p FROM Polls p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Polls.findByUpdatedAt", query = "SELECT p FROM Polls p WHERE p.updatedAt = :updatedAt")})
public class Polls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "question")
    private String question;
    @Column(name = "status_message_id")
    private Integer statusMessageId;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "guid")
    private String guid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Polls() {
    }

    public Polls(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getStatusMessageId() {
        return statusMessageId;
    }

    public void setStatusMessageId(Integer statusMessageId) {
        this.statusMessageId = statusMessageId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polls)) {
            return false;
        }
        Polls other = (Polls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Polls[ id=" + id + " ]";
    }
    
}
