package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.pojo.Teacher;

/**
 * teacher持久化接口
 * @author ASUS
 *
 */
public interface TeacherDao {
	
	/**
	 * 根据id查询老师信息
	 * @param id
	 * @return
	 */
	Teacher getTeacherById(Integer id);
	
	/**
	 * 按照一定的条件查询老师的信息 使用sql if判断
	 * @param teacher
	 * @return
	 */
	List<Teacher> getTeacherByAll(Teacher teacher);
	
	/**
	 * 按照一定的条件查询老师的信息 使用sql choose判断
	 * @param teacher
	 * @return
	 */
	List<Teacher> getTeacherByAllChoose(Teacher teacher);
	
	/**
	 * 查询所有老师,使用SQLfoeach遍历
	 * @param ids 指定参数
	 * @return
	 */
	List<Teacher> getTeacherList(@Param("ids") List<Integer> ids);
	
	/**
	 * 更新老师信息
	 * @param teacher
	 * @return
	 */
	int updateTeacher(Teacher teacher);

}
