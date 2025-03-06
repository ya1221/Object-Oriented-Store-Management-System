package id_326295417;

public class DHL extends DeliveryCompany{
	private static DHL _instance = null;

	private DHL() {
		super();
	}
	
	private DHL(String contact, String whtaUp) {
		super(contact, whtaUp);
	}

	public static DHL getDHL() {
		if (_instance == null)
			_instance = new DHL();
		return _instance;
	}

	public static DHL getDHL(String contact, String whtaUp) {
		if (_instance == null)
			_instance = new DHL(contact, whtaUp);
		return _instance;
	}
	
	public String toString() {
		return super.toString();
	}
}
