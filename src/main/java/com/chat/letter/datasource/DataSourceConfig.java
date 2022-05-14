package com.chat.letter.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    static final String PACKAGE = "com.chat.letter.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*Mapper.xml";
    static final String MASTER="master";
    static final String SLAVE="slave";


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.multidata.masterdatabsource")
    public DataSource masterDataSource() {
       return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.multidata.slavedatabsource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name="dynamicDataSource")
    public DataSource getDataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(masterDataSource());
        HashMap<Object,Object> hd = new HashMap<>();
        hd.put(DataSourceConfig.MASTER,masterDataSource());
        hd.put(DataSourceConfig.SLAVE,slaveDataSource());
        dataSource.setTargetDataSources(hd);
        return dataSource;
    }
}
