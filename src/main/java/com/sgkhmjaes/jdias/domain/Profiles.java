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
@Table(name = "profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiles.findAll", query = "SELECT p FROM Profiles p")
    , @NamedQuery(name = "Profiles.findById", query = "SELECT p FROM Profiles p WHERE p.id = :id")
    , @NamedQuery(name = "Profiles.findByDiasporaHandle", query = "SELECT p FROM Profiles p WHERE p.diasporaHandle = :diasporaHandle")
    , @NamedQuery(name = "Profiles.findByFirstName", query = "SELECT p FROM Profiles p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Profiles.findByLastName", query = "SELECT p FROM Profiles p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Profiles.findByImageUrl", query = "SELECT p FROM Profiles p WHERE p.imageUrl = :imageUrl")
    , @NamedQuery(name = "Profiles.findByImageUrlSmall", query = "SELECT p FROM Profiles p WHERE p.imageUrlSmall = :imageUrlSmall")
    , @NamedQuery(name = "Profiles.findByImageUrlMedium", query = "SELECT p FROM Profiles p WHERE p.imageUrlMedium = :imageUrlMedium")
    , @NamedQuery(name = "Profiles.findByBirthday", query = "SELECT p FROM Profiles p WHERE p.birthday = :birthday")
    , @NamedQuery(name = "Profiles.findByGender", query = "SELECT p FROM Profiles p WHERE p.gender = :gender")
    , @NamedQuery(name = "Profiles.findBySearchable", query = "SELECT p FROM Profiles p WHERE p.searchable = :searchable")
    , @NamedQuery(name = "Profiles.findByCreatedAt", query = "SELECT p FROM Profiles p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Profiles.findByUpdatedAt", query = "SELECT p FROM Profiles p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Profiles.findByLocation", query = "SELECT p FROM Profiles p WHERE p.location = :location")
    , @NamedQuery(name = "Profiles.findByFullName", query = "SELECT p FROM Profiles p WHERE p.fullName = :fullName")
    , @NamedQuery(name = "Profiles.findByNsfw", query = "SELECT p FROM Profiles p WHERE p.nsfw = :nsfw")
    , @NamedQuery(name = "Profiles.findByPublicDetalis", query = "SELECT p FROM Profiles p WHERE p.publicDetalis = :publicDetalis")})
public class Profiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diaspora_handle")
    private String diasporaHandle;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "image_url_small")
    private String imageUrlSmall;
    @Column(name = "image_url_medium")
    private String imageUrlMedium;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "gender")
    private String gender;
    @Lob
    @Column(name = "bio")
    private String bio;
    @Column(name = "searchable")
    private Boolean searchable;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "location")
    private String location;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "nsfw")
    private Boolean nsfw;
    @Column(name = "public_detalis")
    private Boolean publicDetalis;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People personId;

    public Profiles() {
    }

    public Profiles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiasporaHandle() {
        return diasporaHandle;
    }

    public void setDiasporaHandle(String diasporaHandle) {
        this.diasporaHandle = diasporaHandle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlSmall() {
        return imageUrlSmall;
    }

    public void setImageUrlSmall(String imageUrlSmall) {
        this.imageUrlSmall = imageUrlSmall;
    }

    public String getImageUrlMedium() {
        return imageUrlMedium;
    }

    public void setImageUrlMedium(String imageUrlMedium) {
        this.imageUrlMedium = imageUrlMedium;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Boolean getPublicDetalis() {
        return publicDetalis;
    }

    public void setPublicDetalis(Boolean publicDetalis) {
        this.publicDetalis = publicDetalis;
    }

    public People getPersonId() {
        return personId;
    }

    public void setPersonId(People personId) {
        this.personId = personId;
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
        if (!(object instanceof Profiles)) {
            return false;
        }
        Profiles other = (Profiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbModels.Profiles[ id=" + id + " ]";
    }
    
}
