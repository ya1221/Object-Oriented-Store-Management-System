package id_326295417;

public enum ProductType {
	SoldThroughWebsite("Sold Through Website"), SoldInStore("Sold In Store"), SoldToWholesalers("Sold To Wholesalers");

	private final String productName;

	private ProductType(String name) {
		this.productName = name;
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(this.productName);
		return res.toString();
	}
}
