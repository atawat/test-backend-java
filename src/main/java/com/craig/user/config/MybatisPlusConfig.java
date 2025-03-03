package com.craig.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

@Configuration
@MapperScan("com.craig.user.mapper")
public class MybatisPlusConfig {
    /**
     * regist page interceptor to mybatis plus interceptor
     * @param paginationInnerInterceptor page interceptor
     * @return mybatis plus interceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor) {
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        mpInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mpInterceptor;
    }

    /**
     * mybatis pagination interceptor
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        interceptor.setMaxLimit(20L);
        interceptor.setDbType(DbType.MYSQL);
        interceptor.setOverflow(true);
        return interceptor;
    }
}
