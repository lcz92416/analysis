package cn.com.betasoft.saas.analysis.annotation;

import cn.com.betasoft.saas.analysis.datasource.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by lichenzhe on 2017/12/11
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时可见
@Target(ElementType.METHOD) // 注解可以用在方法上
public @interface DataSourceTypeAnno {
    DataSourceEnum value() default DataSourceEnum.mysql;
}
