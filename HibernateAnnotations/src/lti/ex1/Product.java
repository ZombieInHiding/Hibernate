package lti.ex1;
//javax.persistence standard library
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.NamedNativeQuery;

@Entity
@Table(name="product")  //Table Name
@NamedQuery(name="getAll", query="from Product order by code")
@NamedNativeQuery(name="code1", query = "select * from product where p_code = 1")

public class Product {
	@Id  //primary key
	@GeneratedValue(strategy=GenerationType.AUTO)	//auto-generated
	@Column(name="p_code")
	private int code;
	@Column(name="p_name", length=30)
	private String name;
	private double price;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
