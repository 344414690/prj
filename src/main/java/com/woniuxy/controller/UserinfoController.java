package com.woniuxy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.domain.Userinfo;
import com.woniuxy.service.IRoleService;
import com.woniuxy.service.IUserinfoService;
import com.woniuxy.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/admin/userinfo/")
public class UserinfoController {
	@Resource
	private IUserinfoService  userinfoService;
	@Resource
	private IRoleService RoleServiceImpl;
	
	//增加用户 接收传递过来的用户信息和选中的用户权限
	@RequestMapping("save")
	public String save(Userinfo userinfo,Integer [] chk,ModelMap map) {
		userinfoService.save(userinfo, chk);
		return "redirect:findAll";
	}
	
	//查找所有用户
	@RequestMapping("findAll")
	public String findAll(ModelMap  map) {
		List list = userinfoService.findAll();
		map.put("list", list);
		return "/admin/userinfo/list";
	}
	
	// 增加用户，要用到角色表，把所有角色都显示到前台
	@RequestMapping("goInput")
	public String goInput(ModelMap  map) {
		List roles = RoleServiceImpl.findAll();
		map.put("roles", roles);
		return "/admin/userinfo/input";
	}
	
	//删除用户
	@RequestMapping("delete")
	public String delete(Integer uid) {
		userinfoService.delete(uid);
		return "redirect:findAll";
	}
	//恢复用户
	@RequestMapping("revoke")
	public String revoke(Integer uid) {
		userinfoService.revoke(uid);
		return "redirect:findAll";
	}
	// 查找到一个用户，跳转到增加用户的界面
	@RequestMapping("findById")
	public String findById(Integer uid,ModelMap  map) {
		Userinfo info = userinfoService.findById(uid);
		map.put("info", info);
		return "forward:goInput";
	}
	// 修改用户信息
	@RequestMapping("update")
	public String update(Userinfo info,Integer [] chk) {
		userinfoService.update(info, chk);
		return "redirect:findAll";
	}
}
