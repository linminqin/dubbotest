/**
 * 
 */
package com.lmiky.dubbo.provider.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.container.spring.SpringContainer;
import com.lmiky.platform.logger.util.LoggerUtils;

/**
 * 初始化
 * @author lmiky
 * @date 2015年9月5日 上午11:00:04
 */
public class InitServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private SpringContainer container;


    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        super.init();
        LoggerUtils.info("starting.......");
        // new SpringContainer().start();
        SpringContainer container = (SpringContainer) ExtensionLoader.getExtensionLoader(Container.class)
                .getExtension("spring");
        container.start();
        LoggerUtils.info("started.......");
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#destroy()
     */
    @Override
    public void destroy() {
        super.destroy();
        LoggerUtils.info("stoping.......");
        container.stop();
        LoggerUtils.info("stoped.......");
    }
}
