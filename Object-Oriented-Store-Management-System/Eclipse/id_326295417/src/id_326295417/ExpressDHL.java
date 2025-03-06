package id_326295417;

import java.util.Objects;

public class ExpressDHL extends ExpressShipping {
	private final double shipping_fee = 100;
	private static ExpressDHL _instance = null;

	private ExpressDHL() {
	}

	private ExpressDHL(String name, DeliveryCompany deliveryCompany) {
		super(name, deliveryCompany);
	}

	public static ExpressDHL getExpressDHL() {
		if (_instance == null)
			_instance = new ExpressDHL();
		return _instance;
	}

	public static ExpressDHL getExpressDHL(String name, DeliveryCompany deliveryCompany) {
		if (_instance == null)
			_instance = new ExpressDHL(name, deliveryCompany);
		return _instance;
	}

	@Override
	public double shippingFees(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		return shipping_fee + product.getDestCountery().getImportTax();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ExpressDHL.class.getSimpleName());
	}

	public String tostring(Order order) {
		SoldThroughWebsite product = (SoldThroughWebsite) order.getProduct();
		StringBuffer res = new StringBuffer();
		res.append("Price selling customer: " + product.getSellingPrice() + "\nAmount: " + order.getAmount()
				+ "\nShipping fee: " + shippingFees(order) + "\n" + super.toString());
		return res.toString();
	}

}
