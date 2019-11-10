package com.xfl.mybatis.xml;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.xfl.mybatis.bean.Employee;
import com.xfl.mybatis.dao.EmployeeMapper;

class MyBatisTest {

	@Test
	public void test() throws IOException{


		String resource = "mybatis-conf.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory=(SqlSessionFactory) new SqlSessionFactoryBuilder().build(inputStream);
	
	    SqlSession openSession=sqlSessionFactory.openSession();
	    try {
	    	Employee employee  = openSession.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.selectEmp",1);
	    	
		    System.out.println(employee);
	    	
	    }
	    
	    finally {
	    	  openSession.close();
	    }
	
	}
	
	//推荐使用这种方式用,select,根据id查询，返回一个javabean对象
	@Test
	public void test02() throws IOException{
		String resource="mybatis-conf.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		
		try {
			
			//拿到代理对象EmployeeMapper接口的代理对象
			EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
			
			Employee employee=mapper.getEmpById(14,"1");//查询数据库
			System.out.println(employee);
			
			
			
		}
		
		finally {
			sqlSession.close();
			
		}
	} 
	//根据id查询，返回一条记录的map集合
	@Test
	public void selectByIdReturnMap() throws IOException
	{
		String resource="mybatis-conf.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//拿到接口代理对象
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		Map map=mapper.getEmpByIdReturnMap(6);
		System.out.println(map);
		
	}
	//模糊查询，返回多条记录的map集合
	@Test
	public void manyMap() throws IOException{
		
		String resource="mybatis-conf.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//拿到接口的代理对象
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		List list=mapper.getEmpReturnManyMap("%she%","%g%");
		System.out.println(list);
		
	}
	
	/*
	 * 
	  * 增、删、改，mybatis允许一下类型返回值
	  * long、nteger、Boolean
	 */
	
	//addTest
	@Test
	public void addTest() throws IOException{
		
		String resource="mybatis-conf.xml";//根据类路径下拿到全局置文件件
		InputStream inputStream=Resources.getResourceAsStream(resource);//获取文件的输入流		
		
		//拿到代理工厂厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	    //拿到SqlSession 
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	
		try {
			//拿到代理接口对象
			
			EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
			
			//Integer id, String lastName, String email, String gender
			Employee employee=new Employee(null,"zhangsan","zhangsan@qq.com","1");
	
			
			mapper.addEmp(employee);
			System.out.println("新增加的主键为"+employee.getId());
			//手动提交数据
			sqlSession.commit();
		
			
			
			
		}
		finally {
			sqlSession.close();
		}
	
	
	}
	//updateTest
	@Test
	public void updateTest() throws IOException{
		String resource="mybatis-conf.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		
		
		try {
			
			//拿到代理对象
			EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
			Employee employee=new Employee();
			employee.setId(1);
			employee.setEmail("lisi@qq.com");
			employee.setGender("2");
			employee.setLastName("lisi");
			mapper.updateEmp(employee);
			session.commit();
			
		}finally{
	
			session.close();
			
		}
		
	}
	//deleteTest
	@Test
	public void deleteTest() throws IOException{
		
		String resource="mybatis-conf.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		
		try {
			//拿到动态代理对象
			EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
			mapper.deleteEmpById(1);
			//手动提交数据
			sqlSession.commit();
			
			
			
		}finally {
			sqlSession.close();
			
		}
		
	}
	
	
	

}
