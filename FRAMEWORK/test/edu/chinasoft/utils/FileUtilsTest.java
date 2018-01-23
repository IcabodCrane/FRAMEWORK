package edu.chinasoft.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**   
 * @Title: FileUtilsTest.java 
 * @Package edu.chinasoft.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Icabod_Crane   
 * @date 2018年1月22日 上午9:41:27 
 * @version V1.0   
 */
public class FileUtilsTest {

	@Test
	public void testFileListString() {
		File[] fileList = FileUtils.fileList("F:/");
		System.out.println(fileList);
	}

	@Test
	public void testFileListStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testMkdirs() {
		fail("Not yet implemented");
	}

	@Test
	public void testRenameFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
