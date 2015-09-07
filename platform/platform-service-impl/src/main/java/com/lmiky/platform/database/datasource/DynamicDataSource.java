package com.lmiky.platform.database.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author lmiky
 * @date 2015年9月7日 下午2:01:31
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /*
     * (non-Javadoc)
     * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSouce();
    }

}
