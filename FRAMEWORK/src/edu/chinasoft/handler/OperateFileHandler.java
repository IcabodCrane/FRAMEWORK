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
 * @Title: OperateFileHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月22日 上午10:12:27
 * @version V1.0
 */
@Controller("operateFileHandler")
@RequestMapping("/dir")
public class OperateFileHandler {

	@RequestMapping(value = "operateFile.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String mtype = request.getParameter("mtype");
		String path = request.getParameter("path");
		if (mtype != null && path != null) {
			if ("delete".equals(mtype)) {
				FileUtils.delete(path);
			} else if ("rename".equals(mtype)) {

			}
			response.sendRedirect("/FRAMEWORK/dir/dir.do?path="
					+ path.substring(0, path.lastIndexOf("\\") + 1));
		} else {

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>文件操作</TITLE></HEAD>");
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
