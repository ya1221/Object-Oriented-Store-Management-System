package id_326295417;

public class FormatForCustomer extends Invoice {

	public FormatForCustomer() {
		super("Format for customer");
	}

	public FormatForCustomer(Order order) {
		super("Format for customer", order);
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(super.toString() + "	The profit: " + order.profitOrder() + "\n");
		return res.toString();
	}
}
