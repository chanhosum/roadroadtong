package com.mountbet.accountservice.service;

import com.mountbet.accountservice.dto.InsertAccount;
import com.mountbet.accountservice.dto.InsertAccountList;
import com.mountbet.accountservice.dto.InsertAccountPermission;
import com.mountbet.accountservice.entity.Account;
import com.mountbet.accountservice.entity.key.AccountKey;
import com.mountbet.accountservice.entity.udt.AccountContactDetail;
import com.mountbet.accountservice.entity.udt.AccountPermission;
import com.mountbet.accountservice.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AnsonChan
 * @since 10/7/2018
 */
@Service
@Transactional
public class AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public void RESTful(InsertAccountList insertAccountList) {
        for (InsertAccount insertAccount : insertAccountList.getInsertAccountList()) {
            Account account = new Account();

            AccountKey accountKey = new AccountKey();
            accountKey.setAccountId(insertAccount.getAccountId());
            account.setKey(accountKey);

            Set<AccountPermission> accountPermissionSet = new HashSet<>();
            for (InsertAccountPermission insertAccountPermission : insertAccount.getAccountPermissions()) {
                AccountPermission accountPermission = new AccountPermission();
                accountPermission.setAccountId(insertAccountPermission.getAccountId());
                accountPermission.setPermission(insertAccountPermission.getPermission());
                accountPermissionSet.add(accountPermission);
            }
            account.setAccountPermissions(accountPermissionSet);

            account.setAccountType(insertAccount.getAccountType());
            account.setActive(insertAccount.getActive());
            account.setAdminExposure(insertAccount.getAdminExposure());
            account.setAdminId(insertAccount.getAdminId());
            account.setAgeVerified(insertAccount.getAgeVerified());
            account.setAnomalousAlertEmails(insertAccount.getAnomalousAlertEmails());
            account.setAppKeyId(insertAccount.getAppKeyId());
            account.setBalance(insertAccount.getBalance());
            account.setCommission(insertAccount.getCommission());

            AccountContactDetail accountContactDetail = new AccountContactDetail();
            accountContactDetail.setFirstName(insertAccount.getContact().getFirstName());
            accountContactDetail.setLastName(insertAccount.getContact().getLastName());
            accountContactDetail.setEmail(insertAccount.getContact().getEmail());
            accountContactDetail.setPhoneNumber(insertAccount.getContact().getPhoneNumber());
            accountContactDetail.setCountry(insertAccount.getContact().getCountry());
            accountContactDetail.setCity(insertAccount.getContact().getCity());
            accountContactDetail.setState(insertAccount.getContact().getState());
            accountContactDetail.setPostCode(insertAccount.getContact().getPostCode());
            accountContactDetail.setCasinoNickname(insertAccount.getContact().getCasinoNickname());
            accountContactDetail.setAddressLine1(insertAccount.getContact().getAddressLine1());
            accountContactDetail.setAddressLine2(insertAccount.getContact().getAddressLine2());
            accountContactDetail.setDateOfBirth(insertAccount.getContact().getDateOfBirth());
            account.setContact(accountContactDetail);

            account.setCreated(insertAccount.getCreated());
            account.setCurrency(insertAccount.getCurrency());
            account.setHidden(insertAccount.getHidden());
            account.setHierarchyType(insertAccount.getHierarchyType());
            account.setIgnoreGeoBlocking(insertAccount.getIgnoreGeoBlocking());
            account.setIsActive(insertAccount.getIsActive());
            account.setConsentedToRules(insertAccount.getConsentedToRules());
            account.setIsHidden(insertAccount.getIsHidden());
            account.setIsSelfFunded(insertAccount.getIsSelfFunded());
            account.setUnderSelfFundedRestrictions(insertAccount.getUnderSelfFundedRestrictions());
            account.setVerified(insertAccount.getVerified());
            account.setLanguage(insertAccount.getLanguage());
            account.setLastActivity(insertAccount.getLastActivity());
            account.setLastActivityTimezone(insertAccount.getLastActivityTimezone());
            account.setLoginAttempts(insertAccount.getLoginAttempts());
            account.setLossLimit(insertAccount.getLossLimit());
            account.setMasterExposure(insertAccount.getMasterExposure());
            account.setMasterId(insertAccount.getMasterId());
            account.setMaxBetSize(insertAccount.getMaxBetSize());
            account.setMinBetSize(insertAccount.getMinBetSize());
            account.setMinCommissionLimit(insertAccount.getMinCommissionLimit());
            account.setNotes(insertAccount.getNotes());
            account.setOperatorAccountTier(insertAccount.getOperatorAccountTier());
            account.setParentId(insertAccount.getParentId());
            account.setPartnerId(insertAccount.getPartnerId());
            account.setPassword(insertAccount.getPassword());
            account.setPermissionAccount(insertAccount.getPermissionAccount());
            account.setPermissionOperator(insertAccount.getPermissionOperator());
            account.setReservedFunds(insertAccount.getReservedFunds());
            account.setSelfExposure(insertAccount.getSelfExposure());
            account.setSelfFunded(insertAccount.getIsSelfFunded());
            account.setSettings(insertAccount.getSettings());
            account.setSubExposure(insertAccount.getSubExposure());
            account.setSubId(insertAccount.getSubId());
            account.setSuperAdminExposure(insertAccount.getSuperAdminExposure());
            account.setSuperAdminId(insertAccount.getSuperAdminId());
            account.setSuperMasterExposure(insertAccount.getSuperMasterExposure());
            account.setSuperMasterId(insertAccount.getSuperMasterId());
            account.setUsername(insertAccount.getUsername());
            account.setVersion(insertAccount.getVersion());

            accountRepository.insert(account);
        }
    }
}
