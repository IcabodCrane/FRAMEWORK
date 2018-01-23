package edu.chinasoft.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.chinasoft.utils.FileUtils;
import edu.chinasoft.utils.StringUtils;

/**
 * @Title: ReadFileContentHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 上午10:18:13
 * @version V1.0
 */
@Controller("readFileContentHandler")
@RequestMapping("/dir")
public class ReadFileContentHandler {

	@RequestMapping(value = "readFile.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>读取文件内容</TITLE></HEAD>");
		out.println("  <BODY>");
		String path = request.getParameter("path");
		if (path != null && !path.equals("")) {
			// 将请求的文件内容在网页中展现
			String content = FileUtils.readFile(path);
			out.println(StringUtils.filterHTML(content));
		} else {
			response.sendRedirect("/FRAMEWORK/dir/dir.do");
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
		out.println("  <HEAD><TITLE>读取文件内容</TITLE></HEAD>");
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
