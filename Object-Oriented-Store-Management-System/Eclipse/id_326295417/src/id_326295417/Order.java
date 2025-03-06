package id_326295417;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Order {
	private String serial_number_order;
	private Product product;
	private Customer customer;
	private int amount;
	private Shipping shipping;
	private Set<Invoice> invoice_set;

	public Order() {
		this.serial_number_order = null;
		this.product = null;
		this.customer = null;
		this.amount = 0;
		this.shipping = null;
		this.invoice_set = new LinkedHashSet<>();
	}

	public Order(String serialNumber, Product product, Customer customer, int amount, Shipping shipping) {
		this.serial_number_order = serialNumber;
		this.product = product;
		this.customer = customer;
		this.amount = amount;
		this.shipping = shipping;
		this.invoice_set = new LinkedHashSet<>();
	}

	public Order(Order order) {
		this.serial_number_order = order.serial_number_order;
		this.product = AbstractFactoryProduct.createCopyProduct(order.product);
		this.customer = order.customer;
		this.amount = order.amount;
		this.shipping = order.shipping;
		this.invoice_set = new LinkedHashSet<>(order.getInvoiceSet());
	}

	public Order(Order order, Product product) {
		this.serial_number_order = order.serial_number_order;
		this.product = product;
		this.customer = order.customer;
		this.amount = order.amount;
		this.shipping = order.shipping;
		this.invoice_set = new LinkedHashSet<>(order.getInvoiceSet());
	}

	public Product getProduct() {
		return this.product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setSerialNumber(String serialNumber) {
		this.serial_number_order = serialNumber;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Set<Invoice> getInvoiceSet() {
		return this.invoice_set;
	}

	public int profitOrder() {
		return this.product.profitPrice() * this.amount;
	}

	public int priceOrder() {
		return this.product.getSellingPrice() * this.amount;
	}

	public String infoAllInvoiceInOrder() {
		StringBuffer res = new StringBuffer();
		Iterator<?> it = this.invoice_set.iterator();
		int i = 1;
		Invoice invoice;
		while (it.hasNext()) {
			invoice = (Invoice) it.next();
			res.append("	" + i + ") " + invoice.toString() + "\n");
			i++;
		}
		return res.toString();
	}

	public String allInfoOrderInvoice() {
		StringBuffer res = new StringBuffer();
		if (this.invoice_set.size() != 0)
			res.append("\n	List of all invoice:\n" + infoAllInvoiceInOrder());
		return res.toString();
	}

	public String allInfoOrderShipping() {
		StringBuffer res = new StringBuffer();
		if (this.shipping != null)
			res.append("\n	Shipping: " + this.shipping.toString() + "\n");
		return res.toString();
	}

	public String infoOrder() {
		StringBuffer res = new StringBuffer();
		res.append(getClass().getSimpleName() + "-\n	The amount: " + this.amount + ", serial number order: "
				+ this.serial_number_order + ", total price: " + priceOrder() + "\n	" + customer.toString() + "\n");
		return res.toString();
	}

	public String toStringProductForCustomer() {
		StringBuffer res = new StringBuffer();
		res.append(this.product.toStringProductForCustomer() + "\n	" + infoOrder());
		return res.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(serial_number_order);
	}

	public boolean equals(Object other) {
		if (!(other instanceof Order))
			return false;
		Order another = (Order) other;
		return this.serial_number_order.equals(another.serial_number_order);
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(this.product.toString() + infoOrder());
		return res.toString();
	}
}