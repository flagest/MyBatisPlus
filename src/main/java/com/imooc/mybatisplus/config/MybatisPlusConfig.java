package com.imooc.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wu on 2020/5/2 0002
 */
@Configuration
public class MybatisPlusConfig {
    public static ThreadLocal<String> mytableNmae = new ThreadLocal<String>();

  /*  //设置分页解析器
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> iSqlParsersList = new ArrayList<>();
        //多租户信息TenantSqlParser就设置完了
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }
            @Override
            public Expression getTenantId() {
                return new LongValue(1088248166370832385L);
            }
            @Override
            public boolean doTableFilter(String tableName) {
              *//*  if ("user".equals(tableName)) {
                    return true;
                }*//*
                return false;
            }
        });
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        HashMap<String, ITableNameHandler> tableNameHashMap = new HashMap<>();
        tableNameHashMap.put("user", (MetaObject metaObject, String sql, String tableName) -> {
            return mytableNmae.get();
        });

        //这是用lambda重构
        paginationInterceptor.setSqlParserFilter((MetaObject metaObject) -> {
                    MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                    if ("com.imooc.mybatisplus.dao.UserHighMapper.selectById".equals(ms.getId())) {
                        return true;
                    }
                    return false;
                }
        );
    *//*    paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                if ("com.imooc.mybatisplus.dao.UserHighMapper.selectById".equals(ms.getId())) {
                    return true;
                }
                return false;
            }
        });*//*
        iSqlParsersList.add(tenantSqlParser);
        iSqlParsersList.add(dynamicTableNameParser);
        paginationInterceptor.setSqlParserList(iSqlParsersList);

        return paginationInterceptor;
    }*/

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        performanceInterceptor.setMaxTime(50);
        return performanceInterceptor;
    }

}
