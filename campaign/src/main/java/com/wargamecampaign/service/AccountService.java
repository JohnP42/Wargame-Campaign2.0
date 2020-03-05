package com.wargamecampaign.service;

import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountEntity get(int id) {
        return  repository.get(id);
    }

    public AccountEntity create() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setEmail("chesterTheMatester@gmail.com");
        accountEntity.setUsername("ChesterMatester");
        accountEntity.setPassword("password1234");
        repository.create(accountEntity);
        return accountEntity;
    }

}
