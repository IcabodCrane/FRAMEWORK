package edu.chinasoft.mapper;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title: TestJDBC.java
 * @Package edu.chinasoft.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 下午3:47:43
 * @version V1.0
 */
public class TestJDBC {

	@Test
	public void testDataSource() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		DataSource dataSource = classPathXmlApplicationContext.getBean(
				"dataSource", DataSource.class);
		System.out.println(dataSource);
	}

	@Test
	public void testMapper() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		TUserMapper mapper = classPathXmlApplicationContext.getBean(
				"TUserMapper", TUserMapper.class);
		System.out.println(mapper);
	}
}
