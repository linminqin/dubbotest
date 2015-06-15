package com.lmiky.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmiky.dubbo.service.DemoService;

/**
 * @author lmiky
 * @date 2015��6��15�� ����2:05:08
 */
public class Consumer {

	/**
	 * @author lmiky
	 * @date 2015��6��15�� ����2:05:49
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config/consumer.xml"});
        context.start();
 
        DemoService demoService = (DemoService)context.getBean("demoService"); // ��ȡԶ�̷������
        String hello = demoService.sayHello("lmiky"); // ִ��Զ�̷���
 
        System.out.println(hello); // ��ʾ���ý��

	}

}
