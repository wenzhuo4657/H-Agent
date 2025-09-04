package cn.wenzhuo4657.ai.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class MultiDataSourceConfig {

    @Bean("mysqlDataSource")
    @Primary

    public DataSource primaryDataSource(
            @Value("${spring.datasource.mysql.username}") String username,
            @Value("${spring.datasource.mysql.password}") String password,
            @Value("${spring.datasource.mysql.url}") String url,
            @Value("${spring.datasource.mysql.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.mysql.hikari.pool-name}") String poolName,
            @Value("${spring.datasource.mysql.hikari.minimum-idle}") String minimumIdle,
            @Value("${spring.datasource.mysql.hikari.idle-timeout}") String idleTimeout ,
            @Value("${spring.datasource.mysql.hikari.maximum-pool-size}") String maximumPoolSize,
            @Value("${spring.datasource.mysql.hikari.auto-commit}") String autoCommit,
            @Value("${spring.datasource.mysql.hikari.max-lifetime}") String maxLifetime,
            @Value("${spring.datasource.mysql.hikari.connection-timeout}") String connectioTimeout,
            @Value("${spring.datasource.mysql.hikari.connection-test-query}") String connectionTestQuery
    ) {
        HikariDataSource dataSource=new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setPoolName(poolName);
        dataSource.setMinimumIdle(Integer.parseInt(minimumIdle));
        dataSource.setIdleTimeout(Integer.parseInt(idleTimeout));
        dataSource.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
        dataSource.setAutoCommit(Boolean.parseBoolean(autoCommit));
        dataSource.setMaxLifetime(Integer.parseInt(maxLifetime));
        dataSource.setConnectionTimeout(Integer.parseInt(connectioTimeout));
        dataSource.setConnectionTestQuery(connectionTestQuery);


        return dataSource;
    }

    @Bean("pgVectorDataSource")
    public DataSource pgVectorDataSource(
            @Value("${spring.datasource.pgvector.username}") String username,
            @Value("${spring.datasource.pgvector.password}") String password,
            @Value("${spring.datasource.pgvector.url}") String url,
            @Value("${spring.datasource.pgvector.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.pgvector.hikari.pool-name}") String poolName,
            @Value("${spring.datasource.pgvector.hikari.minimum-idle}") String minimumIdle,
            @Value("${spring.datasource.pgvector.hikari.idle-timeout}") String idleTimeout ,
            @Value("${spring.datasource.pgvector.hikari.maximum-pool-size}") String maximumPoolSize,
            @Value("${spring.datasource.pgvector.hikari.auto-commit}") String autoCommit,
            @Value("${spring.datasource.pgvector.hikari.max-lifetime}") String maxLifetime,
            @Value("${spring.datasource.pgvector.hikari.connection-timeout}") String connectioTimeout,
            @Value("${spring.datasource.pgvector.hikari.connection-test-query}") String connectionTestQuery
    ) {
        HikariDataSource dataSource=new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setPoolName(poolName);
        dataSource.setMinimumIdle(Integer.parseInt(minimumIdle));
        dataSource.setIdleTimeout(Integer.parseInt(idleTimeout));
        dataSource.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
        dataSource.setAutoCommit(Boolean.parseBoolean(autoCommit));
        dataSource.setMaxLifetime(Integer.parseInt(maxLifetime));
        dataSource.setConnectionTimeout(Integer.parseInt(connectioTimeout));
        dataSource.setConnectionTestQuery(connectionTestQuery);


        return dataSource;
    }


    @Bean("pgVectorJdbcTemplate")
    public JdbcTemplate pgVectorJdbcTemplate(@Qualifier("pgVectorDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);

        // 设置MyBatis配置文件位置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis/config/mybatis-config.xml"));

        // 设置Mapper XML文件位置
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*.xml"));

        return sqlSessionFactoryBean;
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate( SqlSessionFactoryBean sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(Objects.requireNonNull(sqlSessionFactory.getObject()));
    }
}
