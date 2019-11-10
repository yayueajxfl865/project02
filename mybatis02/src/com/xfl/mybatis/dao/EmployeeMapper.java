package com.xfl.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.xfl.mybatis.bean.Employee;

public interface EmployeeMapper {
	//多条记录封装成一个map;Map<Integer,Employee>:key就是这条记录的主键，值就是记录封装后的javabean对象色
	//@MapKey("id")//告诉mybatis封装这个map的时候使用那个属性作为主键
	
	
	
	public List<Employee> getEmpReturnManyMap(String fagaw,String gwesf);
	
	
	
	//返回一条记录的map,key就是列名，值就是对应的值
	public Map<String,Object> getEmpByIdReturnMap(Integer id);
	
	
	public Employee getEmpById(Integer id,String gender);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmpById(Integer id);

}
