/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author valkovic
 */
@Embeddable
public class UserLoginsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "LoginProvider", nullable = false, length = 220)
    private String loginProvider;
    @Basic(optional = false)
    @Column(name = "ProviderKey", nullable = false, length = 220)
    private String providerKey;

    public UserLoginsPK() {
    }

    public UserLoginsPK(String loginProvider, String providerKey) {
        this.loginProvider = loginProvider;
        this.providerKey = providerKey;
    }

    public String getLoginProvider() {
        return loginProvider;
    }

    public void setLoginProvider(String loginProvider) {
        this.loginProvider = loginProvider;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginProvider != null ? loginProvider.hashCode() : 0);
        hash += (providerKey != null ? providerKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLoginsPK)) {
            return false;
        }
        UserLoginsPK other = (UserLoginsPK) object;
        if ((this.loginProvider == null && other.loginProvider != null) || (this.loginProvider != null && !this.loginProvider.equals(other.loginProvider))) {
            return false;
        }
        if ((this.providerKey == null && other.providerKey != null) || (this.providerKey != null && !this.providerKey.equals(other.providerKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserLoginsPK[ loginProvider=" + loginProvider + ", providerKey=" + providerKey + " ]";
    }
    
}
