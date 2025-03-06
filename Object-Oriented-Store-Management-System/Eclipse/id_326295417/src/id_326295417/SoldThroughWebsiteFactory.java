package id_326295417;

public class SoldThroughWebsiteFactory extends AbstractFactoryProduct {
	public static SoldThroughWebsite create() {
		return new SoldThroughWebsite();
	}

	public static SoldThroughWebsite create(String serialNumber, String name, int costP, int sellP, int stock,
			double weight, CountryTax destCountery) {
		return new SoldThroughWebsite(serialNumber, name, costP, sellP, stock, weight, destCountery);
	}

	public static SoldThroughWebsite createCopy(Product product) {
		return new SoldThroughWebsite(product);
	}
}
