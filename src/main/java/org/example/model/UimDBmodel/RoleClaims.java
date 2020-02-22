/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valkovic
 */
@Entity
@Table(name = "RoleClaims", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleClaims.findAll", query = "SELECT r FROM RoleClaims r"),
    @NamedQuery(name = "RoleClaims.findByRoleClaimId", query = "SELECT r FROM RoleClaims r WHERE r.roleClaimId = :roleClaimId"),
    @NamedQuery(name = "RoleClaims.findByClaimType", query = "SELECT r FROM RoleClaims r WHERE r.claimType = :claimType"),
    @NamedQuery(name = "RoleClaims.findByClaimValue", query = "SELECT r FROM RoleClaims r WHERE r.claimValue = :claimValue")})
public class RoleClaims implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleClaimId", nullable = false)
    private Integer roleClaimId;
    @Column(name = "ClaimType", length = 2147483647)
    private String claimType;
    @Column(name = "ClaimValue", length = 2147483647)
    private String claimValue;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", nullable = false)
    @ManyToOne(optional = false)
    private Roles roleId;

    public RoleClaims() {
    }

    public RoleClaims(Integer roleClaimId) {
        this.roleClaimId = roleClaimId;
    }

    public Integer getRoleClaimId() {
        return roleClaimId;
    }

    public void setRoleClaimId(Integer roleClaimId) {
        this.roleClaimId = roleClaimId;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleClaimId != null ? roleClaimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleClaims)) {
            return false;
        }
        RoleClaims other = (RoleClaims) object;
        if ((this.roleClaimId == null && other.roleClaimId != null) || (this.roleClaimId != null && !this.roleClaimId.equals(other.roleClaimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.RoleClaims[ roleClaimId=" + roleClaimId + " ]";
    }
    
}
