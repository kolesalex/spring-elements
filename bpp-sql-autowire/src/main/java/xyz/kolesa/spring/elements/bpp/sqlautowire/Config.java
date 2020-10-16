package xyz.kolesa.spring.elements.bpp.sqlautowire;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class Config {

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplateUi(DataSource dsUi) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dsUi));
    }
}
