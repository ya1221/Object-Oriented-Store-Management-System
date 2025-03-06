package id_326295417;

import java.util.Objects;

public abstract class Invoice {
	protected String name;
	protected Order order;

	protected Invoice(String name) {
		this.name = name;
		this.order = null;
	}

	protected Invoice(String name, Order order) {
		this.name = name;
		this.order = order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}

	public boolean equals(Object other) {
		if (!(other instanceof Invoice))
			return false;
		Invoice another = (Invoice) other;
		return this.name.equals(another.name);
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(this.name + ":\n	" + this.order.toStringProductForCustomer());
		return res.toString();
	}
}
