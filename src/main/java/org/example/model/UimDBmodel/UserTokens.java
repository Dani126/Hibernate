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
@Table(name = "UserTokens", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTokens.findAll", query = "SELECT u FROM UserTokens u"),
    @NamedQuery(name = "UserTokens.findByUserId", query = "SELECT u FROM UserTokens u WHERE u.userTokensPK.userId = :userId"),
    @NamedQuery(name = "UserTokens.findByLoginProvider", query = "SELECT u FROM UserTokens u WHERE u.userTokensPK.loginProvider = :loginProvider"),
    @NamedQuery(name = "UserTokens.findByName", query = "SELECT u FROM UserTokens u WHERE u.userTokensPK.name = :name"),
    @NamedQuery(name = "UserTokens.findByValue", query = "SELECT u FROM UserTokens u WHERE u.value = :value")})
public class UserTokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserTokensPK userTokensPK;
    @Column(name = "Value", length = 2147483647)
    private String value;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UserTokens() {
    }

    public UserTokens(UserTokensPK userTokensPK) {
        this.userTokensPK = userTokensPK;
    }

    public UserTokens(int userId, String loginProvider, String name) {
        this.userTokensPK = new UserTokensPK(userId, loginProvider, name);
    }

    public UserTokensPK getUserTokensPK() {
        return userTokensPK;
    }

    public void setUserTokensPK(UserTokensPK userTokensPK) {
        this.userTokensPK = userTokensPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTokensPK != null ? userTokensPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTokens)) {
            return false;
        }
        UserTokens other = (UserTokens) object;
        if ((this.userTokensPK == null && other.userTokensPK != null) || (this.userTokensPK != null && !this.userTokensPK.equals(other.userTokensPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserTokens[ userTokensPK=" + userTokensPK + " ]";
    }
    
}
