package com.woniuxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.Message;
import com.woniuxy.domain.PageBean;
import com.woniuxy.domain.Student;
import com.woniuxy.service.IStudentService;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
	@Resource
	private IStudentService studentService;
	
	//用easyUI展示分页数据
	@RequestMapping("findAll")
	@ResponseBody
	public Map findAll(PageBean pageBean) {
		List rows = studentService.findAll(pageBean); // 获取到分页数据
		Map map = new HashMap<String, Object>();// 创建map对象
		map.put("total", pageBean.getCount());// 总页数封装到map中
		map.put("rows", rows);// 把总记录数。封装到map中
		return map;
	} 
	
	// 删除学生
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(Integer stid) {
		Message ms = null;
		try {
			int count = studentService.delete(stid);
			ms = new Message(true, "删除成功");
		} catch (Exception e) {
			ms = new Message(false, "删除失败" + e.getMessage());
		}
		return ms;
	}
	
	// 批量删除学生
	@RequestMapping("deleteBatch")
	@ResponseBody
	public Message deleteBatch(String stidString) {
		Message ms = null;
		try {
			System.out.println(stidString);
			String[] tempString  = stidString.split(",");// 分割字符串
			Integer[] stids = new Integer[tempString.length];// 创建数组
			for(int i = 0;i <tempString.length;i++) {//循环数组
				stids[i] = Integer.parseInt(tempString[i]);// 转换数组格式
			}
			studentService.deleteBatch(stids);
			ms = new Message(true, "批量删除成功");
		} catch (Exception e) {
			ms = new Message(false, "批量删除失败" + e.getMessage());
		}
		return ms;
	}

	//添加学生
	@RequestMapping("save")
	@ResponseBody
	public Message save(Student sd) {
		Message ms = null;
		try {
			studentService.save(sd);;
			ms = new Message(true, "增加成功");
		} catch (Exception e) {
			ms = new Message(false, "增加失败" + e.getMessage());
		}
		return ms;
	} 
	
	// 修改学生
	@RequestMapping("findById")
	@ResponseBody
	public Student findById(Integer stid) {
		Student stu = studentService.findByID(stid);
		return stu;
	} 
	//修改学生
	@RequestMapping("update")
	@ResponseBody
	public Message update(Student sd) {
		Message ms = null;
		try {
			studentService.update(sd);;
			ms = new Message(true, "修改成功");
		} catch (Exception e) {
			ms = new Message(false, "修改失败" + e.getMessage());
		}
		return ms;
	} 
	
}
