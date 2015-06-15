/**
 * 
 */
package com.lmiky.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lmiky
 * @date 2015年6月15日 下午2:05:38
 */
public class Provider {

	/**
	 * @author lmiky
	 * @date 2015年6月15日 下午2:05:44
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "config/provider.xml" });
		context.start();
		System.in.read(); // 按任意键退出
		System.out.println("provider close!");

	}

}
