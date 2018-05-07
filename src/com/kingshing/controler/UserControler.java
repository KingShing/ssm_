package com.kingshing.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kingshing.pojo.User;
import com.kingshing.service.LoginService;

@Controller
public class UserControler {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/checkUserExist.do")
	public @ResponseBody String checkUserExist(String acc) {
		System.out.println(acc);
		long id = Long.parseLong(acc);
		User u  = loginService.checkLogin(id);
		if(u!=null) {
			return "用户已注册";
		}else{
			return "用户不存在";
		}
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(User user) {
		ModelAndView mav = new ModelAndView();
		Long id = user.getId();
		String pwd = user.getPassword();
		User u  = loginService.checkLogin(id);
		if(u!=null&&pwd.equals(u.getPassword())) {
			mav.setViewName("home");
			mav.addObject("user", u);
			return mav;
		}else{
			mav.setViewName("error");
			String err = u==null? "用户不存在":"密码错误";
			mav.addObject("errInfo",err);
			return mav;
		}
	}	
}
