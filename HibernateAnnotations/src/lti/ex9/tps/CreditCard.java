package lti.ex9.tps;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="creditcard_details_jpa_2")
public class CreditCard extends BillingDetails {
	private String type;
	private String expiry;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "CreditCard [ type = " + type + ", expiry = " + expiry + " , toString() = " + super.toString() + " ]";
	}

}
