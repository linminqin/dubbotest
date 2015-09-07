/**
 * 
 */
package com.lmiky.platform.test.service;

import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.service.BaseService;
import com.lmiky.platform.service.exception.ServiceException;

/**
 * 测试
 * @author lmiky
 * @date 2015年9月7日 下午8:39:35
 */
public interface TestService extends BaseService {

    /**
     * 测试
     * @author lmiky
     * @date 2015年9月7日 下午8:40:38
     * @param pojoClass
     * @throws ServiceException
     */
    public <T extends BasePojo> T test(Class<T> pojoClass) throws ServiceException;

}
