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
import javax.persistence.Lob;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByGettingStarted", query = "SELECT u FROM Users u WHERE u.gettingStarted = :gettingStarted")
    , @NamedQuery(name = "Users.findByDisableMail", query = "SELECT u FROM Users u WHERE u.disableMail = :disableMail")
    , @NamedQuery(name = "Users.findByLanguage", query = "SELECT u FROM Users u WHERE u.language = :language")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByEncryptedPassword", query = "SELECT u FROM Users u WHERE u.encryptedPassword = :encryptedPassword")
    , @NamedQuery(name = "Users.findByResetPasswordToken", query = "SELECT u FROM Users u WHERE u.resetPasswordToken = :resetPasswordToken")
    , @NamedQuery(name = "Users.findByRememberCreatedAt", query = "SELECT u FROM Users u WHERE u.rememberCreatedAt = :rememberCreatedAt")
    , @NamedQuery(name = "Users.findBySignInCount", query = "SELECT u FROM Users u WHERE u.signInCount = :signInCount")
    , @NamedQuery(name = "Users.findByCurrentSignInAt", query = "SELECT u FROM Users u WHERE u.currentSignInAt = :currentSignInAt")
    , @NamedQuery(name = "Users.findByLastSignInAt", query = "SELECT u FROM Users u WHERE u.lastSignInAt = :lastSignInAt")
    , @NamedQuery(name = "Users.findByCurrentSignInIp", query = "SELECT u FROM Users u WHERE u.currentSignInIp = :currentSignInIp")
    , @NamedQuery(name = "Users.findByLastSignInIp", query = "SELECT u FROM Users u WHERE u.lastSignInIp = :lastSignInIp")
    , @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt")
    , @NamedQuery(name = "Users.findByUpdatedAt", query = "SELECT u FROM Users u WHERE u.updatedAt = :updatedAt")
    , @NamedQuery(name = "Users.findByInvitedById", query = "SELECT u FROM Users u WHERE u.invitedById = :invitedById")
    , @NamedQuery(name = "Users.findByAuthenticationToken", query = "SELECT u FROM Users u WHERE u.authenticationToken = :authenticationToken")
    , @NamedQuery(name = "Users.findByUnconfirmedEmail", query = "SELECT u FROM Users u WHERE u.unconfirmedEmail = :unconfirmedEmail")
    , @NamedQuery(name = "Users.findByConfirmEmailToken", query = "SELECT u FROM Users u WHERE u.confirmEmailToken = :confirmEmailToken")
    , @NamedQuery(name = "Users.findByLockedAt", query = "SELECT u FROM Users u WHERE u.lockedAt = :lockedAt")
    , @NamedQuery(name = "Users.findByShowCommunitySpotlightInStream", query = "SELECT u FROM Users u WHERE u.showCommunitySpotlightInStream = :showCommunitySpotlightInStream")
    , @NamedQuery(name = "Users.findByAutoFollowBack", query = "SELECT u FROM Users u WHERE u.autoFollowBack = :autoFollowBack")
    , @NamedQuery(name = "Users.findByAutoFollowBackAspectId", query = "SELECT u FROM Users u WHERE u.autoFollowBackAspectId = :autoFollowBackAspectId")
    , @NamedQuery(name = "Users.findByResetPasswordSentAt", query = "SELECT u FROM Users u WHERE u.resetPasswordSentAt = :resetPasswordSentAt")
    , @NamedQuery(name = "Users.findByLastSeen", query = "SELECT u FROM Users u WHERE u.lastSeen = :lastSeen")
    , @NamedQuery(name = "Users.findByRemoveAfter", query = "SELECT u FROM Users u WHERE u.removeAfter = :removeAfter")
    , @NamedQuery(name = "Users.findByExport", query = "SELECT u FROM Users u WHERE u.export = :export")
    , @NamedQuery(name = "Users.findByExportedAt", query = "SELECT u FROM Users u WHERE u.exportedAt = :exportedAt")
    , @NamedQuery(name = "Users.findByExporting", query = "SELECT u FROM Users u WHERE u.exporting = :exporting")
    , @NamedQuery(name = "Users.findByStripExif", query = "SELECT u FROM Users u WHERE u.stripExif = :stripExif")
    , @NamedQuery(name = "Users.findByExportedPhotosFile", query = "SELECT u FROM Users u WHERE u.exportedPhotosFile = :exportedPhotosFile")
    , @NamedQuery(name = "Users.findByExportedPhotosAt", query = "SELECT u FROM Users u WHERE u.exportedPhotosAt = :exportedPhotosAt")
    , @NamedQuery(name = "Users.findByExportingPhotos", query = "SELECT u FROM Users u WHERE u.exportingPhotos = :exportingPhotos")
    , @NamedQuery(name = "Users.findByColorTheme", query = "SELECT u FROM Users u WHERE u.colorTheme = :colorTheme")
    , @NamedQuery(name = "Users.findByPostDefaultPublic", query = "SELECT u FROM Users u WHERE u.postDefaultPublic = :postDefaultPublic")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Lob
    @Column(name = "serialized_private_key")
    private String serializedPrivateKey;
    @Column(name = "getting_started")
    private Boolean gettingStarted;
    @Column(name = "disable_mail")
    private Boolean disableMail;
    @Column(name = "language")
    private String language;
    @Column(name = "email")
    private String email;
    @Column(name = "encrypted_password")
    private String encryptedPassword;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @Column(name = "remember_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rememberCreatedAt;
    @Column(name = "sign_in_count")
    private Integer signInCount;
    @Column(name = "current_sign_in_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentSignInAt;
    @Column(name = "last_sign_in_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSignInAt;
    @Column(name = "current_sign_in_ip")
    private String currentSignInIp;
    @Column(name = "last_sign_in_ip")
    private String lastSignInIp;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "invited_by_id")
    private Integer invitedById;
    @Column(name = "authentication_token")
    private String authenticationToken;
    @Column(name = "unconfirmed_email")
    private String unconfirmedEmail;
    @Column(name = "confirm_email_token")
    private String confirmEmailToken;
    @Column(name = "locked_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedAt;
    @Column(name = "show_community_spotlight_in_stream")
    private Boolean showCommunitySpotlightInStream;
    @Column(name = "auto_follow_back")
    private Boolean autoFollowBack;
    @Column(name = "auto_follow_back_aspect_id")
    private Integer autoFollowBackAspectId;
    @Lob
    @Column(name = "hidden_shareables")
    private String hiddenShareables;
    @Column(name = "reset_password_sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordSentAt;
    @Column(name = "last_seen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSeen;
    @Column(name = "remove_after")
    @Temporal(TemporalType.TIMESTAMP)
    private Date removeAfter;
    @Column(name = "export")
    private String export;
    @Column(name = "exported_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exportedAt;
    @Column(name = "exporting")
    private Boolean exporting;
    @Column(name = "strip_exif")
    private Boolean stripExif;
    @Column(name = "exported_photos_file")
    private String exportedPhotosFile;
    @Column(name = "exported_photos_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exportedPhotosAt;
    @Column(name = "exporting_photos")
    private Boolean exportingPhotos;
    @Column(name = "color_theme")
    private String colorTheme;
    @Column(name = "post_default_public")
    private Boolean postDefaultPublic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<OAuthApplications> oAuthApplicationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<Ppid> ppidCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<Authorizations> authorizationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<ShareVisibilities> shareVisibilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<Services> servicesCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSerializedPrivateKey() {
        return serializedPrivateKey;
    }

    public void setSerializedPrivateKey(String serializedPrivateKey) {
        this.serializedPrivateKey = serializedPrivateKey;
    }

    public Boolean getGettingStarted() {
        return gettingStarted;
    }

    public void setGettingStarted(Boolean gettingStarted) {
        this.gettingStarted = gettingStarted;
    }

    public Boolean getDisableMail() {
        return disableMail;
    }

    public void setDisableMail(Boolean disableMail) {
        this.disableMail = disableMail;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Date getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public void setRememberCreatedAt(Date rememberCreatedAt) {
        this.rememberCreatedAt = rememberCreatedAt;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(String currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
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

    public Integer getInvitedById() {
        return invitedById;
    }

    public void setInvitedById(Integer invitedById) {
        this.invitedById = invitedById;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getUnconfirmedEmail() {
        return unconfirmedEmail;
    }

    public void setUnconfirmedEmail(String unconfirmedEmail) {
        this.unconfirmedEmail = unconfirmedEmail;
    }

    public String getConfirmEmailToken() {
        return confirmEmailToken;
    }

    public void setConfirmEmailToken(String confirmEmailToken) {
        this.confirmEmailToken = confirmEmailToken;
    }

    public Date getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(Date lockedAt) {
        this.lockedAt = lockedAt;
    }

    public Boolean getShowCommunitySpotlightInStream() {
        return showCommunitySpotlightInStream;
    }

    public void setShowCommunitySpotlightInStream(Boolean showCommunitySpotlightInStream) {
        this.showCommunitySpotlightInStream = showCommunitySpotlightInStream;
    }

    public Boolean getAutoFollowBack() {
        return autoFollowBack;
    }

    public void setAutoFollowBack(Boolean autoFollowBack) {
        this.autoFollowBack = autoFollowBack;
    }

    public Integer getAutoFollowBackAspectId() {
        return autoFollowBackAspectId;
    }

    public void setAutoFollowBackAspectId(Integer autoFollowBackAspectId) {
        this.autoFollowBackAspectId = autoFollowBackAspectId;
    }

    public String getHiddenShareables() {
        return hiddenShareables;
    }

    public void setHiddenShareables(String hiddenShareables) {
        this.hiddenShareables = hiddenShareables;
    }

    public Date getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Date getRemoveAfter() {
        return removeAfter;
    }

    public void setRemoveAfter(Date removeAfter) {
        this.removeAfter = removeAfter;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public Date getExportedAt() {
        return exportedAt;
    }

    public void setExportedAt(Date exportedAt) {
        this.exportedAt = exportedAt;
    }

    public Boolean getExporting() {
        return exporting;
    }

    public void setExporting(Boolean exporting) {
        this.exporting = exporting;
    }

    public Boolean getStripExif() {
        return stripExif;
    }

    public void setStripExif(Boolean stripExif) {
        this.stripExif = stripExif;
    }

    public String getExportedPhotosFile() {
        return exportedPhotosFile;
    }

    public void setExportedPhotosFile(String exportedPhotosFile) {
        this.exportedPhotosFile = exportedPhotosFile;
    }

    public Date getExportedPhotosAt() {
        return exportedPhotosAt;
    }

    public void setExportedPhotosAt(Date exportedPhotosAt) {
        this.exportedPhotosAt = exportedPhotosAt;
    }

    public Boolean getExportingPhotos() {
        return exportingPhotos;
    }

    public void setExportingPhotos(Boolean exportingPhotos) {
        this.exportingPhotos = exportingPhotos;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public Boolean getPostDefaultPublic() {
        return postDefaultPublic;
    }

    public void setPostDefaultPublic(Boolean postDefaultPublic) {
        this.postDefaultPublic = postDefaultPublic;
    }

    @XmlTransient
    public Collection<OAuthApplications> getOAuthApplicationsCollection() {
        return oAuthApplicationsCollection;
    }

    public void setOAuthApplicationsCollection(Collection<OAuthApplications> oAuthApplicationsCollection) {
        this.oAuthApplicationsCollection = oAuthApplicationsCollection;
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

    @XmlTransient
    public Collection<ShareVisibilities> getShareVisibilitiesCollection() {
        return shareVisibilitiesCollection;
    }

    public void setShareVisibilitiesCollection(Collection<ShareVisibilities> shareVisibilitiesCollection) {
        this.shareVisibilitiesCollection = shareVisibilitiesCollection;
    }

    @XmlTransient
    public Collection<Services> getServicesCollection() {
        return servicesCollection;
    }

    public void setServicesCollection(Collection<Services> servicesCollection) {
        this.servicesCollection = servicesCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Users[ id=" + id + " ]";
    }
    
}
