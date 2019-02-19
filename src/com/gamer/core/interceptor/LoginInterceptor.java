package com.gamer.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.common.utils.*;
import com.gamer.core.po.User;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * 用户失效后将account值清除
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//获取Session域
		HttpSession session = request.getSession();
		//获取Url，若是Url指向登陆，注册，找回密码请求，则不进行拦截
		String Url = request.getRequestURI();
		Logger l = new Logger();
		l.log("拦截器中。。。");
		if (Url.indexOf("User.action")>0 || Url.indexOf("login.action")>0) {
			l.log("注册等页面不拦截");
			return true;
		}else {
			User u = (User)session.getAttribute("user");
			if (u != null) {
				return true;
			}else {
				l.log("拦截");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return false;
			}
		}
	}

}
