package com.lmiky.dubbo.consumer;

import java.util.Scanner;

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
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        Scanner sc=new Scanner(System.in);
        System.out.println("begin input...");
        String name = null;
        while(!"end".endsWith(name = sc.next())) {
        	System.out.println(demoService.sayHello(name)); // 显示调用结果
        }
        System.out.println("...end input");
	}

}
