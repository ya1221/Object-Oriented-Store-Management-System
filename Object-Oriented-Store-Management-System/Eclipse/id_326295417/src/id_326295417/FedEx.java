package id_326295417;

public class FedEx extends DeliveryCompany{
	private static FedEx _instance = null;

	private FedEx() {
		super();
	}
	
	private FedEx(String contact, String whtaUp) {
		super(contact, whtaUp);
	}

	public static FedEx getFedEx() {
		if (_instance == null)
			_instance = new FedEx();
		return _instance;
	}

	public static FedEx getFedEx(String contact, String whtaUp) {
		if (_instance == null)
			_instance = new FedEx(contact, whtaUp);
		return _instance;
	}
	
	public String toString() {
		return super.toString();
	}
}
