package id_326295417;

import java.util.Objects;

public class StandardFedEx extends StandardShipping {
	private final double weight_for_price = 10;
	private final double price_for_weight = 10;
	private static StandardFedEx _instance = null;

	private StandardFedEx() {
	}

	private StandardFedEx(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public static StandardFedEx getStandardFedEx() {
		if (_instance == null)
			_instance = new StandardFedEx();
		return _instance;
	}

	public static StandardFedEx getStandardFedEx(String name, DeliveryCompany deliveryCompany) {
		if (_instance == null)
			_instance = new StandardFedEx(name, deliveryCompany);
		return _instance;
	}

	@Override
	public double shippingFees(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		return (product.getWeight() * order.getAmount()) / this.weight_for_price * this.price_for_weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(StandardFedEx.class.getSimpleName());
	}

	public String tostring(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		StringBuffer res = new StringBuffer();
		res.append("Price selling customer: " + product.getSellingPrice() + "\nAmount: " + order.getAmount()
				+ "\nShiiping fee: " + shippingFees(order) + "\n" + super.toString());
		return res.toString();
	}
}
