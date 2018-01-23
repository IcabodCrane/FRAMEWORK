package edu.chinasoft.mybatis;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.chinasoft.mapper.TUserMapper;

/**
 * @Title: TestMybatis.java
 * @Package edu.chinasoft.mybatis
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月19日 上午11:45:38
 * @version V1.0
 */
public class TestMybatis {

	@Test
	public void testMybatis() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		DataSource dataSource = classPathXmlApplicationContext.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);
	}

	@Test
	public void testMapper() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		TUserMapper bean = classPathXmlApplicationContext.getBean("TUserMapper", TUserMapper.class);
		System.out.println(bean);
	}
}
