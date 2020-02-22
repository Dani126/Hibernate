/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.UimDBmodel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valkovic
 */
@Entity
@Table(name = "UserSubstitutions", catalog = "UIMDB", schema = "ids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSubstitutions.findAll", query = "SELECT u FROM UserSubstitutions u"),
    @NamedQuery(name = "UserSubstitutions.findByUserSubstitutionId", query = "SELECT u FROM UserSubstitutions u WHERE u.userSubstitutionId = :userSubstitutionId"),
    @NamedQuery(name = "UserSubstitutions.findByStartDate", query = "SELECT u FROM UserSubstitutions u WHERE u.startDate = :startDate"),
    @NamedQuery(name = "UserSubstitutions.findByFinishDate", query = "SELECT u FROM UserSubstitutions u WHERE u.finishDate = :finishDate"),
    @NamedQuery(name = "UserSubstitutions.findByEnabled", query = "SELECT u FROM UserSubstitutions u WHERE u.enabled = :enabled")})
public class UserSubstitutions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserSubstitutionId", nullable = false)
    private Integer userSubstitutionId;
    @Basic(optional = false)
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "FinishDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Basic(optional = false)
    @Column(name = "Enabled", nullable = false)
    private boolean enabled;
    @JoinColumn(name = "DeputyUserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Users deputyUserId;
    @JoinColumn(name = "OffSiteUserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Users offSiteUserId;

    public UserSubstitutions() {
    }

    public UserSubstitutions(Integer userSubstitutionId) {
        this.userSubstitutionId = userSubstitutionId;
    }

    public UserSubstitutions(Integer userSubstitutionId, Date startDate, Date finishDate, boolean enabled) {
        this.userSubstitutionId = userSubstitutionId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.enabled = enabled;
    }

    public Integer getUserSubstitutionId() {
        return userSubstitutionId;
    }

    public void setUserSubstitutionId(Integer userSubstitutionId) {
        this.userSubstitutionId = userSubstitutionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Users getDeputyUserId() {
        return deputyUserId;
    }

    public void setDeputyUserId(Users deputyUserId) {
        this.deputyUserId = deputyUserId;
    }

    public Users getOffSiteUserId() {
        return offSiteUserId;
    }

    public void setOffSiteUserId(Users offSiteUserId) {
        this.offSiteUserId = offSiteUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSubstitutionId != null ? userSubstitutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSubstitutions)) {
            return false;
        }
        UserSubstitutions other = (UserSubstitutions) object;
        if ((this.userSubstitutionId == null && other.userSubstitutionId != null) || (this.userSubstitutionId != null && !this.userSubstitutionId.equals(other.userSubstitutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UimDBmodel.UserSubstitutions[ userSubstitutionId=" + userSubstitutionId + " ]";
    }
    
}
