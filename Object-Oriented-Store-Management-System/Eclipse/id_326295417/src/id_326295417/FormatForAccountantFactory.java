package id_326295417;

public class FormatForAccountantFactory extends AbstractFactoryInovice {
	public static FormatForAccountant create() {
		return new FormatForAccountant();
	}

	public static FormatForAccountant create(Order order) {
		return new FormatForAccountant(order);
	}
}
