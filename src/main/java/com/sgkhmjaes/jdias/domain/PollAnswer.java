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
@Table(name = "poll_answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PollAnswer.findAll", query = "SELECT p FROM PollAnswer p")
    , @NamedQuery(name = "PollAnswer.findById", query = "SELECT p FROM PollAnswer p WHERE p.id = :id")
    , @NamedQuery(name = "PollAnswer.findByAnswer", query = "SELECT p FROM PollAnswer p WHERE p.answer = :answer")
    , @NamedQuery(name = "PollAnswer.findByPollId", query = "SELECT p FROM PollAnswer p WHERE p.pollId = :pollId")
    , @NamedQuery(name = "PollAnswer.findByGuid", query = "SELECT p FROM PollAnswer p WHERE p.guid = :guid")
    , @NamedQuery(name = "PollAnswer.findByVoteCount", query = "SELECT p FROM PollAnswer p WHERE p.voteCount = :voteCount")})
public class PollAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "answer")
    private String answer;
    @Column(name = "poll_id")
    private Integer pollId;
    @Column(name = "guid")
    private String guid;
    @Column(name = "vote_count")
    private Integer voteCount;

    public PollAnswer() {
    }

    public PollAnswer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
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
        if (!(object instanceof PollAnswer)) {
            return false;
        }
        PollAnswer other = (PollAnswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.PollAnswer[ id=" + id + " ]";
    }
    
}
