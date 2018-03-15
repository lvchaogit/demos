package com.lc.demo.multidata.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据源配置类
 * 自定义数据源需要自定义DataSource,SqlSessionFactory,DataSourceTransactionManager,SqlSessionTemplate
 * @MapperScan 用于指定对应的mapper接口包及SqlSessionTemplate
 */
@Configuration
@MapperScan(basePackages = "com.lc.demo.multidata.mapper.base", sqlSessionTemplateRef = "baseSqlSessionTemplate")
public class BaseDataSourceConfig {

    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.basedt")
    @Primary
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "baseTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/base/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
 