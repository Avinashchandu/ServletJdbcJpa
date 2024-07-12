package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: customer
 *
 */
@Entity
@Table(name = "c_d")
public class customer implements Serializable {

	   
	@Id
	@Column(name="id",length = 5)
	private int Cid;
	@Column(name = "name",length=30,nullable = true)
	private String name;
	@Column(name="email",length=20)
	private String email;
	@Column(name="password",length=4)
	private String password;
	@Column(name="number",length=10)
	private String number;
	private static final long serialVersionUID = 1L;

	public customer() {
		super();
	}   
	public int getCid() {
		return this.Cid;
	}

	public void setCid(int Cid) {
		this.Cid = Cid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
   
}
