package id_326295417;

public class SoldToWholesalers extends Product {
	public SoldToWholesalers() {
		super();
	}

	public SoldToWholesalers(String serialNumber, String name, int costP, int sellP, int stock) {
		super(serialNumber, name, costP, sellP, stock);
	}
	
	public SoldToWholesalers(Product product) {
		super(product);
	}

	public String toSting() {
		return super.toString();
	}
}
