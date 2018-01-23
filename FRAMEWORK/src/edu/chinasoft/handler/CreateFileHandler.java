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

/**
 * @Title: CreateFileHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 上午9:46:09
 * @version V1.0
 */
@Controller("createFileHandler")
@RequestMapping("/dir")
public class CreateFileHandler {

	@RequestMapping(value = "createFile.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>创建文件（夹）</TITLE></HEAD>");
		out.println("  <BODY>");
		String path = request.getParameter("path");
		if (path != null && !path.equals("")) {
			out.println("<form action='/FRAMEWORK/dir/create.do' method=post>");
			out.println("<input type=hidden name=path value='" + path + "'>");
			out.println("<input name=type type=radio value=1>文件");
			out.println("<input name=type type=radio value=2>文件夹");
			out.println("<br>文件/文件夹名称:<input name=name size=30>");
			out.println("<br>");
			out.println("<textarea rows=5 cols=50 name=content></textarea><br>");
			out.println("<input type=submit>");
			out.println("</form>");
			out.println("  </BODY>");
			out.println("</HTML>");
		}
		out.flush();
		out.close();
	}

	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String path = request.getParameter("path");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		if (type.equals("1")) {
			String content = request.getParameter("content");
			FileUtils.writeFile(path + "\\" + name, content);
		} else {
			boolean result = FileUtils.mkdirs(path + "\\" + name);
			if (!result) {
				out.println("创建失败了！");
				out.println("<a href='#'>返回</a>");
			}
		}
		response.sendRedirect("/FRAMEWORK/dir/dir.do?path=" + path);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
