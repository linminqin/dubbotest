package com.lmiky.platform.database.datasource;

/**
 * 数据源管理器
 *
 * @author lmiky
 * @date 2015年9月7日 下午2:02:23
 */
public class DynamicDataSourceHolder {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 数据源名称
     */
    public static final String DATASOURCE_WRITE = "write";
    public static final String DATASOURCE_READ = "read";

    /**
     * 设置当前数据源
     *
     * @param name 数据源名称
     * @author lmiky
     * @date 2015年9月7日 下午2:02:50
     */
    public static void putDataSource(String name) {
        holder.set(name);
    }

    /**
     * 获取当前数据源
     *
     * @return
     * @author lmiky
     * @date 2015年9月7日 下午2:03:03
     */
    public static String getDataSouce() {
        return holder.get();
    }

    /**
     * 重置
     *
     * @author lmiky
     * @date 2015年9月7日 下午3:32:40
     */
    public static void reset() {
        holder.set(null);
    }

    /**
     * 设置读数据源
     *
     * @author lmiky
     * @date 2015年9月7日 下午3:35:11
     */
    public static void putReadDateSource() {
        putDataSource(DATASOURCE_READ);
    }

    /**
     * 设置写数据源
     *
     * @author lmiky
     * @date 2015年9月7日 下午3:35:11
     */
    public static void putWriteDateSource() {
        putDataSource(DATASOURCE_WRITE);
    }

    /**
     * 判断当前是否只读数据源
     *
     * @return
     * @author lmiky
     * @date 2015年9月7日 下午5:42:00
     */
    public static boolean isReadDateSource() {
        String datasource = getDataSouce();
        if (datasource == null) {
            return false;
        }
        return datasource.endsWith(DATASOURCE_READ);
    }
}
