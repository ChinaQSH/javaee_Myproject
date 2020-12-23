package com.nylg.javaee.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            dataSource = new DruidDataSourceFactory().createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
public static Connection getConnection(boolean isTransactional) throws SQLException {
//        开启事务
        if (isTransactional){
//            使用ThreadLocal的特性
            Connection connection=threadLocal.get();
//            等于null时，取出数据
            if (connection==null){
                connection=getConnection();
                threadLocal.set(connection);
            }
            return connection;
        }
        return getConnection();
}
    /**
     * 改行代码需要在每次执行完事务之后调用一次
     */
    public static void releaseResources(){
        threadLocal.remove();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
