package id_326295417;

import java.util.HashSet;
import java.util.Set;

public class SoldThroughWebsite extends Product {
	private final char symbol_cost = '$';
	private double product_weight;
	private Set<String> shipping_set;
	private CountryTax dest_countery;

	public SoldThroughWebsite() {
		super();
		this.product_weight = 0;
		this.shipping_set = new HashSet<>();
		this.dest_countery = null;
	}

	public SoldThroughWebsite(String serialNumber, String name, int costP, int sellP, int stock, double weight,
			CountryTax destCountery) {
		super(serialNumber, name, costP, sellP, stock);
		this.product_weight = weight;
		this.shipping_set = new HashSet<>();
		this.dest_countery = destCountery;
	}

	public SoldThroughWebsite(Product product) {
		super(product);
		SoldThroughWebsite pro = (SoldThroughWebsite) product;
		this.product_weight = pro.product_weight;
		this.shipping_set = new HashSet<>(pro.shipping_set);
		this.dest_countery = CountryTaxFactory.createCopy(pro.dest_countery);
	}

	public double getWeight() {
		return this.product_weight;
	}

	public Set<String> getShippingSet() {
		return this.shipping_set;
	}

	public CountryTax getDestCountery() {
		return this.dest_countery;
	}

	public void setWeight(double weight) {
		this.product_weight = weight;
	}

	public void SetDestCountry(CountryTax destCountery) {
		this.dest_countery = destCountery;
	}

	public String toStringProductForCustomer() {
		StringBuffer res = new StringBuffer();
		res.append(super.toStringProductForCustomer() + this.symbol_cost);
		return res.toString();
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(super.toString() + this.symbol_cost + ", weight: " + this.product_weight + ", "
				+ this.dest_countery.toString());
		return res.toString();
	}

}
