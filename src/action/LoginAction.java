package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CustomerDAO;
import vo.Customer;

public class LoginAction extends ActionSupport implements SessionAware {

	// 폼에서 입력한 값
	private String id = "";
	private String pw = "";

	// 로그인 시 valueStack에서 사용할 값
	private String custid;
	private String password;
	private String name;
	private String msg;
	private Map<String, Object> session = new HashMap<String, Object>();

	// mybatis
	private CustomerDAO dao = new CustomerDAO();
	private Customer cus = new Customer();

	public LoginAction() {
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> sess) {
		this.session = sess;
	}

	/*
	 * validate 메소드, 무조건 execute보다 먼저 실행 로그아웃 할 때는 입력한 id,pw가 없어서 null 뜨는 문제 있음
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	public void validate() {
		System.out.println("validate 실행");
		System.out.println(id + "     " + pw);

		// if (session.get("loginId") == null) {}

		if (id.equals("") || id.length() < 3) {
			System.out.println("아이디 유효성 마크");
			addFieldError("id", "아이디를 입력해주세요");
		}
		if (pw.equals("") || pw.length() < 3) {
			System.out.println("패스워드 유효성 마크");
			addFieldError("pw", "패스워드를 입력해주세요");
		}

	}

	public String execute() throws Exception {
		System.out.println("실행");
		cus.setCustid(id);
		cus.setPassword(pw);
		System.out.println(cus + "객체");
		this.cus = dao.checkLoginUser(cus);
		if (cus != null) {// FIXME cus라는 참조변수에 가비지 값이 들어있을 위험 있지 않을까?
			// 로그인 가능자면 세션에 저장
			session.put("loginId", cus.getCustid());
			System.out.println("저장된 id 세션값"+session.get("loginId"));
			session.put("loginName", cus.getName());
			// session.clear();//이건 로그아웃할 때 써라

			// session.remove("loginId");//특정세션만 날리고 싶을 떄
			msg = "님 환영합니다.";
			System.out.println("session 저장완료");
		} else {
			msg = "아이디 또는 비밀번호가 잘못되었습니다.";
		}

		return SUCCESS;
	}

	public String logout() throws Exception {
		System.out.println("로그아웃 액션 실행");
		session.clear();

		return SUCCESS;
	}

	// get&set

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
