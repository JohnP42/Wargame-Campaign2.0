package com.wargamecampaign.service;

import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountEntity get(int id) {
        return repository.get(id);
    }

    public AccountEntity create(AccountEntity accountEntity) throws SQLException {
        return repository.create(accountEntity);
    }

}
