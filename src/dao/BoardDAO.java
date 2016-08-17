package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Board;

public class BoardDAO{
	SqlSessionFactory sqlSessfac = MybatisConfig.getSqlSessionFactory(); 
	SqlSession sqlSess; 
	ArrayList<Board> result = null; 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Board> list(Board board){
		ArrayList<Board> result = null; 
		System.out.println("dao 파라미터 출력: "+board);
		try{
		sqlSess = sqlSessfac.openSession();
		result = (ArrayList) sqlSess.selectList("Board.selectList", board);
		sqlSess.commit(); 
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSess != null) sqlSess.clearCache(); 
		}
		
		return result;
		
	} 

	public Board view(String num){
		Board result = null;
		try{
			sqlSess = sqlSessfac.openSession();
			result = sqlSess.selectOne("Board.selectWrite", num);
			sqlSess.commit(); 
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				if(sqlSess != null) sqlSess.clearCache(); 
			}
		
		return result; 
	}
}