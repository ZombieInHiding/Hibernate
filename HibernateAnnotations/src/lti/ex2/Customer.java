package lti.ex2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Mandatory Annotations --- @Entity and @Id

@Entity
@Table(name="customer")
@SequenceGenerator(name="seqgen", sequenceName="cust_seq")//Using database sequence 
public class Customer {
	@Id
	@GeneratedValue(generator="seqgen")
	@Column(name="cust_id")
	private int custId;
	@Column(name="cust_name")
	private String custName;
	private double credit;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

}
