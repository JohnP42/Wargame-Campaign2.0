package com.wargamecampaign.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 2/28/20にjohnpolhilによって作成されました。
 */
@Repository
public class UserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

}
