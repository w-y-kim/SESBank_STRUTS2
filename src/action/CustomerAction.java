package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.CustomerDAO;
import vo.Customer;

public class CustomerAction extends ActionSupport {
	
	CustomerDAO dao = new CustomerDAO(); 
	Customer customer = new Customer();
	
	//가입시 입력 값 
	private String custid;
	private String pw;
	private String name;
	private String mail;
	private String rd;
	private String identify;
	private String addr;
	
	public String execute() {
		System.out.println("실행");
		return SUCCESS;
	}

	public String insertCustomer() {
		System.out.println("insertCustomer 실행");
		customer = new Customer(custid, pw, name, mail, rd, identify,addr); 
		boolean result = dao.insertCustomer(customer);
		System.out.println("등록성공여부 : "+result);
		return SUCCESS;
	}
	
	
	public String selectCusIf() throws Exception{
		System.out.println("selectCusIf 실행");
		customer.setCustid("vvv");
		this.customer = dao.selectCusIf(customer);
		System.out.println(customer);
		
		return SUCCESS;
	}
	
	public String idCheck() throws Exception{
		
		
		return SUCCESS; 
	}
	
	//get&set

	public CustomerDAO getDao() {
		return dao;
	}

	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRd() {
		return rd;
	}

	public void setRd(String rd) {
		this.rd = rd;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	
		
}
