package id_326295417;

public class SoldInStore extends Product {
	private final char symbol_cost = '₪';

	public SoldInStore() {
		super();
	}

	public SoldInStore(String serialNumber, String name, int costP, int sellP, int stock) {
		super(serialNumber, name, costP, sellP, stock);
	}

	public SoldInStore(Product product) {
		super(product);
	}

	public String toStringProductForCustomer() {
		StringBuffer res = new StringBuffer();
		res.append(super.toStringProductForCustomer() + this.symbol_cost);
		return res.toString();
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(super.toString() + this.symbol_cost);
		return res.toString();
	}
}
