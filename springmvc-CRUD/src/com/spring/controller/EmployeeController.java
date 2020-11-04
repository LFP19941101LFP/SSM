package com.spring.controller;

import com.spring.dao.DepartmentDao;
import com.spring.dao.EmployeeDao;
import com.spring.pojo.Department;
import com.spring.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020-08-24 19:56
 * @company 阿里巴巴
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> list = employeeDao.getAll();
        //添加到请求域中,转发到页面
        model.addAttribute("emps",list);
        return "list";
    }
    
    /**
     * 去员工添加页面
     * @return
     */
    @RequestMapping("/toaddpage")
    public String addEmp(Model model) {
    	// 先查询所有部门
    	Collection<Department> department = departmentDao.getDepartments();
    	// 放在请求域中
    	model.addAttribute("depts", department );
    	model.addAttribute("employee", new Employee());
    	// 去添加页面
    	return "addemp";
    }
    
    /**
     * 保存员工
     * @param employee
     * @return
     */
    @RequestMapping(value="/emp",method=RequestMethod.POST)
    public String saveEmp(@Valid Employee employee, BindingResult result,Model model) {
    	System.out.println("要添加的员工 : "+ employee);
    	// 获取是否有错误
    	boolean hasErrors = result.hasErrors();
    	Map<String, Object> map = new HashMap<>();
    	if (hasErrors) {
    		List<FieldError> error = result.getFieldErrors();
    		for (FieldError fieldError : error) {
				System.out.println("错误消息提示:" + fieldError.getDefaultMessage());
				System.out.println("错误的字段是: " + fieldError.getField()) ;
				System.out.println(fieldError) ;
				System.out.println("________________________");
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
    		System.out.println("有校验错误");
    		model.addAttribute("errorInfo", map);
			return "addemp";
		} else {
			employeeDao.save(employee);
	    	// 保存员工后重定向到员工列表页面
	    	return "redirect:/emps";
		}
    }
    
    /**
     * 查询员工,来到修改页面回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id,Model model) {
    	//查询所有员工
    	Employee em = employeeDao.get(id);
    	//将查出的信息放在请求域中
    	model.addAttribute("employee", em);
    	//查出部门信息
    	Collection<Department> departments = departmentDao.getDepartments();
    	model.addAttribute("depts", departments);
    	return "update";
    }
    
    @RequestMapping(value="/emp/{id}", method=RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee) {
    	System.out.println("要修改的员工:" +employee);
    	//重定向到员工列表
    	employeeDao.save(employee);
    	return "redirect:/emps";
    }
    
    @ModelAttribute
    public void getModelAttribute(@RequestParam(value="id", required=false) 
    					Integer id,
    					Model model) {
    	if (id != null) {
			Employee emp = employeeDao.get(id);
			model.addAttribute("employee", emp);
		}
    	System.out.println("hahah");
    }
    
    //删除员工
    @RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
    	employeeDao.delete(id);
    	return "redirect:/emps";
    	
    }
   
}
