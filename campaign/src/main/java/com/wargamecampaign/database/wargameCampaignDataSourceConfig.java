package com.wargamecampaign.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 2/24/20にjohnpolhilによって作成されました。
 */
@Configuration
@ConfigurationProperties(prefix = "wargamecampaign.db")
@EnableTransactionManagement
@Lazy
public class wargameCampaignDataSourceConfig extends HikariConfig {

    @Bean(destroyMethod = "close", name = "wargame_campaign_data_source")
    DataSource pulseDataSource() {
        return new HikariDataSource(this);
    }

    @Bean(name = "wargameCampaignJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
            @Qualifier("wargame_campaign_data_source") DataSource pulseDataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(pulseDataSource));
    }

}
