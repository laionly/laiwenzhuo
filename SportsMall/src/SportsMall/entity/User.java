package SportsMall.entity; 
/**
 * User generated by hbm2java
 */
public class User{

	private int id;
	private String username;//名字
	private String password;//密码
	private String phone;//手机号
	private String email;//邮箱
	private String address;//地址
	private int code;

	public User() {
	}
	
	public User(int id, String username, String password, String phone, String email, String address, int code) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.code = code;
	}
	

	public User(String username, String password, String phone, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}


	public User(int id,String username, String password, String phone, String email, String address) {
		this.id=id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	//注册所用构造方法
	public User(String username, String password, String phone, String email, String address,int code) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.code = code;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", code=" + code + "]";
	}

	
	

}
