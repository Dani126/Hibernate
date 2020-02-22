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
import javax.persistence.ManyToOne;
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
@Table(name = "UserClaimTypes", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserClaimTypes.findAll", query = "SELECT u FROM UserClaimTypes u"),
    @NamedQuery(name = "UserClaimTypes.findByUserClaimTypeId", query = "SELECT u FROM UserClaimTypes u WHERE u.userClaimTypeId = :userClaimTypeId"),
    @NamedQuery(name = "UserClaimTypes.findByType", query = "SELECT u FROM UserClaimTypes u WHERE u.type = :type")})
public class UserClaimTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserClaimTypeId", nullable = false)
    private Integer userClaimTypeId;
    @Basic(optional = false)
    @Column(name = "Type", nullable = false, length = 256)
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userClaimTypeId")
    private Collection<UserClaims> userClaimsCollection;
    @JoinColumn(name = "UserClaimResourceId", referencedColumnName = "UserClaimResourceId", nullable = false)
    @ManyToOne(optional = false)
    private UserClaimResources userClaimResourceId;

    public UserClaimTypes() {
    }

    public UserClaimTypes(Integer userClaimTypeId) {
        this.userClaimTypeId = userClaimTypeId;
    }

    public UserClaimTypes(Integer userClaimTypeId, String type) {
        this.userClaimTypeId = userClaimTypeId;
        this.type = type;
    }

    public Integer getUserClaimTypeId() {
        return userClaimTypeId;
    }

    public void setUserClaimTypeId(Integer userClaimTypeId) {
        this.userClaimTypeId = userClaimTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<UserClaims> getUserClaimsCollection() {
        return userClaimsCollection;
    }

    public void setUserClaimsCollection(Collection<UserClaims> userClaimsCollection) {
        this.userClaimsCollection = userClaimsCollection;
    }

    public UserClaimResources getUserClaimResourceId() {
        return userClaimResourceId;
    }

    public void setUserClaimResourceId(UserClaimResources userClaimResourceId) {
        this.userClaimResourceId = userClaimResourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userClaimTypeId != null ? userClaimTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserClaimTypes)) {
            return false;
        }
        UserClaimTypes other = (UserClaimTypes) object;
        if ((this.userClaimTypeId == null && other.userClaimTypeId != null) || (this.userClaimTypeId != null && !this.userClaimTypeId.equals(other.userClaimTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserClaimTypes[ userClaimTypeId=" + userClaimTypeId + " ]";
    }
    
}
