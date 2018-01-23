package edu.chinasoft.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.chinasoft.utils.FileUtils;

/**
 * @Title: QueryFileHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 上午10:07:32
 * @version V1.0
 */
@Controller("queryFileHandler")
@RequestMapping("/dir")
public class QueryFileHandler {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>查找文件</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "queryFile.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");

		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		String query = request.getParameter("query");
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>查找文件</TITLE></HEAD>");
		out.println("  <BODY leftmargin=50>");
		if (query.equals("")) {
			out.println("请选择需要查找的内容！");
		} else {
			File[] files = FileUtils.fileList(path, query);
			// 过滤隐藏文件,并展现
			out.println("<table align=left border=0 width=700>");
			out.println("<tr>");
			out.println("<th>名称</th><th>类型</th><th>大小</th><th>修改日期</th><th>操作</th>");
			out.println("</tr>");
			for (File f : files) {
				if (!f.isHidden()) {
					String canonicalPath = f.getCanonicalPath();
					canonicalPath = canonicalPath.replaceAll("\\\\", "/");
					out.println("<tr>");
					String url = f.isDirectory() ? "/FRAMEWORK/dir/dir.do?path="
							+ canonicalPath
							: "/FRAMEWORK/dir/readFile.do?path="
									+ canonicalPath;
					out.print("<td><a href='" + url + "'>" + f.getName()
							+ "</a></td>");
					out.print("<td>" + (f.isFile() ? "文件" : "文件夹") + "</td>");
					out.println("<td>"
							+ (f.isDirectory() ? "" : (f.length() / 1024)
									+ "KB") + "</td>");
					out.println("<td>"
							+ new Date(f.lastModified()).toLocaleString()
							+ "</td>");
					out.print("<td><a href='/FRAMEWORK/dir/operateFile.do?mtype=delete&path="
							+ canonicalPath
							+ "'>删除</a>&nbsp;&nbsp;&nbsp;");
					out.print("<a href='/FRAMEWORK/dir/operateFile.do?mtype=rename&path="
							+ canonicalPath + "'>更名</a></td>");
					out.println("</tr>");
				}
			}
			out.println("</table>");
		}

		out.println("  </BODY>");
		out.println("</HTML>");

		out.flush();
		out.close();
	}
}
