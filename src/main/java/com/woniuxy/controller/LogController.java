package com.woniuxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Log;
import com.woniuxy.domain.PageBean;
import com.woniuxy.service.impl.LogServiceImpl;

@Controller
@RequestMapping("/admin/log")
public class LogController {
	@Resource
	private LogServiceImpl logService;
	
	@RequestMapping("findAll")
	public String findAll(PageBean pb,ModelMap map,Log log) {
		List<Log> list = logService.findAll(log,pb);
		// 查询结果
		map.put("logList", list);
		// 分页结果
		map.put("page", pb);
		// 日志结果，用来回填数据
		map.put("log", log);
		return "/admin/log/logList";
	}
	
	@RequestMapping("findJSON")
	public @ResponseBody Map findJSON(PageBean pb,Log log) {
		Map map = new HashMap();
		List<Log> list = logService.findAll(log,pb);
		// 查询结果
		map.put("logList", list);
		// 分页结果
		map.put("page", pb);
		// 日志结果，用来回填数据
		map.put("log", log);
		return map;
	}
}
