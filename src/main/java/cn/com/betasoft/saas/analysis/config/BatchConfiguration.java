package cn.com.betasoft.saas.analysis.config;

import cn.com.betasoft.saas.analysis.annotation.DataSourceTypeAnno;
import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;
import cn.com.betasoft.saas.analysis.model.SysUserModel;
import cn.com.betasoft.saas.analysis.processor.SysUserProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * created by lichenzhe on 2017/12/15
 */
//@Configuration
//@EnableBatchProcessing
//@ComponentScan(basePackageClasses = DefaultBatchConfigurer.class)
public class BatchConfiguration {
    private static final String SELECT_REGISTERS_COUNT = "SELECT  TO_CHAR(TO_TIMESTAMP(CREATETIME/1000::BIGINT), 'YYYY-MM-DD') AS D ,  COUNT(*)  FROM  SAAS_COMMUNITY_USERINFO  GROUP BY D ORDER BY D;";
    private static final String INSERT_REGISTERS_COUNT  = "INSERT INTO  (count,registerDate,analysisDate) VALUES ()";

    @Bean
//    @StepScope
    @DataSourceTypeAnno(DataSourceEnum.pgsql)
    public ItemReader<SysUserModel> reader(DataSource dataSource) {
        JdbcPagingItemReader<SysUserModel> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);

        reader.setQueryProvider(new MySqlPagingQueryProvider() {{
            setSelectClause(SELECT_REGISTERS_COUNT);
//            setFromClause("from people");
//            setWhereClause("last_name=:lastName");
//            setGroupClause("");
            setSortKeys(new HashMap<String, Order>() {{
                put("id", Order.ASCENDING);
            }});
        }});
//        reader.setParameterValues(new HashMap<String, Object>() {{
//            put("lastName", "DOE");
//        }});
        reader.setRowMapper(new BeanPropertyRowMapper<>(SysUserModel.class));
        return reader;
    }
    //2.处理数据
    @Bean
//    @StepScope
    public SysUserProcessor processor() {
        return new SysUserProcessor();
    }
    //3.写数据
    @Bean
//    @StepScope
    @DataSourceTypeAnno(DataSourceEnum.mysql)
    public ItemWriter<SysUserModel> writer(DataSource dataSource) {
        JdbcBatchItemWriter<SysUserModel> writer = new JdbcBatchItemWriter<SysUserModel>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<SysUserModel>());
        writer.setSql(INSERT_REGISTERS_COUNT);
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]


    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobBuilderFactory jobs, @Qualifier("step1")Step s1, JobExecutionListener listener) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<SysUserModel> reader,
                      ItemWriter<SysUserModel> writer, ItemProcessor<SysUserModel, SysUserModel> processor) {
        return stepBuilderFactory.get("step1")
                .<SysUserModel, SysUserModel> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    // end::jobstep[]
}
