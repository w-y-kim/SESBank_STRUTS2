package dao;

import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {

	private static SqlSessionFactory sqlSessionFactory; 
	
	static{
		String resource = "mybatis-config.xml";
		
		try {
			
			Reader reader = Resources.getResourceAsReader(resource);//DB에 접속 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory; 
	}


}
