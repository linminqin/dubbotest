package com.lmiky.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmiky.dubbo.service.DemoService;

/**
 * @author lmiky
 * @date 2015年6月15日 下午2:05:08
 */
public class Consumer {

	/**
	 * @author lmiky
	 * @date 2015年6月15日 下午2:05:49
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config/consumer.xml"});
        context.start();
 
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("lmiky"); // 执行远程方法
 
        System.out.println(hello); // 显示调用结果

	}

}
