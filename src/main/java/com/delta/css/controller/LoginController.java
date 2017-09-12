package com.delta.css.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.delta.css.utils.CssApiCnst;

import com.delta.css.bo.CrewRotnAtvyRestBo;

@RestController
@Scope("session")
public class LoginController {

	@Inject
	CrewRotnAtvyRestBo crewRotnAtvyRestBo;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String login(HttpServletRequest request, @RequestParam(CssApiCnst.USER_ID) String userId,
			@RequestParam("password") String pass) throws IOException {
		userId="0000"+userId;
		String username=null;
		crewRotnAtvyRestBo= new CrewRotnAtvyRestBo();
		if (userId.equals(CssApiCnst.USER_ONE))
		{
			username="Krasnov, Gary J";
		}
		else
		{
			username="Seifried, Mark A";
		}
		if (crewRotnAtvyRestBo.validation(userId, pass)) {
			request.getSession().setAttribute("usersession", userId);
			return  "{\"userId\" : " + "\"" +userId +"\""+ ",\"username\" : " + "\"" +username +"\""+ ", \"Status\" : \"SUCCESS\",\"message\" : \"Valid User\"}";
			

		} else {
			
			return  "{\"userId\" : " + "\"" +userId +"\""+ ",\"username\" : " + "\"" +username +"\""+ ",  \"Status\" : \"FAILED\",\"message\" : \"Invalid User\"}";
		}
		

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public @ResponseBody String logout(HttpServletRequest request) throws IOException {
		String userId=(String) request.getSession().getAttribute("usersession");
			request.getSession().invalidate();
			return  "{\"userId\" : " + "\"" +userId +"\""+ ",  \"Status\" : \"SUCCESS\",\"message\" : \"Successfully LogOut\"}";
	}

}
