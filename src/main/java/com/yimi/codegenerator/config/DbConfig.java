package com.yimi.codegenerator.config;

import com.yimi.codegenerator.dao.*;
import com.yimi.codegenerator.exception.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author dengqiao
 * @date 2019-09-17 09:29
 */
@Configuration
public class DbConfig {
    @Value("${yimi.database}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;

    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao() {
        if ("mysql".equalsIgnoreCase(this.database))
            return this.mySQLGeneratorDao;
        if ("oracle".equalsIgnoreCase(this.database))
            return this.oracleGeneratorDao;
        if ("sqlserver".equalsIgnoreCase(this.database))
            return this.sqlServerGeneratorDao;
        if ("postgresql".equalsIgnoreCase(this.database)) {
            return this.postgreSQLGeneratorDao;
        }
        throw new RRException("不支持当前数据库：" + this.database);
    }
}
