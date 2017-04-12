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
import javax.persistence.Lob;
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
@Table(name = "posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p")
    , @NamedQuery(name = "Posts.findById", query = "SELECT p FROM Posts p WHERE p.id = :id")
    , @NamedQuery(name = "Posts.findByPublics", query = "SELECT p FROM Posts p WHERE p.publics = :publics")
    , @NamedQuery(name = "Posts.findByGuid", query = "SELECT p FROM Posts p WHERE p.guid = :guid")
    , @NamedQuery(name = "Posts.findByType", query = "SELECT p FROM Posts p WHERE p.type = :type")
    , @NamedQuery(name = "Posts.findByCreatedAt", query = "SELECT p FROM Posts p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Posts.findByUpdatedAt", query = "SELECT p FROM Posts p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Posts.findByProviderDisplayName", query = "SELECT p FROM Posts p WHERE p.providerDisplayName = :providerDisplayName")
    , @NamedQuery(name = "Posts.findByRootGuid", query = "SELECT p FROM Posts p WHERE p.rootGuid = :rootGuid")
    , @NamedQuery(name = "Posts.findByLikesCount", query = "SELECT p FROM Posts p WHERE p.likesCount = :likesCount")
    , @NamedQuery(name = "Posts.findByCommentsCount", query = "SELECT p FROM Posts p WHERE p.commentsCount = :commentsCount")
    , @NamedQuery(name = "Posts.findByOEmbedCacheId", query = "SELECT p FROM Posts p WHERE p.oEmbedCacheId = :oEmbedCacheId")
    , @NamedQuery(name = "Posts.findByResharesCount", query = "SELECT p FROM Posts p WHERE p.resharesCount = :resharesCount")
    , @NamedQuery(name = "Posts.findByInteractedAt", query = "SELECT p FROM Posts p WHERE p.interactedAt = :interactedAt")
    , @NamedQuery(name = "Posts.findByFacebookId", query = "SELECT p FROM Posts p WHERE p.facebookId = :facebookId")
    , @NamedQuery(name = "Posts.findByTweetId", query = "SELECT p FROM Posts p WHERE p.tweetId = :tweetId")
    , @NamedQuery(name = "Posts.findByOpenGraphCacheId", query = "SELECT p FROM Posts p WHERE p.openGraphCacheId = :openGraphCacheId")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "publics")
    private Boolean publics;
    @Column(name = "guid")
    private String guid;
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "text")
    private String text;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "provider_display_name")
    private String providerDisplayName;
    @Column(name = "root_guid")
    private String rootGuid;
    @Column(name = "likes_count")
    private Integer likesCount;
    @Column(name = "comments_count")
    private Integer commentsCount;
    @Column(name = "o_embed_cache_id")
    private Integer oEmbedCacheId;
    @Column(name = "reshares_count")
    private Integer resharesCount;
    @Column(name = "interacted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interactedAt;
    @Column(name = "facebook_id")
    private String facebookId;
    @Column(name = "tweet_id")
    private String tweetId;
    @Column(name = "open_graph_cache_id")
    private Integer openGraphCacheId;
    @Lob
    @Column(name = "tumblr_ids")
    private String tumblrIds;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People authorId;

    public Posts() {
    }

    public Posts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPublics() {
        return publics;
    }

    public void setPublics(Boolean publics) {
        this.publics = publics;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        this.providerDisplayName = providerDisplayName;
    }

    public String getRootGuid() {
        return rootGuid;
    }

    public void setRootGuid(String rootGuid) {
        this.rootGuid = rootGuid;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getOEmbedCacheId() {
        return oEmbedCacheId;
    }

    public void setOEmbedCacheId(Integer oEmbedCacheId) {
        this.oEmbedCacheId = oEmbedCacheId;
    }

    public Integer getResharesCount() {
        return resharesCount;
    }

    public void setResharesCount(Integer resharesCount) {
        this.resharesCount = resharesCount;
    }

    public Date getInteractedAt() {
        return interactedAt;
    }

    public void setInteractedAt(Date interactedAt) {
        this.interactedAt = interactedAt;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public Integer getOpenGraphCacheId() {
        return openGraphCacheId;
    }

    public void setOpenGraphCacheId(Integer openGraphCacheId) {
        this.openGraphCacheId = openGraphCacheId;
    }

    public String getTumblrIds() {
        return tumblrIds;
    }

    public void setTumblrIds(String tumblrIds) {
        this.tumblrIds = tumblrIds;
    }

    public People getAuthorId() {
        return authorId;
    }

    public void setAuthorId(People authorId) {
        this.authorId = authorId;
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
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Posts[ id=" + id + " ]";
    }
    
}
