package com.mountbet.accountservice.entity;

import com.datastax.driver.core.DataType;
import com.mountbet.accountservice.entity.key.AccountKey;
import com.mountbet.accountservice.entity.udt.AccountContactDetail;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author AnsonChan
 * @since 10/7/2018
 */
@Table(value = "account")
public class Account {
    @PrimaryKey
    private AccountKey key;

    @Column(value = "acc_permission_account_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long accPermissionAccountId;

    @Column(value = "acc_permission_permission")
    @CassandraType(type = DataType.Name.TEXT)
    private String accPermissionPermission;

    @Column(value = "account_type")
    @CassandraType(type = DataType.Name.TEXT)
    private String accountType;

    @Column(value = "active")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean active;

    @Column(value = "admin_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal adminExposure;

    @Column(value = "admin_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long adminId;

    @Column(value = "age_verified")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean ageVerified;

    @Column(value = "anomalous_alert_emails")
    @CassandraType(type = DataType.Name.TEXT)
    private String anomalousAlertEmails;

    @Column(value = "app_key_id")
    @CassandraType(type = DataType.Name.SET, typeArguments = {DataType.Name.TEXT})
    private Set<String> appKeyId;

    @Column(value = "balance")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal balance;

    @Column(value = "commission")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal commission;

    @Column(value = "contact")
    @CassandraType(type = DataType.Name.UDT, userTypeName = "contact_detail")
    private AccountContactDetail contact;

    @Column(value = "created")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date created;

    @Column(value = "currency")
    @CassandraType(type = DataType.Name.TEXT)
    private String currency;

    @Column(value = "hidden")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean hidden;

    @Column(value = "hierarchy_type")
    @CassandraType(type = DataType.Name.INT)
    private Integer hierarchyType;

    @Column(value = "ignore_geo_blocking")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean ignoreGeoBlocking;

    @Column(value = "is_active")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isActive;

    @Column(value = "is_consented_to_rules")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isConsentedToRules;

    @Column(value = "is_hidden")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isHidden;

    @Column(value = "is_self_funded")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isSelfFunded;

    @Column(value = "is_under_self_funded_restrictions")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isUnderSelfFundedRestrictions;

    @Column(value = "is_verified")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private Boolean isVerified;

    @Column(value = "language")
    @CassandraType(type = DataType.Name.TEXT)
    private String language;

    @Column(value = "last_activity")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private Date lastActivity;

    @Column(value = "last_activity_timezone")
    @CassandraType(type = DataType.Name.TEXT)
    private String lastActivityTimezone;

    @Column(value = "login_attempts")
    @CassandraType(type = DataType.Name.INT)
    private Integer loginAttempts;

    @Column(value = "loss_limit")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal lossLimit;

    @Column(value = "master_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal masterExposure;

    @Column(value = "master_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long masterId;

    @Column(value = "max_bet_size")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal maxBetSize;

    @Column(value = "min_bet_size")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal minBetSize;

    @Column(value = "min_commission_limit")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal minCommissionLimit;

    @Column(value = "notes")
    @CassandraType(type = DataType.Name.TEXT)
    private String notes;

    @Column(value = "operator_account_tier")
    @CassandraType(type = DataType.Name.INT)
    private Integer operatorAccountTier;

    @Column(value = "original_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long originalId;

    @Column(value = "parent_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long parentId;

    @Column(value = "password")
    @CassandraType(type = DataType.Name.TEXT)
    private String password;

    @Column(value = "permission_account")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long permissionAccount;

    @Column(value = "permission_operator")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long permissionOperator;

    @Column(value = "reserved_funds")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal reservedFunds;

    @Column(value = "self_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal selfExposure;

    @Column(value = "self_funded")
    @CassandraType(type = DataType.Name.BOOLEAN)
    private boolean selfFunded;

    @Column(value = "settings")
    @CassandraType(type = DataType.Name.TEXT)
    private String settings;

    @Column(value = "sub_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal subExposure;

    @Column(value = "sub_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long subId;

    @Column(value = "super_admin_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal superAdminExposure;

    @Column(value = "super_admin_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long superAdminId;

    @Column(value = "super_master_exposure")
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal superMasterExposure;

    @Column(value = "super_master_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long superMasterId;

    @Column(value = "username")
    @CassandraType(type = DataType.Name.TEXT)
    private String username;

    @Column(value = "version")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long version;

    @Column(value = "partner_id")
    @CassandraType(type = DataType.Name.INT)
    private Integer partnerId;

    public AccountKey getKey() {
        return key;
    }

    public void setKey(AccountKey key) {
        this.key = key;
    }

    public Long getAccPermissionAccountId() {
        return accPermissionAccountId;
    }

    public void setAccPermissionAccountId(Long accPermissionAccountId) {
        this.accPermissionAccountId = accPermissionAccountId;
    }

    public String getAccPermissionPermission() {
        return accPermissionPermission;
    }

    public void setAccPermissionPermission(String accPermissionPermission) {
        this.accPermissionPermission = accPermissionPermission;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getConsentedToRules() {
        return isConsentedToRules;
    }

    public void setConsentedToRules(Boolean consentedToRules) {
        isConsentedToRules = consentedToRules;
    }

    public BigDecimal getAdminExposure() {
        return adminExposure;
    }

    public void setAdminExposure(BigDecimal adminExposure) {
        this.adminExposure = adminExposure;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Boolean getAgeVerified() {
        return ageVerified;
    }

    public void setAgeVerified(Boolean ageVerified) {
        this.ageVerified = ageVerified;
    }

    public String getAnomalousAlertEmails() {
        return anomalousAlertEmails;
    }

    public void setAnomalousAlertEmails(String anomalousAlertEmails) {
        this.anomalousAlertEmails = anomalousAlertEmails;
    }

    public Set<String> getAppKeyId() {
        return appKeyId;
    }

    public void setAppKeyId(Set<String> appKeyId) {
        this.appKeyId = appKeyId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public AccountContactDetail getContact() {
        return contact;
    }

    public void setContact(AccountContactDetail contact) {
        this.contact = contact;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getSelfFunded() {
        return isSelfFunded;
    }

    public void setSelfFunded(Boolean selfFunded) {
        isSelfFunded = selfFunded;
    }

    public Boolean getUnderSelfFundedRestrictions() {
        return isUnderSelfFundedRestrictions;
    }

    public void setUnderSelfFundedRestrictions(Boolean underSelfFundedRestrictions) {
        isUnderSelfFundedRestrictions = underSelfFundedRestrictions;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getLastActivityTimezone() {
        return lastActivityTimezone;
    }

    public void setLastActivityTimezone(String lastActivityTimezone) {
        this.lastActivityTimezone = lastActivityTimezone;
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public BigDecimal getLossLimit() {
        return lossLimit;
    }

    public void setLossLimit(BigDecimal lossLimit) {
        this.lossLimit = lossLimit;
    }

    public BigDecimal getMasterExposure() {
        return masterExposure;
    }

    public void setMasterExposure(BigDecimal masterExposure) {
        this.masterExposure = masterExposure;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public BigDecimal getMaxBetSize() {
        return maxBetSize;
    }

    public void setMaxBetSize(BigDecimal maxBetSize) {
        this.maxBetSize = maxBetSize;
    }

    public BigDecimal getMinBetSize() {
        return minBetSize;
    }

    public void setMinBetSize(BigDecimal minBetSize) {
        this.minBetSize = minBetSize;
    }

    public BigDecimal getMinCommissionLimit() {
        return minCommissionLimit;
    }

    public void setMinCommissionLimit(BigDecimal minCommissionLimit) {
        this.minCommissionLimit = minCommissionLimit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getOperatorAccountTier() {
        return operatorAccountTier;
    }

    public void setOperatorAccountTier(Integer operatorAccountTier) {
        this.operatorAccountTier = operatorAccountTier;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPermissionAccount() {
        return permissionAccount;
    }

    public void setPermissionAccount(Long permissionAccount) {
        this.permissionAccount = permissionAccount;
    }

    public Long getPermissionOperator() {
        return permissionOperator;
    }

    public void setPermissionOperator(Long permissionOperator) {
        this.permissionOperator = permissionOperator;
    }

    public BigDecimal getReservedFunds() {
        return reservedFunds;
    }

    public void setReservedFunds(BigDecimal reservedFunds) {
        this.reservedFunds = reservedFunds;
    }

    public BigDecimal getSelfExposure() {
        return selfExposure;
    }

    public void setSelfExposure(BigDecimal selfExposure) {
        this.selfExposure = selfExposure;
    }

    public boolean isSelfFunded() {
        return selfFunded;
    }

    public void setSelfFunded(boolean selfFunded) {
        this.selfFunded = selfFunded;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public BigDecimal getSubExposure() {
        return subExposure;
    }

    public void setSubExposure(BigDecimal subExposure) {
        this.subExposure = subExposure;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public BigDecimal getSuperAdminExposure() {
        return superAdminExposure;
    }

    public void setSuperAdminExposure(BigDecimal superAdminExposure) {
        this.superAdminExposure = superAdminExposure;
    }

    public Long getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(Long superAdminId) {
        this.superAdminId = superAdminId;
    }

    public BigDecimal getSuperMasterExposure() {
        return superMasterExposure;
    }

    public void setSuperMasterExposure(BigDecimal superMasterExposure) {
        this.superMasterExposure = superMasterExposure;
    }

    public Long getSuperMasterId() {
        return superMasterId;
    }

    public void setSuperMasterId(Long superMasterId) {
        this.superMasterId = superMasterId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getHierarchyType() {
        return hierarchyType;
    }

    public void setHierarchyType(Integer hierarchyType) {
        this.hierarchyType = hierarchyType;
    }

    public Boolean getIgnoreGeoBlocking() {
        return ignoreGeoBlocking;
    }

    public void setIgnoreGeoBlocking(Boolean ignoreGeoBlocking) {
        this.ignoreGeoBlocking = ignoreGeoBlocking;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "key=" + key +
                ", accPermissionAccountId=" + accPermissionAccountId +
                ", accPermissionPermission='" + accPermissionPermission + '\'' +
                ", accountType='" + accountType + '\'' +
                ", active=" + active +
                ", adminExposure=" + adminExposure +
                ", adminId=" + adminId +
                ", ageVerified=" + ageVerified +
                ", anomalousAlertEmails='" + anomalousAlertEmails + '\'' +
                ", appKeyId=" + appKeyId +
                ", balance=" + balance +
                ", commission=" + commission +
                ", contact=" + contact +
                ", created=" + created +
                ", currency='" + currency + '\'' +
                ", hidden=" + hidden +
                ", hierarchyType=" + hierarchyType +
                ", ignoreGeoBlocking=" + ignoreGeoBlocking +
                ", isActive=" + isActive +
                ", isConsentedToRules=" + isConsentedToRules +
                ", isHidden=" + isHidden +
                ", isSelfFunded=" + isSelfFunded +
                ", isUnderSelfFundedRestrictions=" + isUnderSelfFundedRestrictions +
                ", isVerified=" + isVerified +
                ", language='" + language + '\'' +
                ", lastActivity=" + lastActivity +
                ", lastActivityTimezone='" + lastActivityTimezone + '\'' +
                ", loginAttempts=" + loginAttempts +
                ", lossLimit=" + lossLimit +
                ", masterExposure=" + masterExposure +
                ", masterId=" + masterId +
                ", maxBetSize=" + maxBetSize +
                ", minBetSize=" + minBetSize +
                ", minCommissionLimit=" + minCommissionLimit +
                ", notes='" + notes + '\'' +
                ", operatorAccountTier=" + operatorAccountTier +
                ", originalId=" + originalId +
                ", parentId=" + parentId +
                ", password='" + password + '\'' +
                ", permissionAccount=" + permissionAccount +
                ", permissionOperator=" + permissionOperator +
                ", reservedFunds=" + reservedFunds +
                ", selfExposure=" + selfExposure +
                ", selfFunded=" + selfFunded +
                ", settings='" + settings + '\'' +
                ", subExposure=" + subExposure +
                ", subId=" + subId +
                ", superAdminExposure=" + superAdminExposure +
                ", superAdminId=" + superAdminId +
                ", superMasterExposure=" + superMasterExposure +
                ", superMasterId=" + superMasterId +
                ", username='" + username + '\'' +
                ", version=" + version +
                ", partnerId=" + partnerId +
                '}';
    }
}
