package com.lmiky.dubbo.provider.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.container.spring.SpringContainer;
import com.lmiky.platform.logger.util.LoggerUtils;

/**
 * 服务提供者内容侦听器
 * @author lmiky
 * @date 2015年10月10日 下午2:00:47
 */
public class ProviderContextListener implements ServletContextListener {
	private SpringContainer container;

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
        LoggerUtils.info("provider starting.......");
        // new SpringContainer().start();
        SpringContainer container = (SpringContainer) ExtensionLoader.getExtensionLoader(Container.class)
                .getExtension("spring");
        container.start();
        LoggerUtils.info("provider start success.......");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LoggerUtils.info("provider stoping.......");
        container.stop();
        LoggerUtils.info("provider stop success.......");

	}

}
