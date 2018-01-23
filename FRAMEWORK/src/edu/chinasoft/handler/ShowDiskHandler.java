package edu.chinasoft.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title: ShowDiskHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 上午10:35:41
 * @version V1.0
 */
@Controller("showDiskHandler")
@RequestMapping("/dir")
public class ShowDiskHandler {

	@RequestMapping(value = "showDisk.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>服务器磁盘</TITLE></HEAD>");
		out.println("  <BODY>");
		File[] roots = File.listRoots();
		for (File f : roots) {
			String canonicalPath = f.getCanonicalPath();
			canonicalPath = canonicalPath.replaceAll("\\\\", "/");
			out.println("<a href='/FRAMEWORK/dir/dir.do?path=" + canonicalPath
					+ "'>服务器磁盘:(" + canonicalPath
					+ ")</a>&nbsp;&nbsp;&nbsp;<br>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
