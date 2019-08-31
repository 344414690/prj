package com.woniuxy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.domain.Role;
import com.woniuxy.service.IRoleService;

@Controller
@RequestMapping("/admin/role/")
public class RoleController {
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("save")
	public String save(Role role) {
		roleService.save(role);
		return "redirect:findAll";
	}
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List list = roleService.findAll();
		map.put("list", list);
		return "/admin/role/list";
	}

	@RequestMapping("update")
	public String update(Role role) {
		roleService.update(role);
		return "redirect:findAll";
	}
	
	@RequestMapping("findOne")
	public String findOne(Integer rid,ModelMap map) {
		Role role = roleService.findOne(rid);
		map.put("role", role);
		return "forward:goInput";
	}
	@RequestMapping("goInput")
	public String goInput() {
		return "forward:goInput";
	}
}
