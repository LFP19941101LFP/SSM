package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.spring.pojo.Employee;

public interface EmployeeDao {
	
	/**
	 * 查询所有员工
	 * @return 返回Map
	 * @MapKey("id") 把查出的记录的id的值作为key封装这个map
	 */
	@MapKey("id")
	Map<Integer, Employee> getEmpIdByMapAll();
	
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return Map
	 */
	Map<String, Object> getEmpIdByMap(Integer id);
	
	/**
	 * 查询全部员工,返回List集合
	 * @param employee
	 * @return
	 */
	List<Employee> getEmpByList();
	
	
	/**
	 * 添加员工
	 * @param employee
	 * @return 返回受影响的行数
	 */
	int insertEmp(Employee employee);
	
	/**
	 * 根据id和姓名查询员工信息,多个参数使用@param约定
	 * @param id
	 * @param empName
	 * @return
	 */
	Employee getEmpByIdAndName(@Param("id")Integer id,
							@Param("empName")String empName);
	
	/**
	 * 根据id和姓名查询员工信息
	 * @param map
	 * @return
	 */
	Employee getEmpByIdAndNameMap(Map<String,Object> map);
	
}
