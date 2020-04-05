package com.wargamecampaign.service;

import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.model.AuthorityEntity;
import com.wargamecampaign.repository.AccountRepository;
import com.wargamecampaign.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Service
@Transactional
public class AccountService {

    AccountRepository repository;
    AuthorityRepository authorityRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository repository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    public AccountEntity create(AccountEntity accountEntity) throws SQLException {
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setUsername(accountEntity.getUsername());
        authorityEntity.setAuthorities(AuthorityRepository.ROLE_USER);
        AccountEntity result = repository.create(accountEntity);
        authorityRepository.create(authorityEntity);
        return result;
    }

}
