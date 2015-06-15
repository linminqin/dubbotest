package com.lmiky.dubbo.service.impl;

import com.lmiky.dubbo.service.DemoService;

/**
 * @author lmiky
 * @date 2015年6月12日 上午11:31:58
 */
public class DemoServiceImpl implements DemoService {

	/* (non-Javadoc)
	 * @see com.lmiky.dubbo.provider.service.DemoService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

}
