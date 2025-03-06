package id_326295417;

import java.util.Objects;

public class StandardDHL extends StandardShipping {
	private final int max_price = 100;
	private static StandardDHL _instance = null;

	private StandardDHL() {
	}

	private StandardDHL(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public static StandardDHL getStandardDHL() {
		if (_instance == null)
			_instance = new StandardDHL();
		return _instance;
	}

	public static StandardDHL getStandardDHL(String name, DeliveryCompany deliveryCompany) {
		if (_instance == null)
			_instance = new StandardDHL(name, deliveryCompany);
		return _instance;
	}

	@Override
	public double shippingFees(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		float priceTax = product.getSellingPrice() * order.getAmount();
		if (priceTax / 10 > max_price)
			return max_price;
		return priceTax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(StandardDHL.class.getSimpleName());
	}

	public String tostring(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		StringBuffer res = new StringBuffer();
		res.append("Price selling customer: " + product.getSellingPrice() + "\nAmount: " + order.getAmount()
				+ "\nShiiping fee: " + shippingFees(order) + "\n" + super.toString());
		return res.toString();
	}
}
