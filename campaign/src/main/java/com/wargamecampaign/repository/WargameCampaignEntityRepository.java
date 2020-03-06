package com.wargamecampaign.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wargamecampaign.model.WargameCampaignEntity;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 3/4/20にjohnpolhilによって作成されました。
 */
@Slf4j
@Transactional
abstract public class WargameCampaignEntityRepository<T extends WargameCampaignEntity> {
    private Class<T> clazz;
    private String clazzName;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    protected ObjectMapper simpleObjectMapper;

    public T get(int id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<T> results = executeQuery("where id = :id", paramMap);
        return results.size() == 0 ? null : results.get(0);
    }

    public T getLast() {
        Map<String, Object> paramMap = new HashMap<>();
        List<T> results = executeQuery("order by id desc limit 1;", paramMap);
        return results.size() == 0 ? null : results.get(0);
    }

    public T create(T entity) throws SQLException {
        entity.setCreatedAt(new DateTime(new Date().getTime()));
        entity.setUpdatedAt(new DateTime(new Date().getTime()));
        Map<String, Object> paramMap = simpleObjectMapper.convertValue(entity, new TypeReference<>() {});
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(clazzName).append(" (");
        StringBuilder values = new StringBuilder("(");

        Iterator iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            sql.append(key);
            values.append(":").append(key);
            if (iterator.hasNext()) {
                sql.append(",");
                values.append(",");
            } else {
                sql.append(")");
                values.append(");");
            }
        }
        sql.append( " values ").append(values);

        log.debug("Executing Query: " + sql.toString() + "\n" +
                "With parameters: " + paramMap);

        if (namedParameterJdbcTemplate.update(sql.toString(), paramMap) == 1) {
            return getLast();
        } else {
            throw new SQLException("Failed to create row in database");
        }
    }

    void setClazz(Class<T> clazz) {
        this.clazz = clazz;
        clazzName = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1, clazz.getName().lastIndexOf("Entity")).toLowerCase();
    }

    List<T> executeQuery(String sql, Map<String, Object> paramMap) {
        StringBuilder stringBuilder = new StringBuilder("select * from ");
        stringBuilder.append(clazzName).append(" ");
        sql = stringBuilder.append(sql).append(";").toString();

        log.debug("Executing Query: " + sql + "\n" +
                "With parameters: " + paramMap);

        return namedParameterJdbcTemplate.queryForList(sql, paramMap)
                .stream().map(r -> simpleObjectMapper.convertValue(r, clazz)).collect(Collectors.toList());
    }
}
