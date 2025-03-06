package id_326295417;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
	private List<DeliveryCompany> deliveryCompanies_arr;

	public NotificationService() {
		this.deliveryCompanies_arr = new ArrayList<>();
	}

	public NotificationService(NotificationService notify) {
		this.deliveryCompanies_arr = notify.getDeliveryCompaniesArr();
	}

	public List<DeliveryCompany> getDeliveryCompaniesArr() {
		return this.deliveryCompanies_arr;
	}

	public void addListener(DeliveryCompany listener) {
		this.deliveryCompanies_arr.add(listener);
	}

	public void removeListener(DeliveryCompany listener) {
		this.deliveryCompanies_arr.remove(listener);
	}

	public void newOrderUpdate() {
		this.deliveryCompanies_arr.forEach(listener -> listener.update());
	}
}
