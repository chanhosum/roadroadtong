package com.mountbet.accountservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class InsertAccount {

    private Long accountId;

    private Set<InsertAccountPermission> accountPermissions;

    private String accountType;

    private Boolean active;

    private BigDecimal adminExposure;

    private Long adminId;

    private Boolean ageVerified;

    private String anomalousAlertEmails;

    private Set<String> appKeyId;

    private BigDecimal balance;

    private BigDecimal commission;

    private InsertAccountContactDetail contact;

    private Date created;

    private String currency;

    private Boolean hidden;

    private Integer hierarchyType;

    private Boolean ignoreGeoBlocking;

    private Boolean isActive;

    private Boolean isConsentedToRules;

    private Boolean isHidden;

    private Boolean isSelfFunded;

    private Boolean isUnderSelfFundedRestrictions;

    private Boolean isVerified;

    private String language;

    private Date lastActivity;

    private String lastActivityTimezone;

    private Integer loginAttempts;

    private BigDecimal lossLimit;

    private BigDecimal masterExposure;

    private Long masterId;

    private BigDecimal maxBetSize;

    private BigDecimal minBetSize;

    private BigDecimal minCommissionLimit;

    private String notes;

    private Integer operatorAccountTier;

    private Long parentId;

    private String password;

    private Long permissionAccount;

    private Long permissionOperator;

    private BigDecimal reservedFunds;

    private BigDecimal selfExposure;

    private boolean selfFunded;

    private String settings;

    private BigDecimal subExposure;

    private Long subId;

    private BigDecimal superAdminExposure;

    private Long superAdminId;

    private BigDecimal superMasterExposure;

    private Long superMasterId;

    private String username;

    private Long version;

    private Integer partnerId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


    public Set<InsertAccountPermission> getAccountPermissions() {
        return accountPermissions;
    }

    public void setAccountPermissions(Set<InsertAccountPermission> accountPermissions) {
        this.accountPermissions = accountPermissions;
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

    public InsertAccountContactDetail getContact() {
        return contact;
    }

    public void setContact(InsertAccountContactDetail contact) {
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

    public Boolean getIsSelfFunded() {
        return isSelfFunded;
    }

    public void setIsSelfFunded(Boolean selfFunded) {
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

    public boolean getSelfFunded() {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @Override
    public String toString() {
        return "InsertAccount{" +
                "accountId=" + accountId +
                ", accountPermissions=" + accountPermissions +
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
