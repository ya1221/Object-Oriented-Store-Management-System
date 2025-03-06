package id_326295417;

public abstract class StandardShipping extends Shipping {
	protected StandardShipping() {
	}

	protected StandardShipping(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public String toString() {
		return super.toString();
	}
}
