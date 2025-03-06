package id_326295417;

public class CustomerFactory implements Factorable {
	public static Customer create() {
		return new Customer();
	}

	public static Customer create(String name, String mobile) {
		return new Customer(name, mobile);
	}
}
