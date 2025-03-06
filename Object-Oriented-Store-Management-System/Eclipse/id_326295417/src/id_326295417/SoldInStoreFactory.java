package id_326295417;

public class SoldInStoreFactory extends AbstractFactoryProduct {
	public static SoldInStore create() {
		return new SoldInStore();
	}

	public static SoldInStore create(String serialNumber, String name, int costP, int sellP, int stock) {
		return new SoldInStore(serialNumber, name, costP, sellP, stock);
	}

	public static SoldInStore createCopy(Product product) {
		return new SoldInStore(product);
	}
}
