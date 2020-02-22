/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "UserLogins", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLogins.findAll", query = "SELECT u FROM UserLogins u"),
    @NamedQuery(name = "UserLogins.findByLoginProvider", query = "SELECT u FROM UserLogins u WHERE u.userLoginsPK.loginProvider = :loginProvider"),
    @NamedQuery(name = "UserLogins.findByProviderKey", query = "SELECT u FROM UserLogins u WHERE u.userLoginsPK.providerKey = :providerKey"),
    @NamedQuery(name = "UserLogins.findByProviderDisplayName", query = "SELECT u FROM UserLogins u WHERE u.providerDisplayName = :providerDisplayName")})
public class UserLogins implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserLoginsPK userLoginsPK;
    @Column(name = "ProviderDisplayName", length = 2147483647)
    private String providerDisplayName;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Users userId;

    public UserLogins() {
    }

    public UserLogins(UserLoginsPK userLoginsPK) {
        this.userLoginsPK = userLoginsPK;
    }

    public UserLogins(String loginProvider, String providerKey) {
        this.userLoginsPK = new UserLoginsPK(loginProvider, providerKey);
    }

    public UserLoginsPK getUserLoginsPK() {
        return userLoginsPK;
    }

    public void setUserLoginsPK(UserLoginsPK userLoginsPK) {
        this.userLoginsPK = userLoginsPK;
    }

    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        this.providerDisplayName = providerDisplayName;
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
        hash += (userLoginsPK != null ? userLoginsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLogins)) {
            return false;
        }
        UserLogins other = (UserLogins) object;
        if ((this.userLoginsPK == null && other.userLoginsPK != null) || (this.userLoginsPK != null && !this.userLoginsPK.equals(other.userLoginsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserLogins[ userLoginsPK=" + userLoginsPK + " ]";
    }
    
}
