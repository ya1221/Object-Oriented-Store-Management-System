package id_326295417;

public abstract class ExpressShipping extends Shipping {
	protected ExpressShipping() {
	}

	protected ExpressShipping(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public String toString() {
		return super.toString();
	}
}
