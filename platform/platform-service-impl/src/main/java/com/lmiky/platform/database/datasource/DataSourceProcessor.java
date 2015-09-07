package com.lmiky.platform.database.datasource;

import com.lmiky.platform.service.BaseService;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 数据源处理
 *
 * @author lmiky
 * @date 2015年9月7日 下午2:22:16
 */
public class DataSourceProcessor implements BeanPostProcessor {

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object,
     * java.lang.String)
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("1=================================" + beanName);
        if (!(bean instanceof BaseService)) {
            return bean;
        }
        System.out.println("2=================================" + beanName);
        return bean;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object,
     * java.lang.String)
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
