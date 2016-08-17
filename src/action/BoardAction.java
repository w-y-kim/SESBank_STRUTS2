package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.BoardDAO;
import vo.Board;

public class BoardAction extends ActionSupport {

	BoardDAO dao = new BoardDAO(); 
	private ArrayList<Board> list ;
	private Board board = new Board(); 
	
	private String boardnum; 
	
	public String execute(){
		
		System.out.println("액션들어옴");
		return SUCCESS; 
	}
	
	public String boardList(){
		System.out.println("글목록 보기 액션 들어옴");
		 
		board.setStartNum(1);
		board.setEndNum(10);
		list = dao.list(board);
		System.out.println("글목록(액션클래스) : "+ list);
		
		return SUCCESS;
	} 
	
	public String boardView(){
		System.out.println("글읽기 액션 들어옴");
		HttpServletRequest request = null ; 
//		String num = request.getParameter("boardnum");
		String num = ServletActionContext.getRequest().getParameter("boardnum");
		board = dao.view(num);
		System.out.println(board);
		return SUCCESS; 
	}
	
	public String test(){
		return SUCCESS; 
		
	}



	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BoardDAO getDao() {
		return dao;
	}

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	public ArrayList<Board> getList() {
		return list;
	}

	public void setList(ArrayList<Board> list) {
		this.list = list;
	}

//getter&setter
	
}
