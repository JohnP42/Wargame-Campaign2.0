package com.wargamecampaign.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 2/24/20にjohnpolhilによって作成されました。
 */
@Service
public class wargameCampaignDbService {

    @Autowired
    NamedParameterJdbcTemplate pulseJdbcTemplate;
}
