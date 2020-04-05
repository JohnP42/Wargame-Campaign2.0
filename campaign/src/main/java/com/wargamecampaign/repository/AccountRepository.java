package com.wargamecampaign.repository;

import com.wargamecampaign.model.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 3/1/20にjohnpolhilによって作成されました。
 */
@Repository
public class AccountRepository extends WargameCampaignEntityRepository<AccountEntity> {
    @Autowired
    public AccountRepository() {
        this.setClazz(AccountEntity.class);
    }
}
