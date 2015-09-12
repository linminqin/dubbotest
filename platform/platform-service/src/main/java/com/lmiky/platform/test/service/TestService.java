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
     * 测试事务
     *
     * @author lmiky
     * @date 2015年9月7日 下午8:40:38
     * @param pojoClass
     * @throws ServiceException
     */
    public <T extends BasePojo> T testTx(Class<T> pojoClass) throws ServiceException;

    /**
     * 测试分布式事务
     *
     * @author lmiky
     * @date 2015年9月7日 下午8:40:38
     * @param pojoClass
     * @throws ServiceException
     */
    public <T extends BasePojo> T testXATx(Class<T> pojoClass) throws ServiceException;

    /**
     * 测试
     *
     * @param id
     * @return
     * @throws ServiceException
     * @author lmiky
     * @date 2015年9月8日 上午9:17:37
     */
    public <T extends BasePojo> T findPojo(Long id) throws ServiceException;

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

    /**
     * 测试缓存
     *
     * @param id
     * @return
     * @author lmiky
     * @date 2015年9月12日 上午11:48:51
     */
    public BaseTreePojo testCache(Long id);
}
