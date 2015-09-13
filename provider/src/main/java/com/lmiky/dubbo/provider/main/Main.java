/**
 * 
 */
package com.lmiky.dubbo.provider.main;

import org.apache.log4j.PropertyConfigurator;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.container.spring.SpringContainer;
import com.lmiky.platform.logger.util.LoggerUtils;

/**
 * 主类
 * @author lmiky
 * @date 2015年8月30日 下午11:40:45
 */
public class Main {

    /**
     * 启动
     * @author lmiky
     * @date 2015年9月4日 下午2:41:05
     */
    public static void run() {
        try {
            LoggerUtils.info("starting.......");
            System.out.println("starting.......");
            // new SpringContainer().start();
            PropertyConfigurator.configure(Main.class.getClassLoader().getResource("config/log4j.properties"));
            SpringContainer container = (SpringContainer) ExtensionLoader.getExtensionLoader(Container.class)
                    .getExtension("spring");
            container.start();
            LoggerUtils.info("started.......");
            System.out.println("started.......");
        } catch (Exception e) {
            LoggerUtils.error(e);
        }
    }

    /**
     * 主方法
     * @author lmiky
     * @date 2015年8月30日 下午11:40:45
     * @param args
     */
    public static void main(String[] args) {
        Main.run();
    }

}
