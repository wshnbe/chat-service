package com.chat.letter.datasource;

/**
 * 数据源切换开关
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void setMaster(){
        threadLocal.set(DataSourceConfig.MASTER);
    }

    public static void setSlave(){
        threadLocal.set(DataSourceConfig.SLAVE);
    }

    public static void removeDataSource(){
        threadLocal.remove();
    }
}
