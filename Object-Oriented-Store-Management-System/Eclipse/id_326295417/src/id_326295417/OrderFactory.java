package id_326295417;

public class OrderFactory implements Factorable {
	public static Order create() {
		return new Order();
	}

	public static Order create(String serialNumber, Product product, Customer customer, int amount, Shipping shipping) {
		return new Order(serialNumber, product, customer, amount, shipping);
	}

	public static Order createCopy(Order order) {
		return new Order(order);
	}
}
