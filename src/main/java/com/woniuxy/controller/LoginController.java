package com.woniuxy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.domain.Userinfo;
import com.woniuxy.service.ITreeService;
import com.woniuxy.service.IUserinfoService;

@Controller
public class LoginController {
	@Resource
	private IUserinfoService service;
	@Resource
	private ITreeService treeService;
	
	@RequestMapping("/login")
	public String login(Userinfo info,HttpSession session) throws Exception {
		info = service.login(info);
		if(info == null) {
			return "index";
		}else {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(info.getTrees());
			session.setAttribute("json", json);
			session.setAttribute("info", info);
			return "redirect:/admin/index.jsp";
		}
	}
}
