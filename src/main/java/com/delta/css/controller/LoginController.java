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

import com.delta.css.bo.CrewRotnAtvyRestBo;

@RestController
@Scope("session")
public class LoginController {

	@Inject
	CrewRotnAtvyRestBo crewRotnAtvyRestBo;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String login(HttpServletRequest request, @RequestParam("userId") String userId,
			@RequestParam("password") String pass) throws IOException {
		//public @ResponseBody String login(HttpServletRequest request) throws IOException {

		String output = null;
		userId="0000"+userId;
		request.getAttribute("password");
		if (crewRotnAtvyRestBo.validation(userId, pass)) {
			request.getSession().setAttribute("usersession", userId);
			output = "{\"userId\" : " + "\"" +userId +"\""+ ",  \"Status\" : \"SUCCESS\",\"message\" : \"Valid User\"}";

		} else {
			
			output = "{\"userId\" : " + "\"" +userId +"\""+ ",  \"Status\" : \"FAILED\",\"message\" : \"Invalid User\"}";
		}
		return output;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	/*public @ResponseBody String login(HttpServletRequest request, @RequestParam("userId") String userId
			) throws IOException {*/
		public @ResponseBody String logout(HttpServletRequest request) throws IOException {
		String output = null;
		String userId=(String) request.getSession().getAttribute("usersession");
			request.getSession().invalidate();
			output = "{\"userId\" : " + "\"" +userId +"\""+ ",  \"Status\" : \"SUCCESS\",\"message\" : \"Successfully LogOut\"}";

			return output;
	}

}
