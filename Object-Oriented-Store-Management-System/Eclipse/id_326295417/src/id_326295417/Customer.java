package id_326295417;

import java.util.Objects;

public class Customer {
	private String customer_name;
	private String mobile;

	public Customer() {
		this.customer_name = null;
		this.mobile = null;
	}

	public Customer(String name, String mobile) {
		this.customer_name = name;
		this.mobile = mobile;
	}

	public String getCustomerName() {
		return this.customer_name;
	}

	public void setCustomerName(String name) {
		this.customer_name = name;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.customer_name, this.mobile);
	}

	public boolean equals(Object other) {
		if (!(other instanceof Customer))
			return false;
		Customer cus = (Customer) other;
		return this.customer_name.equals(cus.customer_name) && this.mobile.equals(cus.mobile);
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(getClass().getSimpleName() + "-\n	Name: " + this.customer_name + ", mobile: " + this.mobile);
		return res.toString();
	}
}
