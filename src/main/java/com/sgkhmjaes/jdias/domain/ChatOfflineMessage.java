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
import javax.persistence.Lob;
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
@Table(name = "chat_offline_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatOfflineMessage.findAll", query = "SELECT c FROM ChatOfflineMessage c")
    , @NamedQuery(name = "ChatOfflineMessage.findById", query = "SELECT c FROM ChatOfflineMessage c WHERE c.id = :id")
    , @NamedQuery(name = "ChatOfflineMessage.findByFrom", query = "SELECT c FROM ChatOfflineMessage c WHERE c.from = :from")
    , @NamedQuery(name = "ChatOfflineMessage.findByTo", query = "SELECT c FROM ChatOfflineMessage c WHERE c.to = :to")
    , @NamedQuery(name = "ChatOfflineMessage.findByCreatedAt", query = "SELECT c FROM ChatOfflineMessage c WHERE c.createdAt = :createdAt")})
public class ChatOfflineMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "from")
    private String from;
    @Column(name = "to")
    private String to;
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public ChatOfflineMessage() {
    }

    public ChatOfflineMessage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof ChatOfflineMessage)) {
            return false;
        }
        ChatOfflineMessage other = (ChatOfflineMessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.ChatOfflineMessage[ id=" + id + " ]";
    }
    
}
