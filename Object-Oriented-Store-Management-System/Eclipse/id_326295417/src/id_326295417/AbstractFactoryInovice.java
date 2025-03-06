package id_326295417;

public abstract class AbstractFactoryInovice implements Factorable {
	public static Invoice createInovice(int type) {
		Invoice invoice = null;
		switch (type) {
		case 1:
			invoice = FormatForCustomerFactory.create();
			break;
		case 2:
			invoice = FormatForAccountantFactory.create();
			break;
		}
		return invoice;
	}
}
