package cn.sm1234;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;
import cn.sm1234.utils.SessionUtils;

public class Demo3 {

	/**
	 * 输入映射-基本类型
	 */
	@Test
	public void test1(){
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.testParameterType("zhangsan");
		sqlSession.commit();
		sqlSession.close();
	}


	/**
	 * 输入映射-javaBean
	 */
	@Test
	public void test2(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer c = new Customer();
		c.setName("cheng2222");
		c.setGender("man");
		c.setTelephone("13211112222");
		dao.testParameterType2(c);
		sqlSession.commit();
		sqlSession.close();
	}



	/**
	 * 输入映射-包装javaBean
	 */
	@Test
	public void test3(){
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		CustomerVo vo = new CustomerVo();
		Customer c = new Customer();
		c.setName("peter333");
		c.setGender("man");
		c.setTelephone("13211112222");
		vo.setCustomer(c);
		dao.testParameterType3(vo);
		sqlSession.commit();
		sqlSession.close();
	}



	
	/**
	 * 输出映射
	 */
	@Test
	public void test4(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Long count = dao.queryTotalCount();
		System.out.println(count);
		sqlSession.commit();
		sqlSession.close();
	}


	/**
	 * 输出映射
	 */
	@Test
	public void test5(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer c = dao.queryCustomer(5);
		System.out.println(c);
//		CustomerRM c = dao.queryCustomerResultMap(1);
//		System.out.println(c);
		sqlSession.commit();
		sqlSession.close();
	}


	/**
	 * 输出映射
	 */
	@Test
	public void test6(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		CustomerRM c = dao.queryCustomerResultMap(5);
		System.out.println(c);
		sqlSession.commit();
		sqlSession.close();
	}

}
