package cn.com.betasoft.saas.analysis.config;

/**
 * created by lichenzhe on 2017/12/11
 */

import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration // 该注解类似于spring配置文件
@MapperScan(basePackages = "cn.com.betasoft.saas.analysis.mapper")
public class MyBatisConfig{

    /**
     * @return
     * @throws Exception
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Primary
    @Bean("mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }

//    @Bean("pgsqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.pgsql")
//    public DataSource pgsqlDataSource() throws Exception {
//        return DataSourceBuilder.create().build();
//    }

    /**
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("mysqlDataSource") DataSource mysqlDataSource
//            ,@Qualifier("pgsqlDataSource") DataSource pgsqlDataSource
    ) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceEnum.mysql, mysqlDataSource);
//        targetDataSources.put(DataSourceEnum.pgsql, pgsqlDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(mysqlDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource,
                                               @Value("mybatis.typeAliasesPackage") String typeAliasesPackage,
                                               @Value("mybatis.mapperLocations") String mapperLocations) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);// 指定基包
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
        return factoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}