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
@Table(name = "UserClaimResources", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserClaimResources.findAll", query = "SELECT u FROM UserClaimResources u"),
    @NamedQuery(name = "UserClaimResources.findByUserClaimResourceId", query = "SELECT u FROM UserClaimResources u WHERE u.userClaimResourceId = :userClaimResourceId"),
    @NamedQuery(name = "UserClaimResources.findByEnabled", query = "SELECT u FROM UserClaimResources u WHERE u.enabled = :enabled"),
    @NamedQuery(name = "UserClaimResources.findByName", query = "SELECT u FROM UserClaimResources u WHERE u.name = :name"),
    @NamedQuery(name = "UserClaimResources.findByDisplayName", query = "SELECT u FROM UserClaimResources u WHERE u.displayName = :displayName"),
    @NamedQuery(name = "UserClaimResources.findByDescription", query = "SELECT u FROM UserClaimResources u WHERE u.description = :description"),
    @NamedQuery(name = "UserClaimResources.findByRequired", query = "SELECT u FROM UserClaimResources u WHERE u.required = :required"),
    @NamedQuery(name = "UserClaimResources.findByEmphasize", query = "SELECT u FROM UserClaimResources u WHERE u.emphasize = :emphasize"),
    @NamedQuery(name = "UserClaimResources.findByShowInDiscoveryDocument", query = "SELECT u FROM UserClaimResources u WHERE u.showInDiscoveryDocument = :showInDiscoveryDocument")})
public class UserClaimResources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserClaimResourceId", nullable = false)
    private Integer userClaimResourceId;
    @Basic(optional = false)
    @Column(name = "Enabled", nullable = false)
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 256)
    private String name;
    @Column(name = "DisplayName", length = 256)
    private String displayName;
    @Column(name = "Description", length = 1024)
    private String description;
    @Basic(optional = false)
    @Column(name = "Required", nullable = false)
    private boolean required;
    @Basic(optional = false)
    @Column(name = "Emphasize", nullable = false)
    private boolean emphasize;
    @Basic(optional = false)
    @Column(name = "ShowInDiscoveryDocument", nullable = false)
    private boolean showInDiscoveryDocument;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userClaimResourceId")
    private Collection<UserClaimTypes> userClaimTypesCollection;

    public UserClaimResources() {
    }

    public UserClaimResources(Integer userClaimResourceId) {
        this.userClaimResourceId = userClaimResourceId;
    }

    public UserClaimResources(Integer userClaimResourceId, boolean enabled, String name, boolean required, boolean emphasize, boolean showInDiscoveryDocument) {
        this.userClaimResourceId = userClaimResourceId;
        this.enabled = enabled;
        this.name = name;
        this.required = required;
        this.emphasize = emphasize;
        this.showInDiscoveryDocument = showInDiscoveryDocument;
    }

    public Integer getUserClaimResourceId() {
        return userClaimResourceId;
    }

    public void setUserClaimResourceId(Integer userClaimResourceId) {
        this.userClaimResourceId = userClaimResourceId;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getEmphasize() {
        return emphasize;
    }

    public void setEmphasize(boolean emphasize) {
        this.emphasize = emphasize;
    }

    public boolean getShowInDiscoveryDocument() {
        return showInDiscoveryDocument;
    }

    public void setShowInDiscoveryDocument(boolean showInDiscoveryDocument) {
        this.showInDiscoveryDocument = showInDiscoveryDocument;
    }

    @XmlTransient
    public Collection<UserClaimTypes> getUserClaimTypesCollection() {
        return userClaimTypesCollection;
    }

    public void setUserClaimTypesCollection(Collection<UserClaimTypes> userClaimTypesCollection) {
        this.userClaimTypesCollection = userClaimTypesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userClaimResourceId != null ? userClaimResourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserClaimResources)) {
            return false;
        }
        UserClaimResources other = (UserClaimResources) object;
        if ((this.userClaimResourceId == null && other.userClaimResourceId != null) || (this.userClaimResourceId != null && !this.userClaimResourceId.equals(other.userClaimResourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserClaimResources[ userClaimResourceId=" + userClaimResourceId + " ]";
    }
    
}
