package id_326295417;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Product implements Comparable<Product> {
	private String serial_number_product;
	private String product_name;
	private int cost_price;
	private int selling_price;
	private int stock;
	private Set<Order> order_set;

	public Product(String serialNumber, String name, int costP, int sellP, int stock) {
		this.serial_number_product = serialNumber;
		this.product_name = name;
		this.cost_price = costP;
		this.selling_price = sellP;
		this.stock = stock;
		this.order_set = new LinkedHashSet<>();
	}

	public Product() {
		this.serial_number_product = null;
		this.product_name = null;
		this.cost_price = 0;
		this.selling_price = 0;
		this.stock = 0;
		this.order_set = new LinkedHashSet<>();
	}

	public Product(Product product) {
		this.serial_number_product = product.serial_number_product;
		this.product_name = product.product_name;
		this.cost_price = product.cost_price;
		this.selling_price = product.selling_price;
		this.stock = product.stock;
		this.order_set = new LinkedHashSet<>();
		for (Order order : product.order_set)
			this.order_set.add(new Order(order, product));
	}

	public String getSerialNumber() {
		return this.serial_number_product;
	}

	public int getSellingPrice() {
		return this.selling_price;
	}

	public int getStock() {
		return this.stock;
	}

	public Set<Order> getOrderSet() {
		return this.order_set;
	}

	public void setSerialNumber(String serialNumber) {
		this.serial_number_product = serialNumber;
	}

	public void setName(String name) {
		this.product_name = name;
	}

	public void setCostPrice(int costP) {
		this.cost_price = costP;
	}

	public void setSellingPrice(int sellP) {
		this.selling_price = sellP;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void reduceStock(int lose) {
		this.stock -= lose;
	}

	public int profitPrice() {
		return this.selling_price - this.cost_price;
	}

	public int profitAllOrder() {
		int sum = 0;
		for (Order order : this.order_set)
			sum += order.profitOrder();
		return sum;
	}

	public String infoAllOrderInProduct() {
		Iterator<?> it = this.order_set.iterator();
		StringBuffer res = new StringBuffer();
		int i = 1, sum = 0, profit;
		Order order;
		while (it.hasNext()) {
			order = (Order) it.next();
			profit = order.profitOrder();
			res.append(i + ") " + order.infoOrder() + "	Profit: " + profit + "\n");
			sum += profit;
			i++;
		}
		res.append("\nThe total profit from all the order of this product is: " + sum);
		return res.toString();
	}

	public String allInfoAllOrderInProduct() {
		Iterator<?> it = this.order_set.iterator();
		StringBuffer res = new StringBuffer();
		int i = 1;
		Order order;
		while (it.hasNext()) {
			order = (Order) it.next();
			res.append("	" + i + ") " + order.infoOrder() + order.allInfoOrderInvoice()
					+ order.allInfoOrderShipping() + "\n");
			i++;
		}
		return res.toString();
	}

	public String allInfoProduct() {
		StringBuffer res = new StringBuffer();
		res.append(toString() + "\n" + allInfoAllOrderInProduct() + "	The total profit from the product - "
				+ this.product_name + " - " + profitAllOrder() + "\n");
		return res.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.serial_number_product);
	}

	@Override
	public int compareTo(Product other) {
		return this.serial_number_product.compareTo(other.serial_number_product);
	}

	public boolean equals(Object other) {
		if (!(other instanceof Product))
			return false;
		Product another = (Product) other;
		return this.serial_number_product.equals(another.serial_number_product);
	}

	public String toStringProductForCustomer() {
		StringBuffer res = new StringBuffer();
		res.append(getClass().getSimpleName() + " - Serial number product: " + this.serial_number_product + ", name: "
				+ this.product_name + ", selling price: " + this.selling_price);
		return res.toString();
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(toStringProductForCustomer() + ", stock: " + this.stock + ", cost price: " + this.cost_price);
		return res.toString();
	}
}
