package com.spring.dao;

import java.util.List;

import com.spring.pojo.Employee;

public interface EmployeeDao {
	
	/**
	 * 查询全部员工
	 * @param employee
	 * @return
	 */
	List<Employee> getEmpAll();
	
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return 返回整个员工(对象)
	 */
	Employee getEmpById(Integer id);
	
	/**
	 * 修改员工信息,id做修改依据
	 * @param employee 修改员工所有的字段某些字段,带的字段太多,传整个员工对象
	 * @return 返回受影响的行数
	 */
	int updateEmp(Employee employee);
	
	/**
	 * 根据员工的id删除员工,成功返回true,失败返回false
	 * @param id 
	 * @return 返回受影响的行数
	 */
	boolean deleteEmp(Integer id);
	
	/**
	 * 添加员工
	 * @param employee
	 * @return 返回受影响的行数
	 */
	int insertEmp(Employee employee);
	
	
}
