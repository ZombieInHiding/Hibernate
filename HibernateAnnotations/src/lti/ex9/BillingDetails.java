package lti.ex9;

public abstract class BillingDetails {

	private int id;
	private String holder;
	private String number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "BillingDetails [ id = " + id + ", holder = " + holder + " , number = " + number + " ]";
	}

}
