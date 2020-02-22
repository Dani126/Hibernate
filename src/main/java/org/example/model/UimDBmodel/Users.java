/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valkovic
 */
@Entity
@Table(name = "Users", catalog = "UIMDB", schema = "ids", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"UserName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByNormalizedUserName", query = "SELECT u FROM Users u WHERE u.normalizedUserName = :normalizedUserName"),
    @NamedQuery(name = "Users.findByEmailConfirmed", query = "SELECT u FROM Users u WHERE u.emailConfirmed = :emailConfirmed"),
    @NamedQuery(name = "Users.findByPasswordHash", query = "SELECT u FROM Users u WHERE u.passwordHash = :passwordHash"),
    @NamedQuery(name = "Users.findBySecurityStamp", query = "SELECT u FROM Users u WHERE u.securityStamp = :securityStamp"),
    @NamedQuery(name = "Users.findByConcurrencyStamp", query = "SELECT u FROM Users u WHERE u.concurrencyStamp = :concurrencyStamp"),
    @NamedQuery(name = "Users.findByPhoneNumberConfirmed", query = "SELECT u FROM Users u WHERE u.phoneNumberConfirmed = :phoneNumberConfirmed"),
    @NamedQuery(name = "Users.findByTwoFactorEnabled", query = "SELECT u FROM Users u WHERE u.twoFactorEnabled = :twoFactorEnabled"),
    @NamedQuery(name = "Users.findByLockoutEnd", query = "SELECT u FROM Users u WHERE u.lockoutEnd = :lockoutEnd"),
    @NamedQuery(name = "Users.findByLockoutEnabled", query = "SELECT u FROM Users u WHERE u.lockoutEnabled = :lockoutEnabled"),
    @NamedQuery(name = "Users.findByAccessFailedCount", query = "SELECT u FROM Users u WHERE u.accessFailedCount = :accessFailedCount"),
    @NamedQuery(name = "Users.findByExternalId", query = "SELECT u FROM Users u WHERE u.externalId = :externalId")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Column(name = "UserName", length = 256)
    private String userName;
    @Column(name = "NormalizedUserName", length = 256)
    private String normalizedUserName;
    @Basic(optional = false)
    @Column(name = "EmailConfirmed", nullable = false)
    private boolean emailConfirmed;
    @Column(name = "PasswordHash", length = 2147483647)
    private String passwordHash;
    @Column(name = "SecurityStamp", length = 2147483647)
    private String securityStamp;
    @Column(name = "ConcurrencyStamp", length = 2147483647)
    private String concurrencyStamp;
    @Basic(optional = false)
    @Column(name = "PhoneNumberConfirmed", nullable = false)
    private boolean phoneNumberConfirmed;
    @Basic(optional = false)
    @Column(name = "TwoFactorEnabled", nullable = false)
    private boolean twoFactorEnabled;
    @Column(name = "LockoutEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockoutEnd;
    @Basic(optional = false)
    @Column(name = "LockoutEnabled", nullable = false)
    private boolean lockoutEnabled;
    @Column(name = "AccessFailedCount")
    private Integer accessFailedCount;
    @Basic(optional = false)
    @Column(name = "ExternalId", nullable = false, length = 64)
    private String externalId;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Roles> rolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserClaims> userClaimsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserTokens> userTokensCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deputyUserId")
    private Collection<UserSubstitutions> userSubstitutionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offSiteUserId")
    private Collection<UserSubstitutions> userSubstitutionsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserLogins> userLoginsCollection;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, boolean emailConfirmed, boolean phoneNumberConfirmed, boolean twoFactorEnabled, boolean lockoutEnabled, String externalId) {
        this.userId = userId;
        this.emailConfirmed = emailConfirmed;
        this.phoneNumberConfirmed = phoneNumberConfirmed;
        this.twoFactorEnabled = twoFactorEnabled;
        this.lockoutEnabled = lockoutEnabled;
        this.externalId = externalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNormalizedUserName() {
        return normalizedUserName;
    }

    public void setNormalizedUserName(String normalizedUserName) {
        this.normalizedUserName = normalizedUserName;
    }

    public boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getConcurrencyStamp() {
        return concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public boolean getPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Date getLockoutEnd() {
        return lockoutEnd;
    }

    public void setLockoutEnd(Date lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    public boolean getLockoutEnabled() {
        return lockoutEnabled;
    }

    public void setLockoutEnabled(boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public Integer getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(Integer accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<UserClaims> getUserClaimsCollection() {
        return userClaimsCollection;
    }

    public void setUserClaimsCollection(Collection<UserClaims> userClaimsCollection) {
        this.userClaimsCollection = userClaimsCollection;
    }

    @XmlTransient
    public Collection<UserTokens> getUserTokensCollection() {
        return userTokensCollection;
    }

    public void setUserTokensCollection(Collection<UserTokens> userTokensCollection) {
        this.userTokensCollection = userTokensCollection;
    }

    @XmlTransient
    public Collection<UserSubstitutions> getUserSubstitutionsCollection() {
        return userSubstitutionsCollection;
    }

    public void setUserSubstitutionsCollection(Collection<UserSubstitutions> userSubstitutionsCollection) {
        this.userSubstitutionsCollection = userSubstitutionsCollection;
    }

    @XmlTransient
    public Collection<UserSubstitutions> getUserSubstitutionsCollection1() {
        return userSubstitutionsCollection1;
    }

    public void setUserSubstitutionsCollection1(Collection<UserSubstitutions> userSubstitutionsCollection1) {
        this.userSubstitutionsCollection1 = userSubstitutionsCollection1;
    }

    @XmlTransient
    public Collection<UserLogins> getUserLoginsCollection() {
        return userLoginsCollection;
    }

    public void setUserLoginsCollection(Collection<UserLogins> userLoginsCollection) {
        this.userLoginsCollection = userLoginsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.Users[ userId=" + userId + " ]";
    }
    
}
