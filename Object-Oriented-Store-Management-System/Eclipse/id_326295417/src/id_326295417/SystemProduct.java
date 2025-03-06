package id_326295417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SystemProduct {
	private Set<Product> product_set;
	private Set<CountryTax> countryTax_set;
	private NotificationService notify;
	private Set<Shipping> shippingWithCompanyDelivery_set;
	private Stack<Order> allOrder_set;
	private static SystemProduct _instance = null;

	private SystemProduct() {
		this.product_set = new TreeSet<>();
		this.countryTax_set = new HashSet<>();
		this.notify = NotificationServiceFactory.create();
		this.shippingWithCompanyDelivery_set = new HashSet<>();
		this.allOrder_set = new Stack<Order>();
	}

	public static SystemProduct getSystemProduct() {
		if (_instance == null)
			_instance = new SystemProduct();
		return _instance;
	}

	public static class Momento {
		private final Set<Product> product_set;
		private final Set<CountryTax> countryTax_set;
		private final NotificationService notify;
		private final Set<Shipping> shippingWithCompanyDelivery_set;
		private final Stack<Order> allOrder_set;

		private Momento(Set<Product> productSet, Set<CountryTax> countryTaxSet, NotificationService notify,
				Set<Shipping> shippingWithCompanyDeliverySet, Stack<Order> allOrderSet) {
			this.product_set = new TreeSet<>();
			for (Product product : productSet)
				this.product_set.add(AbstractFactoryProduct.createCopyProduct(product));
			this.countryTax_set = new HashSet<>(countryTaxSet);
			this.notify = new NotificationService(notify);
			this.shippingWithCompanyDelivery_set = new HashSet<>(shippingWithCompanyDeliverySet);
			this.allOrder_set = new Stack<Order>();
			for (Order order : allOrderSet)
				this.allOrder_set.push(OrderFactory.createCopy(order));
		}
	}

	public Momento createMomento() {
		return new Momento(this.product_set, this.countryTax_set, this.notify, this.shippingWithCompanyDelivery_set,
				this.allOrder_set);
	}

	public void setMomento(Momento m) {
		this.product_set = m.product_set;
		this.countryTax_set = m.countryTax_set;
		this.notify = m.notify;
		this.shippingWithCompanyDelivery_set = m.shippingWithCompanyDelivery_set;
		for (Order order : m.allOrder_set)
			this.allOrder_set.push(order);
	}

	public Set<Product> getProductSet() {
		return this.product_set;
	}

	public Set<CountryTax> getCountryTaxSet() {
		return this.countryTax_set;
	}

	public NotificationService getNotify() {
		return this.notify;
	}

	public Set<Shipping> getShippingWithCompanyDeliverySet() {
		return this.shippingWithCompanyDelivery_set;
	}

	public Stack<Order> getAllOrderStack() {
		return this.allOrder_set;
	}

	public void setAllOrderStack(Stack<Order> allOrder) {
		this.allOrder_set = allOrder;
	}

	public void newOrder() {
		this.notify.newOrderUpdate();
	}

	public ArrayList<Product> printProductByType(String type) {
		ArrayList<Product> productArray = new ArrayList<>();
		if (this.product_set.size() > 0) {
			System.out.println("This is the list of all the product from this type:");
			Iterator<?> it = this.product_set.iterator();
			int i = 1;
			Product pro;
			while (it.hasNext()) {
				pro = (Product) it.next();
				if (pro.getClass().getSimpleName().equals(type)) {
					System.out.println(i + ") " + pro.toString());
					productArray.add(pro);
					i++;
				}
			}
			return productArray;
		} else
			System.out.println("There is no product.\n");
		return null;
	}

	public void printAllProduct() {
		if (this.product_set.size() > 0) {
			System.out.println("This is the list of all the product:");
			Iterator<?> it = this.product_set.iterator();
			int i = 1;
			Product pro;
			while (it.hasNext()) {
				pro = (Product) it.next();
				System.out.println(i + ") " + pro.toString());
				i++;
			}
		} else
			System.out.println("There is no product.\n");
	}

	public void printAllCountryTax() {
		if (this.countryTax_set.size() > 0) {
			System.out.println("This is the list of all the country in the system and thier import tax:");
			Iterator<?> it = this.countryTax_set.iterator();
			int i = 1;
			CountryTax coT;
			while (it.hasNext()) {
				coT = (CountryTax) it.next();
				System.out.println(i + ") " + coT.toString());
				i++;
			}
			System.out.println();
		} else
			System.out.println("There is no country tax.\n");
	}

	public String toString() {
		if (this.product_set.size() > 0) {
			Iterator<?> it = this.product_set.iterator();
			StringBuffer res = new StringBuffer();
			int i = 1, sum = 0;
			Product pro;
			while (it.hasNext()) {
				pro = (Product) it.next();
				res.append(i + ") " + pro.allInfoProduct() + "\n");
				sum += pro.profitAllOrder();
				i++;
			}
			res.append("The total profit from all the product is: " + sum + "\n");
			return res.toString();
		} else
			return null;
	}
}
