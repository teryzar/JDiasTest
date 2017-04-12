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
@Table(name = "o_auth_applications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OAuthApplications.findAll", query = "SELECT o FROM OAuthApplications o")
    , @NamedQuery(name = "OAuthApplications.findById", query = "SELECT o FROM OAuthApplications o WHERE o.id = :id")
    , @NamedQuery(name = "OAuthApplications.findByClientId", query = "SELECT o FROM OAuthApplications o WHERE o.clientId = :clientId")
    , @NamedQuery(name = "OAuthApplications.findByClientSecret", query = "SELECT o FROM OAuthApplications o WHERE o.clientSecret = :clientSecret")
    , @NamedQuery(name = "OAuthApplications.findByResponseTypes", query = "SELECT o FROM OAuthApplications o WHERE o.responseTypes = :responseTypes")
    , @NamedQuery(name = "OAuthApplications.findByGrandTypes", query = "SELECT o FROM OAuthApplications o WHERE o.grandTypes = :grandTypes")
    , @NamedQuery(name = "OAuthApplications.findByApplicationType", query = "SELECT o FROM OAuthApplications o WHERE o.applicationType = :applicationType")
    , @NamedQuery(name = "OAuthApplications.findByContacts", query = "SELECT o FROM OAuthApplications o WHERE o.contacts = :contacts")
    , @NamedQuery(name = "OAuthApplications.findByLogoUri", query = "SELECT o FROM OAuthApplications o WHERE o.logoUri = :logoUri")
    , @NamedQuery(name = "OAuthApplications.findByClientUri", query = "SELECT o FROM OAuthApplications o WHERE o.clientUri = :clientUri")
    , @NamedQuery(name = "OAuthApplications.findByPolicyUri", query = "SELECT o FROM OAuthApplications o WHERE o.policyUri = :policyUri")
    , @NamedQuery(name = "OAuthApplications.findByTosUri", query = "SELECT o FROM OAuthApplications o WHERE o.tosUri = :tosUri")
    , @NamedQuery(name = "OAuthApplications.findBySectorIndentifierUri", query = "SELECT o FROM OAuthApplications o WHERE o.sectorIndentifierUri = :sectorIndentifierUri")
    , @NamedQuery(name = "OAuthApplications.findByTokenEndpointAuthMethod", query = "SELECT o FROM OAuthApplications o WHERE o.tokenEndpointAuthMethod = :tokenEndpointAuthMethod")
    , @NamedQuery(name = "OAuthApplications.findByJwksUri", query = "SELECT o FROM OAuthApplications o WHERE o.jwksUri = :jwksUri")
    , @NamedQuery(name = "OAuthApplications.findByPpid", query = "SELECT o FROM OAuthApplications o WHERE o.ppid = :ppid")
    , @NamedQuery(name = "OAuthApplications.findByCreatedAt", query = "SELECT o FROM OAuthApplications o WHERE o.createdAt = :createdAt")
    , @NamedQuery(name = "OAuthApplications.findByUpdatedAt", query = "SELECT o FROM OAuthApplications o WHERE o.updatedAt = :updatedAt")
    , @NamedQuery(name = "OAuthApplications.findByClientName", query = "SELECT o FROM OAuthApplications o WHERE o.clientName = :clientName")})
public class OAuthApplications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    @Lob
    @Column(name = "redirect_uris")
    private String redirectUris;
    @Column(name = "response_types")
    private String responseTypes;
    @Column(name = "grand_types")
    private String grandTypes;
    @Column(name = "application_type")
    private String applicationType;
    @Column(name = "contacts")
    private String contacts;
    @Column(name = "logo_uri")
    private String logoUri;
    @Column(name = "client_uri")
    private String clientUri;
    @Column(name = "policy_uri")
    private String policyUri;
    @Column(name = "tos_uri")
    private String tosUri;
    @Column(name = "sector_indentifier_uri")
    private String sectorIndentifierUri;
    @Column(name = "token_endpoint_auth_method")
    private String tokenEndpointAuthMethod;
    @Lob
    @Column(name = "jwks")
    private String jwks;
    @Column(name = "jwks_uri")
    private String jwksUri;
    @Column(name = "ppid")
    private Boolean ppid;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "client_name")
    private String clientName;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oAuthApplicationsId")
    private Collection<Ppid> ppidCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oAuthApplicationsId")
    private Collection<Authorizations> authorizationsCollection;

    public OAuthApplications() {
    }

    public OAuthApplications(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getResponseTypes() {
        return responseTypes;
    }

    public void setResponseTypes(String responseTypes) {
        this.responseTypes = responseTypes;
    }

    public String getGrandTypes() {
        return grandTypes;
    }

    public void setGrandTypes(String grandTypes) {
        this.grandTypes = grandTypes;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    public String getClientUri() {
        return clientUri;
    }

    public void setClientUri(String clientUri) {
        this.clientUri = clientUri;
    }

    public String getPolicyUri() {
        return policyUri;
    }

    public void setPolicyUri(String policyUri) {
        this.policyUri = policyUri;
    }

    public String getTosUri() {
        return tosUri;
    }

    public void setTosUri(String tosUri) {
        this.tosUri = tosUri;
    }

    public String getSectorIndentifierUri() {
        return sectorIndentifierUri;
    }

    public void setSectorIndentifierUri(String sectorIndentifierUri) {
        this.sectorIndentifierUri = sectorIndentifierUri;
    }

    public String getTokenEndpointAuthMethod() {
        return tokenEndpointAuthMethod;
    }

    public void setTokenEndpointAuthMethod(String tokenEndpointAuthMethod) {
        this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
    }

    public String getJwks() {
        return jwks;
    }

    public void setJwks(String jwks) {
        this.jwks = jwks;
    }

    public String getJwksUri() {
        return jwksUri;
    }

    public void setJwksUri(String jwksUri) {
        this.jwksUri = jwksUri;
    }

    public Boolean getPpid() {
        return ppid;
    }

    public void setPpid(Boolean ppid) {
        this.ppid = ppid;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @XmlTransient
    public Collection<Ppid> getPpidCollection() {
        return ppidCollection;
    }

    public void setPpidCollection(Collection<Ppid> ppidCollection) {
        this.ppidCollection = ppidCollection;
    }

    @XmlTransient
    public Collection<Authorizations> getAuthorizationsCollection() {
        return authorizationsCollection;
    }

    public void setAuthorizationsCollection(Collection<Authorizations> authorizationsCollection) {
        this.authorizationsCollection = authorizationsCollection;
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
        if (!(object instanceof OAuthApplications)) {
            return false;
        }
        OAuthApplications other = (OAuthApplications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.OAuthApplications[ id=" + id + " ]";
    }
    
}
