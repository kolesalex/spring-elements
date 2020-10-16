package xyz.kolesa.spring.elements.bpp.sqlautowire;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class Dao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @SqlAutowire("selectConstant.sql")
    private String query;


    public String select(){
        return jdbcTemplate.queryForObject(query, (SqlParameterSource) null, String.class);
    }
}
