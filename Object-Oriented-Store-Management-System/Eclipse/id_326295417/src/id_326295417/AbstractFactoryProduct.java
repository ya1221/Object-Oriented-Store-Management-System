package id_326295417;

public abstract class AbstractFactoryProduct implements Factorable {
	public static Product createProduct(int type) {
		Product product = null;
		switch (type) {
		case 1:
			product = SoldThroughWebsiteFactory.create();
			break;
		case 2:
			product = SoldInStoreFactory.create();
			break;
		case 3:
			product = SoldToWholesalersFactory.create();
			break;
		}
		return product;
	}

	public static Product createCopyProduct(Product product) {
		Product copyProduct = null;
		if (product instanceof SoldThroughWebsite)
			copyProduct = SoldThroughWebsiteFactory.createCopy(product);
		else if (product instanceof SoldInStore)
			copyProduct = SoldInStoreFactory.createCopy(product);
		else
			copyProduct = SoldToWholesalersFactory.createCopy(product);
		return copyProduct;
	}
}
