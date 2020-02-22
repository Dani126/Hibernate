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
@Table(name = "UserClaims", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserClaims.findAll", query = "SELECT u FROM UserClaims u"),
    @NamedQuery(name = "UserClaims.findByUserClaimId", query = "SELECT u FROM UserClaims u WHERE u.userClaimId = :userClaimId"),
    @NamedQuery(name = "UserClaims.findByValue", query = "SELECT u FROM UserClaims u WHERE u.value = :value")})
public class UserClaims implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserClaimId", nullable = false)
    private Integer userClaimId;
    @Column(name = "Value", length = 2147483647)
    private String value;
    @JoinColumn(name = "UserClaimTypeId", referencedColumnName = "UserClaimTypeId", nullable = false)
    @ManyToOne(optional = false)
    private UserClaimTypes userClaimTypeId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Users userId;

    public UserClaims() {
    }

    public UserClaims(Integer userClaimId) {
        this.userClaimId = userClaimId;
    }

    public Integer getUserClaimId() {
        return userClaimId;
    }

    public void setUserClaimId(Integer userClaimId) {
        this.userClaimId = userClaimId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserClaimTypes getUserClaimTypeId() {
        return userClaimTypeId;
    }

    public void setUserClaimTypeId(UserClaimTypes userClaimTypeId) {
        this.userClaimTypeId = userClaimTypeId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userClaimId != null ? userClaimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserClaims)) {
            return false;
        }
        UserClaims other = (UserClaims) object;
        if ((this.userClaimId == null && other.userClaimId != null) || (this.userClaimId != null && !this.userClaimId.equals(other.userClaimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserClaims[ userClaimId=" + userClaimId + " ]";
    }
    
}
