package id_326295417;

public class FormatForCustomerFactory extends AbstractFactoryInovice {
	public static FormatForCustomer create() {
		return new FormatForCustomer();
	}

	public static FormatForCustomer create(Order order) {
		return new FormatForCustomer(order);
	}
}
