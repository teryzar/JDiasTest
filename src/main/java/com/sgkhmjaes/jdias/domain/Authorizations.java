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
@Table(name = "authorizations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authorizations.findAll", query = "SELECT a FROM Authorizations a")
    , @NamedQuery(name = "Authorizations.findById", query = "SELECT a FROM Authorizations a WHERE a.id = :id")
    , @NamedQuery(name = "Authorizations.findByRefreshToken", query = "SELECT a FROM Authorizations a WHERE a.refreshToken = :refreshToken")
    , @NamedQuery(name = "Authorizations.findByCode", query = "SELECT a FROM Authorizations a WHERE a.code = :code")
    , @NamedQuery(name = "Authorizations.findByRedirectUri", query = "SELECT a FROM Authorizations a WHERE a.redirectUri = :redirectUri")
    , @NamedQuery(name = "Authorizations.findByNonce", query = "SELECT a FROM Authorizations a WHERE a.nonce = :nonce")
    , @NamedQuery(name = "Authorizations.findByScopes", query = "SELECT a FROM Authorizations a WHERE a.scopes = :scopes")
    , @NamedQuery(name = "Authorizations.findByCodeUsed", query = "SELECT a FROM Authorizations a WHERE a.codeUsed = :codeUsed")
    , @NamedQuery(name = "Authorizations.findByCreatedAt", query = "SELECT a FROM Authorizations a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "Authorizations.findByUpdatedAt", query = "SELECT a FROM Authorizations a WHERE a.updatedAt = :updatedAt")})
public class Authorizations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "code")
    private String code;
    @Column(name = "redirect_uri")
    private String redirectUri;
    @Column(name = "nonce")
    private String nonce;
    @Column(name = "scopes")
    private String scopes;
    @Column(name = "code_used")
    private Boolean codeUsed;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "o_auth_applications_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OAuthApplications oAuthApplicationsId;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorizationsId")
    private Collection<OAuthAccessTokens> oAuthAccessTokensCollection;

    public Authorizations() {
    }

    public Authorizations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public Boolean getCodeUsed() {
        return codeUsed;
    }

    public void setCodeUsed(Boolean codeUsed) {
        this.codeUsed = codeUsed;
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

    public OAuthApplications getOAuthApplicationsId() {
        return oAuthApplicationsId;
    }

    public void setOAuthApplicationsId(OAuthApplications oAuthApplicationsId) {
        this.oAuthApplicationsId = oAuthApplicationsId;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @XmlTransient
    public Collection<OAuthAccessTokens> getOAuthAccessTokensCollection() {
        return oAuthAccessTokensCollection;
    }

    public void setOAuthAccessTokensCollection(Collection<OAuthAccessTokens> oAuthAccessTokensCollection) {
        this.oAuthAccessTokensCollection = oAuthAccessTokensCollection;
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
        if (!(object instanceof Authorizations)) {
            return false;
        }
        Authorizations other = (Authorizations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Authorizations[ id=" + id + " ]";
    }
    
}
