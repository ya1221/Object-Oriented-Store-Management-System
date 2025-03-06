package id_326295417;

import java.util.Objects;

public class ExpressFedEx extends ExpressShipping {
	private final double weight_for_price = 10;
	private final double price_for_weight = 50;
	private static ExpressFedEx _instance = null;

	private ExpressFedEx() {
	}

	private ExpressFedEx(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public static ExpressFedEx getExpressFedEx() {
		if (_instance == null)
			_instance = new ExpressFedEx();
		return _instance;
	}

	public static ExpressFedEx getExpressFedEx(String name, DeliveryCompany deliveryCompany) {
		if (_instance == null)
			_instance = new ExpressFedEx(name, deliveryCompany);
		return _instance;
	}

	@Override
	public double shippingFees(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		return (product.getWeight() * order.getAmount()) / this.weight_for_price * this.price_for_weight
				+ product.getDestCountery().getImportTax();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ExpressFedEx.class.getSimpleName());
	}

	public String tostring(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		StringBuffer res = new StringBuffer();
		res.append("Price selling customer: " + product.getSellingPrice() + "\nAmount: " + order.getAmount()
				+ "\nShipping fee: " + shippingFees(order) + "\n" + super.toString());
		return res.toString();
	}
}
