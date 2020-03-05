package com.wargamecampaign.configuration.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 2/24/20にjohnpolhilによって作成されました。
 */
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "wargamecampaign.db")
@EnableTransactionManagement
public class WargameCampaignDataSourceConfig extends HikariConfig {

    @Bean
    public HikariDataSource wargameCampaignDataSource() {
        HikariDataSource dataSource = new HikariDataSource(this);
        log.info("Established connection with database.");
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(wargameCampaignDataSource());
    }

    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(wargameCampaignDataSource());
    }
}
