/**
 *
 */
package com.lmiky.platform.test.service.impl;

import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.service.exception.ServiceException;
import com.lmiky.platform.service.impl.BaseServiceImpl;
import com.lmiky.platform.sort.pojo.BaseSortPojo;
import com.lmiky.platform.test.service.TestService;
import com.lmiky.platform.tree.pojo.BaseTreePojo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 测试
 *
 * @author lmiky
 * @date 2015年9月7日 下午8:42:15
 */
@Service("testService")
public class TestServiceImpl extends BaseServiceImpl implements TestService {

    /*
     * (non-Javadoc)
     * @see com.lmiky.platform.test.TestService#test(java.lang.Class)
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public <T extends BasePojo> T test(Class<T> pojoClass) throws ServiceException {
        List<T> pojos = list(pojoClass);
        if (pojos.size() > 0) {
            BasePojo basePojo = pojos.get(0);
            update(pojoClass, basePojo.getId(), BasePojo.POJO_FIELD_NAME_ID, basePojo.getId() + 1000);
            basePojo = find(pojoClass, basePojo.getId() + 1000);
            System.out.println(basePojo.getId());
        }
        pojos = list(pojoClass);
        if (pojos.size() > 0) {
            return find(pojoClass, pojos.get(0).getId());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see com.lmiky.platform.test.service.TestService#findPojo(java.lang.Long)
     */
    @Override
    @Transactional(readOnly = true)
    public BasePojo findPojo(Long id) throws ServiceException {
        BasePojo pojo = find(BaseTreePojo.class, id);
        return pojo;
        // return find(BaseTreePojo.class, id);
    }

    /* (non-Javadoc)
     * @see com.lmiky.platform.test.service.TestService#findSortPojo(java.lang.Long)
     */
    @Override
    @Transactional(readOnly = true)
    public BaseSortPojo findSortPojo(Long id) throws ServiceException {
        BaseSortPojo pojo = new BaseSortPojo();
        pojo.setId(11111l);
        pojo.setSort(11111);
        return pojo;
    }

    /* (non-Javadoc)
     * @see com.lmiky.platform.test.service.TestService#findTreePojo(java.lang.Long)
     */
    @Override
    @Transactional(readOnly = true)
    public BaseTreePojo findTreePojo(Long id) throws ServiceException {
        BaseTreePojo pojo = new BaseTreePojo();
        pojo.setId(11111l);
        pojo.setSort(11111);
        pojo.setName("test");
        return pojo;
    }

}
