package com.test.plugins;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author Administrator
 * @Date 2020/5/18 21:42
 */
@Intercepts({
        @Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class}),
        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})
})
public class SubmeterInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        final Object[] queryArgs = invocation.getArgs();
        final MappedStatement mappedStatement = (MappedStatement) queryArgs[0];
        final Object parameter = queryArgs[1];
        final BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String originalSql = boundSql.getSql();
        //将原始sql中的空白字符（\s包括换行符，制表符，空格符）替换为" "
        originalSql = originalSql.replaceAll("[\\s]+", " ");
        //只获取sql的select/update/insert/delete开头的sql
        int index = indexOfSqlStart(originalSql);
        // 拿到参数
        Date date = (Date) ((MapperMethod.ParamMap) parameter).get("feeDate");
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        String tableName = " fee_"+year+month+" ";
        originalSql = originalSql.replaceAll(" fee ", tableName);
        if (index > 0) {
            originalSql = originalSql.substring(index);
        }
        if (index > 0) {
            originalSql = originalSql.substring(index);
        }
        System.out.println("获取到SQL语句"+originalSql);
        SqlSource sqlSource = new StaticSqlSource(mappedStatement.getConfiguration(), originalSql, boundSql.getParameterMappings());
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(mappedStatement, sqlSource);
        return invocation.proceed();

    }

    /**
     * 获取sql语句开头部分
     *
     * @param sql
     * @return
     */
    private int indexOfSqlStart(String sql) {
        String upperCaseSql = sql.toUpperCase();
        Set<Integer> set = new HashSet<>();
        set.add(upperCaseSql.indexOf("SELECT "));
        set.add(upperCaseSql.indexOf("UPDATE "));
        set.add(upperCaseSql.indexOf("INSERT "));
        set.add(upperCaseSql.indexOf("DELETE "));
        set.remove(-1);
        if (CollectionUtils.isEmpty(set)) {
            return -1;
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list.get(0);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
