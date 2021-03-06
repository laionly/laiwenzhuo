package SportsMall.entity;
// default package

// Generated 2019-11-13 9:55:46 by Hibernate Tools 5.2.3.Final

/**
 * Myadmin generated by hbm2java
 */
public class Myadmin {

	private int id;
	private String loginname;

	private String password;
	private String phone;
	private String email;
	private String address;
	private int code;

	public Myadmin() {
	}

	

	public Myadmin(int id, String loginname, String password, String phone, String email, String address, int code) {
		super();
		this.id = id;
		this.loginname = loginname;
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

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
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
		return "Myadmin [id=" + id + ", loginname=" + loginname + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", code=" + code + "]";
	}

}
