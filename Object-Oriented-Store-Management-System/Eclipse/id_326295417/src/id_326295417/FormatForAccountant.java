package id_326295417;

public class FormatForAccountant extends Invoice {
	private final double PercentVAT = 0.17;

	public FormatForAccountant() {
		super("Format for accountant");
	}

	public FormatForAccountant(Order order) {
		super("Format for accountant", order);
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(super.toString() + "	VAT: " + order.priceOrder() * this.PercentVAT + "\n");
		return res.toString();
	}
}
