package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Board;
import vo.Customer;

public class CustomerDAO {
	SqlSessionFactory sqlSessfac = MybatisConfig.getSqlSessionFactory();
	SqlSession sqlSess;
	ArrayList<Customer> result = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Customer> list(Customer customer) {
		ArrayList<Customer> result = null;
		System.out.println("dao 파라미터 출력: " + customer);
		try {
			sqlSess = sqlSessfac.openSession();
			result = (ArrayList) sqlSess.selectList("Customer.selectList", customer);
			sqlSess.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSess != null)
				sqlSess.close();
		}

		return result;

	}

	public boolean insertCustomer(Customer customer) {
		boolean result = false;
		try {
			sqlSess = sqlSessfac.openSession();
			int cnt = sqlSess.insert("Customer.insertCustomer",customer);
			if(cnt>0) result = true; 
			
			sqlSess.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSess != null)
				sqlSess.close();
		}
		return result; 
	}
	
	
	public Customer selectCusIf(Customer customer) {
		Customer result = null;
		try {
			sqlSess = sqlSessfac.openSession();
			result = sqlSess.selectOne("Customer.selectCusIf",customer); 
			sqlSess.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSess != null)
				sqlSess.close();
		}
		return result; 
	}
	
	public boolean selectCusById(String checkedID){
		boolean result = false; 
		try {
			sqlSess = sqlSessfac.openSession();
			result = sqlSess.selectOne("Customer.idCheck",checkedID); 
			sqlSess.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSess != null)
				sqlSess.close();
		}
		
		return result; 
	}
}