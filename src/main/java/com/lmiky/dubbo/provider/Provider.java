/**
 * 
 */
package com.lmiky.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lmiky
 * @date 2015��6��15�� ����2:05:38
 */
public class Provider {

	/**
	 * @author lmiky
	 * @date 2015��6��15�� ����2:05:44
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "config/provider.xml" });
		context.start();
		System.in.read(); // ��������˳�
		System.out.println("provider close!");

	}

}
