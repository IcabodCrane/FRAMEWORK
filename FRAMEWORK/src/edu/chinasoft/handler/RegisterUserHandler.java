package edu.chinasoft.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.chinasoft.pojo.TUser;
import edu.chinasoft.serverice.TUserServerice;
import edu.chinasoft.serverice.TUserServericeImpl;

/**
 * @Title: RegisterUserHandler.java
 * @Package edu.chinasoft.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月19日 下午3:20:36
 * @version V1.0
 */
@Controller("registerUserHandler")
@RequestMapping("/user")
public class RegisterUserHandler {
	private static Logger logger = Logger.getLogger(RegisterUserHandler.class);
	private TUserServerice tUserServerice;

	@RequestMapping(value = "registerUser.do", method = RequestMethod.POST)
	public String registerUser(TUser tUser, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("RegisterUserHandler->registerUser Start...");
		tUserServerice = new TUserServericeImpl();
		tUserServerice.registerUser(tUser);
		logger.debug("RegisterUserHandler->registerUser End...");
		return "redirect:/success.jsp";
	}

	public TUserServerice gettUserServerice() {
		return tUserServerice;
	}

	public void settUserServerice(TUserServerice tUserServerice) {
		this.tUserServerice = tUserServerice;
	}

}
