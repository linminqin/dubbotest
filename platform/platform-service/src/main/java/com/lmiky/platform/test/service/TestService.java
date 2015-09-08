/**
 *
 */
package com.lmiky.platform.test.service;

import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.service.BaseService;
import com.lmiky.platform.service.exception.ServiceException;
import com.lmiky.platform.sort.pojo.BaseSortPojo;
import com.lmiky.platform.tree.pojo.BaseTreePojo;

/**
 * 测试
 *
 * @author lmiky
 * @date 2015年9月7日 下午8:39:35
 */
public interface TestService extends BaseService {

    /**
     * 测试
     *
     * @author lmiky
     * @date 2015年9月7日 下午8:40:38
     * @param pojoClass
     * @throws ServiceException
     */
    public <T extends BasePojo> T test(Class<T> pojoClass) throws ServiceException;

    /**
     * 测试
     *
     * @param id
     * @return
     * @throws ServiceException
     * @author lmiky
     * @date 2015年9月8日 上午9:17:37
     */
    public BasePojo findPojo(Long id) throws ServiceException;
    
    /**
     * 测试
     *
     * @param id
     * @return
     * @throws ServiceException
     * @author lmiky
     * @date 2015年9月8日 上午9:17:37
     */
    public BaseSortPojo findSortPojo(Long id) throws ServiceException;
    
    /**
     * 测试
     *
     * @param id
     * @return
     * @throws ServiceException
     * @author lmiky
     * @date 2015年9月8日 上午9:17:37
     */
    public BaseTreePojo findTreePojo(Long id) throws ServiceException;
}
