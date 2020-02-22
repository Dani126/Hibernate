/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valkovic
 */
@Entity
@Table(name = "Roles", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRoleId", query = "SELECT r FROM Roles r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Roles.findByName", query = "SELECT r FROM Roles r WHERE r.name = :name"),
    @NamedQuery(name = "Roles.findByNormalizedName", query = "SELECT r FROM Roles r WHERE r.normalizedName = :normalizedName"),
    @NamedQuery(name = "Roles.findByConcurrencyStamp", query = "SELECT r FROM Roles r WHERE r.concurrencyStamp = :concurrencyStamp")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleId", nullable = false)
    private Integer roleId;
    @Column(name = "Name", length = 256)
    private String name;
    @Column(name = "NormalizedName", length = 256)
    private String normalizedName;
    @Column(name = "ConcurrencyStamp", length = 2147483647)
    private String concurrencyStamp;
    @JoinTable(name = "UserRoles", joinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)})
    @ManyToMany
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<RoleClaims> roleClaimsCollection;

    public Roles() {
    }

    public Roles(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalizedName() {
        return normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }

    public String getConcurrencyStamp() {
        return concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<RoleClaims> getRoleClaimsCollection() {
        return roleClaimsCollection;
    }

    public void setRoleClaimsCollection(Collection<RoleClaims> roleClaimsCollection) {
        this.roleClaimsCollection = roleClaimsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.Roles[ roleId=" + roleId + " ]";
    }
    
}
