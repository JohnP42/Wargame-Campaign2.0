package com.wargamecampaign.service;

import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Service
public class AccountService {

    AccountRepository repository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountEntity create(AccountEntity accountEntity) throws SQLException {
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        return repository.create(accountEntity);
    }

}
