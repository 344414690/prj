package com.woniuxy.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.woniuxy.service.IProvinceService;

@RestController
@RequestMapping("/admin/province")
public class ProvinceController {
	@Resource
	private IProvinceService provinceService;
	
	@RequestMapping("findAll")
	public List findAll() {
		List list = provinceService.findAll();
		return list;
	}
}
