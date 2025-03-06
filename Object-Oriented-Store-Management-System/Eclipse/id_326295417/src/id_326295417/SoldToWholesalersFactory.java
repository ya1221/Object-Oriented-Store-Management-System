package id_326295417;

public class SoldToWholesalersFactory extends AbstractFactoryProduct {
	public static SoldToWholesalers create() {
		return new SoldToWholesalers();
	}

	public static SoldToWholesalers create(String serialNumber, String name, int costP, int sellP, int stock) {
		return new SoldToWholesalers(serialNumber, name, costP, sellP, stock);
	}

	public static SoldToWholesalers createCopy(Product product) {
		return new SoldToWholesalers(product);
	}
}
