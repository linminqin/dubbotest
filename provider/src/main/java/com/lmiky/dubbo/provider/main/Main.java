/**
 * 
 */
package com.lmiky.dubbo.provider.main;

import com.alibaba.dubbo.container.spring.SpringContainer;

/**
 * 主类
 * @author lmiky
 * @date 2015年8月30日 下午11:40:45
 */
public class Main {

    /**
     * 主方法
     * @author lmiky
     * @date 2015年8月30日 下午11:40:45
     * @param args
     */
    public static void main(String[] args) {
        new SpringContainer().start();
    }

}
