package cn.sm1234.dao.impl;

import java.util.List;

import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;
import org.apache.ibatis.session.SqlSession;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.utils.SessionUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void saveCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.insert("insertCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.update("updateCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void deleteCustomer(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.delete("deleteCustomer",id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Customer> queryAllCustomer() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryAllCustomer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public Customer queryCustomerById(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectOne("queryCustomerById",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<Customer> queryCustomerByName(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryCustomerByName",name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public void testParameterType(String name) {
	}

	@Override
	public void testParameterType2(Customer c) {
	}

	@Override
	public void testParameterType3(CustomerVo c) {
	}

	@Override
	public Long queryTotalCount() {
		return null;
	}

	@Override
	public Customer queryCustomer(Integer id) {
		return null;
	}

	@Override
	public CustomerRM queryCustomerResultMap(Integer id) {
		return null;
	}

	@Override
	public List<Customer> queryByNameAndTelephone(Customer c) {
		return null;
	}

	@Override
	public void deleteCustomerByIn(Customer c) {
	}
}
