package com.wargamecampaign.repository;

import com.wargamecampaign.model.AuthorityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 3/25/20にjohnpolhilによって作成されました。
 */
@Repository
public class AuthorityRepository extends  WargameCampaignEntityRepository<AuthorityEntity> {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    public AuthorityRepository() {
        this.setClazz(AuthorityEntity.class);
    }
}
