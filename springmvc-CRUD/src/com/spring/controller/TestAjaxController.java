package com.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.EmployeeDao;
import com.spring.pojo.Employee;

@Controller
public class TestAjaxController {
	
	@Autowired
	EmployeeDao ed;
	
	/**
	 * 测试ajax方式的请求,将请求的数据放在响应体中
	 * @ResponseBody响应给浏览器Json数据
	 * @JsonIgnore 在实体属性中标注是忽略这个属性数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getajax")
	public Collection<Employee> ajaxGetAll() {
		Collection<Employee> all = ed.getAll();
		System.out.println("执行getajax......");
		return all;
	}
	
	/**
	 * @RequestBody:请求体,取一个请求中的请求体
	 * @RequestParam:获取请求参数中的值
	 * @return
	 */
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body) {
		System.out.println("执行testRequestBody请求....获取一个请求中的请求体.....");
		System.out.println("请求体:" + body);
		return "success";
	}

	/**
	 * 封装自定义对象
	 * @RequestBody:  返回json数据,接受json数据,封装为对象
	 * @ResponseBody:  接受json数据,可以将对象转为json数据,返回给浏览器
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping("/requestBody")
	public String testRequestBody(@RequestBody Employee employee) {
		System.out.println("执行requestBody请求..封装自定义对象.......");
		System.out.println("请求体:" + employee);
		return "success";
	}
	
	/** 
	 * @RequestBody获取请求体
	 * 获取请求体
	 * @param str
	 * @return
	 */
	@RequestMapping("/test")
	public String test(@RequestBody String str) {
		System.out.println("请求体............" + str);
		return "success";
	}
	
	/**
	 * HttpEntity<String>作为参数可以获取请求头和请求体
	 * 获取请求体和请求头
	 * @param str
	 * @return
	 */
	@RequestMapping("/test01")
	public String test01(HttpEntity<String>  str) {
		System.out.println("请求体:" + str);
		return "success";
	}
	
	
	/**
	 * 将数据写出去,这时和视图拼串没有关系
	 * @param haha
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/haha")
	public String haha(String haha) {
		System.out.println(haha);
		return "<h1 style='color:red'>success</h1>";
	}
}
