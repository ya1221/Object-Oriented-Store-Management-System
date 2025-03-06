package id_326295417;

public abstract class Shipping {
	protected String name_shipping;
	protected DeliveryCompany deliveryCompany;

	protected Shipping() {
		this.name_shipping = null;
		this.deliveryCompany = null;
	}

	protected Shipping(String name, DeliveryCompany deliveryCompany) {
		this.name_shipping = name;
		this.deliveryCompany = deliveryCompany;
	}

	public String getName() {
		return this.name_shipping;
	}

	public void setNameSipping(String name) {
		this.name_shipping = name;
	}

	public void setDeliveryCompany(DeliveryCompany delCompany) {
		this.deliveryCompany = delCompany;
	}

	abstract double shippingFees(Order order);

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Type shipping: " + this.name_shipping + ", " + this.deliveryCompany.toString());
		return res.toString();
	}
}
