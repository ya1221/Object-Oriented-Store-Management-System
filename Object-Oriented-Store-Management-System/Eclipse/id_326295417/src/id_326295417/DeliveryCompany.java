package id_326295417;

public abstract class DeliveryCompany {
	protected String contact;
	protected String whats_up;

	protected DeliveryCompany() {
		this.contact = null;
		this.whats_up = null;
	}

	protected DeliveryCompany(String contact, String whtaUp) {
		this.contact = contact;
		this.whats_up = whtaUp;
	}

	public void update() {
		System.out.println(
				"Hello " + getClass().getSimpleName() + ".\nPlease bring the shipping fees for the order received.");
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Delivery company: " + getClass().getSimpleName() + ", person contact: " + this.contact
				+ ", number: " + this.whats_up);
		return res.toString();
	}
}
