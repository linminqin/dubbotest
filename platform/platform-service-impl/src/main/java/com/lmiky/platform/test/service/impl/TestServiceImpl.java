/**
 *
 */
package com.lmiky.platform.test.service.impl;

import com.lmiky.platform.database.dao.BaseDAO;
import com.lmiky.platform.database.pojo.BasePojo;
import com.lmiky.platform.service.exception.ServiceException;
import com.lmiky.platform.service.impl.BaseServiceImpl;
import com.lmiky.platform.sort.pojo.BaseSortPojo;
import com.lmiky.platform.test.service.TestService;
import com.lmiky.platform.tree.pojo.BaseTreePojo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author lmiky
 * @date 2015年9月7日 下午8:42:15
 */
@Service("testService")
public class TestServiceImpl extends BaseServiceImpl implements TestService {
    private BaseDAO xaBaseDAO;
    private BaseDAO otherXABaseDAO;


    /* (non-Javadoc)
     * @see com.lmiky.platform.test.service.TestService#testTx(java.lang.Class)
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public <T extends BasePojo> T testTx(Class<T> pojoClass) throws ServiceException {
        T ret = null;
        List<T> pojos = baseDAO.list(pojoClass);
        if (pojos.size() > 0) {
            BasePojo basePojo = pojos.get(0);
            baseDAO.update(pojoClass, basePojo.getId(), BasePojo.POJO_FIELD_NAME_ID, basePojo.getId() + 1000);
            ret = baseDAO.find(pojoClass, basePojo.getId() + 1000);
        }
//      int i = 1;
//      i = i/0;
        pojos = baseDAO.list(pojoClass);
        if (pojos.size() > 0) {
            BasePojo basePojo = pojos.get(0);
            baseDAO.update(pojoClass, basePojo.getId(), BasePojo.POJO_FIELD_NAME_ID, basePojo.getId() + 1000);
            ret = baseDAO.find(pojoClass, basePojo.getId() + 1000);
        }
//         int i = 1;
//         i = i/0;
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see com.lmiky.platform.test.TestService#testXATx(java.lang.Class)
     */
    @Override
    @Transactional(rollbackFor = { Exception.class }, value="jtaTransactionManager")
    public <T extends BasePojo> T testXATx(Class<T> pojoClass) throws ServiceException {
        T ret = null;
        List<T> pojos = xaBaseDAO.list(pojoClass);
        if (pojos.size() > 0) {
            BasePojo basePojo = pojos.get(0);
            xaBaseDAO.update(pojoClass, basePojo.getId(), BasePojo.POJO_FIELD_NAME_ID, basePojo.getId() + 1000);
            ret = xaBaseDAO.find(pojoClass, basePojo.getId() + 1000);
        }
//      int i = 1;
//      i = i/0;
        pojos = otherXABaseDAO.list(pojoClass);
        if (pojos.size() > 0) {
            BasePojo basePojo = pojos.get(0);
            otherXABaseDAO.update(pojoClass, basePojo.getId(), BasePojo.POJO_FIELD_NAME_ID, basePojo.getId() + 1000);
            ret = otherXABaseDAO.find(pojoClass, basePojo.getId() + 1000);
        }
//         int i = 1;
//         i = i/0;
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see com.lmiky.platform.test.service.TestService#findPojo(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public <T extends BasePojo> T findPojo(Long id) throws ServiceException {
        BasePojo pojo = find(BaseTreePojo.class, id);
        pojo = new BasePojo();
        pojo.setId(111l);
        return (T) pojo;
        // return find(BaseTreePojo.class, id);
    }

    /*
     * (non-Javadoc)
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

    /*
     * (non-Javadoc)
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

    /**
     * @return the xaBaseDAO
     */
    public BaseDAO getXaBaseDAO() {
        return xaBaseDAO;
    }

    /**
     * @param xaBaseDAO the xaBaseDAO to set
     */
    @Resource(name="xaBaseDAO")
    public void setXaBaseDAO(BaseDAO xaBaseDAO) {
        this.xaBaseDAO = xaBaseDAO;
    }

    /**
     * @return the otherXABaseDAO
     */
    public BaseDAO getOtherXABaseDAO() {
        return otherXABaseDAO;
    }

    /**
     * @param otherXABaseDAO the otherXABaseDAO to set
     */
    @Resource(name="otherXABaseDAO")
    public void setOtherXABaseDAO(BaseDAO otherXABaseDAO) {
        this.otherXABaseDAO = otherXABaseDAO;
    }

}
