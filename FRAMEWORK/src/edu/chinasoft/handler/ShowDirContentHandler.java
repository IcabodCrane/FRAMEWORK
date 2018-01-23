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
 * @Title: ShowDirContent.java
 * @Package edu.chinasoft.handler
 * @Description: TODO 浏览磁盘下所有文件
 * @author Icabod_Crane
 * @date 2018年1月22日 上午9:28:53
 * @version V1.0
 */
@Controller("showDirContentHandler")
@RequestMapping("/dir")
public class ShowDirContentHandler {

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "dir.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>服务器磁盘内容</TITLE></HEAD>");
		out.println("  <BODY leftmargin=50>");
		String path = request.getParameter("path");
		if (path != null && !path.equals("")) {
			out.println("[<a href='/FRAMEWORK/dir/createFile.do?path=" + path
					+ "'>创建文件/文件夹</a>]");

			File file = new File(path);
			out.println("<a href='/FRAMEWORK/dir/showDisk.do?path="
					+ file.getParent() + "'><<后退</a><br>");
			out.println("<a href='/FRAMEWORK/page/upload.jsp'>文件上传</a>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<form action='/FRAMEWORK/dir/queryFile.do' method=post>");
			out.println("<input type=hidden name=path value='" + path + "'>");
			out.println("<input name=query> <input type=submit value=查询>");
			out.println("</form>");
			out.println("<br><br><br>");

			// 得到根目录下的文件夹及文件
			File[] files = FileUtils.fileList(path);
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

					out.println("</tr>");
				}
			}
			out.println("</table>");
		} else {
			response.sendRedirect("/FRAMEWORK/dir/dir.do"); // 重新得到根目录
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
