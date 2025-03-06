package id_326295417;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import id_326295417.SystemProduct.Momento;

public class FacadeSystemProduct {
	private static Scanner input = new Scanner(System.in);
	private static Stack<Momento> stack = new Stack<>();

	private FacadeSystemProduct() {
	}

	public static boolean addNewPruduct(SystemProduct syPr) {
		System.out.println("New product:");
		Product product;
		product = createProduct(syPr);
		return syPr.getProductSet().add(product);
	}

	public static int chooseTypeProduct(SystemProduct syPr) {
		int type, i;
		do {
			i = 1;
			System.out.println("Please choose the type product:");
			for (ProductType productType : ProductType.values()) {
				System.out.println(i + ") " + productType.toString());
				i++;
			}
			type = input.nextInt();
		} while (type < 1 || type > 3);
		return type;
	}

	public static String chooseTypeShipping(SystemProduct syPr, SoldThroughWebsite product) {
		Iterator<?> it = product.getShippingSet().iterator();
		int i = 1;
		String type;
		while (it.hasNext()) {
			type = (String) it.next();
			System.out.println(i + ") " + type);
			i++;
		}
		System.out.println();
		int choose = Halper.chooseObject(syPr, product.getShippingSet().size());
		return Halper.getObjectFromSet(product.getShippingSet(), choose);
	}

	public static Product createProduct(SystemProduct syPr) {
		int type = chooseTypeProduct(syPr);
		Product product = AbstractFactoryProduct.createProduct(type);
		if (type == 1)
			getNewPruductSoldThroughWebsite(syPr, (SoldThroughWebsite) product);
		else if (type == 2 || type == 3)
			getNewProductInfo(product);
		return product;
	}

	public static void getNewProductInfo(Product product) {
		String newString;
		System.out.println("Please enter the serial number:");
		newString = Halper.getNewString();
		product.setSerialNumber(newString);
		System.out.println("Please enter the name:");
		newString = Halper.getNewString();
		product.setName(newString);
		int num = Halper.getPositiveNum("Please enter cost price:");
		product.setCostPrice(num);
		num = Halper.getPositiveNum("Please enter selling price:");
		product.setSellingPrice(num);
		num = Halper.getPositiveNum("Please enter stock:");
		product.setStock(num);
	}

	public static void getNewPruductSoldThroughWebsite(SystemProduct syPr, SoldThroughWebsite product) {
		getNewProductInfo(product);
		float weight;
		do {
			System.out.println("Please enter weight: (above 0 - example 3.5)");
			weight = input.nextFloat();
		} while (weight <= 0);
		product.setWeight(weight);
		getShippingTypeForProduct(syPr, product);
		getCounteryTaxToProduct(syPr, product);
	}

	public static void getShippingTypeForProduct(SystemProduct syPr, SoldThroughWebsite product) {
		ArrayList<String> shippingType = new ArrayList<>();
		int i = 1;
		for (Shipping shipping : syPr.getShippingWithCompanyDeliverySet())
			if (!shippingType.contains(shipping.getName())) {
				shippingType.add(shipping.getName());
				System.out.println(i + ") " + shipping.getName());
				i++;
			}
		int choose = 0, count = i - 1;
		do {
			if (count > 0) {
				do {
					System.out.println(
							"Enter the number of the shipping type you want to add: (enter number between 1 to "
									+ (i - 1) + "), or 0 to stop");
					choose = input.nextInt();
				} while (choose < 0 || choose >= i);
				if (choose > 0) {
					if (product.getShippingSet().add(shippingType.get(choose - 1))) {
						System.out.println("This type added successfully");
						count--;
					} else
						System.out.println("Can not add this shipping type");
				}
			}
		} while (choose != 0 && count != 0);
	}

	public static boolean getCounteryTaxToProduct(SystemProduct syPr, SoldThroughWebsite product) {
		syPr.printAllCountryTax();
		if (syPr.getCountryTaxSet().size() > 0) {
			int countryNum = Halper.chooseObject(syPr, syPr.getCountryTaxSet().size());
			product.SetDestCountry(Halper.getObjectFromSet(syPr.getCountryTaxSet(), countryNum));
			return true;
		}
		return false;
	}

	public static boolean addNewCountryTax(SystemProduct syPr) {
		CountryTax coT = CountryTaxFactory.create();
		System.out.println("New countryTax:\nPlease enter the name:");
		String newString = Halper.getNewString();
		coT.setDestCountry(newString);
		return syPr.getCountryTaxSet().add(coT);
	}

	public static boolean deleteProduct(SystemProduct syPr) {
		syPr.printAllProduct();
		if (syPr.getProductSet().size() > 0) {
			int productNum = Halper.chooseObject(syPr, syPr.getProductSet().size());
			return syPr.getProductSet().remove(Halper.getObjectFromSet(syPr.getProductSet(), productNum));
		}
		return false;
	}

	public static boolean changeStock(SystemProduct syPr) {
		syPr.printAllProduct();
		if (syPr.getProductSet().size() > 0) {
			int productNum = Halper.chooseObject(syPr, syPr.getProductSet().size());
			int newStock = Halper.getPositiveNum("Please enter the new stock:");
			Halper.getObjectFromSet(syPr.getProductSet(), productNum).setStock(newStock);
			return true;
		}
		return false;
	}

	public static ArrayList<Product> printProductbyType(SystemProduct syPr, int type) {
		ArrayList<Product> productArray = null;
		switch (type) {
		case 1:
			productArray = syPr.printProductByType("SoldThroughWebsite");
			break;
		case 2:
			productArray = syPr.printProductByType("SoldInStore");
			break;
		case 3:
			productArray = syPr.printProductByType("SoldToWholesalers");
			break;
		}
		return productArray;
	}

	public static void getInoviceAndShipping(SystemProduct syPr, Order order, int type, Product product) {
		Invoice invoice;
		switch (type) {
		case 1:
			SoldThroughWebsite pro = (SoldThroughWebsite) product;
			order.setShipping(checkShippingFee(syPr, pro, order));
			break;
		case 2:
			invoice = AbstractFactoryInovice.createInovice(1);
			order.getInvoiceSet().add(invoice);
			invoice.setOrder(order);
			System.out.println(invoice.toString());
		case 3:
			invoice = AbstractFactoryInovice.createInovice(2);
			order.getInvoiceSet().add(invoice);
			invoice.setOrder(order);
			System.out.println(invoice.toString());
			break;
		}
	}

	public static boolean addOrder(SystemProduct syPr) {
		if (syPr.getProductSet().size() > 0) {
			Order order = OrderFactory.create();
			int type = chooseTypeProduct(syPr);
			ArrayList<Product> productArray = printProductbyType(syPr, type);
			int place = Halper.chooseObject(syPr, productArray.size());
			Product product = productArray.get(place - 1);
			if (product.getStock() == 0) {
				System.out.println("The stock of this product equals to zero\nTherefore, the order cannot be made");
				return false;
			}

			System.out.println("Please enter the serial number of the order:");
			order.setSerialNumber(Halper.getNewString());

			int amount = Halper.getPositiveNum("Please enter the amount:");
			if (product.getStock() < amount) {
				System.out.println("Not enough in stock.");
				return false;
			}

			order.setProduct(product);
			order.setAmount(amount);
			product.reduceStock(amount);

			Customer customer = addCustomer(syPr);
			order.setCustomer(customer);

			getInoviceAndShipping(syPr, order, type, product);

			return product.getOrderSet().add(order) && syPr.getAllOrderStack().add(order);
		}
		System.out.println("There is no product.");
		return false;
	}

	public static Customer addCustomer(SystemProduct syPr) {
		Customer customer = CustomerFactory.create();
		System.out.println("Customer:\nPlease enter name:");
		String newString = Halper.getNewString();
		customer.setCustomerName(newString);
		System.out.println("Please enter mobile:");
		newString = Halper.getNewString();
		customer.setMobile(newString);
		return customer;
	}

	public static Shipping checkShippingFee(SystemProduct syPr, SoldThroughWebsite product, Order order) {
		String shipping = chooseTypeShipping(syPr, product);
		syPr.newOrder();
		if (shipping.equals("Standard Shipping"))
			System.out.println("The system does not handle taxation on standart shipping, you have to handle it.");
		Iterator<?> it = syPr.getShippingWithCompanyDeliverySet().iterator();
		Shipping shippingWithCompanyDelivery, shippingWithCompanyDeliveryMinFee = null;
		double minFee = -1, fee;
		while (it.hasNext()) {
			shippingWithCompanyDelivery = (Shipping) it.next();
			if (shippingWithCompanyDelivery.getName().equals(shipping)) {
				fee = shippingWithCompanyDelivery.shippingFees(order);
				if (minFee == -1) {
					shippingWithCompanyDeliveryMinFee = shippingWithCompanyDelivery;
					minFee = fee;
				}
				if (minFee > fee) {
					shippingWithCompanyDeliveryMinFee = shippingWithCompanyDelivery;
					minFee = fee;
				}
			}
		}
		if (shippingWithCompanyDeliveryMinFee == null)
			return null;
		System.out.println(shippingWithCompanyDeliveryMinFee.toString());
		return shippingWithCompanyDeliveryMinFee;
	}

	public static boolean undoOrder(SystemProduct syPr) {
		OrderUpdateCommad orderUpdateCommad = OrderUpdateCommad.getOrderUpdateCommad(syPr);
		Order order = orderUpdateCommad.undoOrder();
		if (order != null) {
			System.out.println("Hello " + order.getCustomer().getCustomerName() + ", your order:\n"
					+ order.toStringProductForCustomer()
					+ "\nCanceled at the initiative of the store due to a problem in the warehouse");
			return true;
		}
		System.out.println("There is no order.");
		return false;
	}

	public static boolean printProductBySerialNumber(SystemProduct syPr) {
		System.out.println("Please enter serial number:");
		String serialNumber = Halper.getNewString();
		for (Product product : syPr.getProductSet())
			if (product.getSerialNumber().equals(serialNumber)) {
				System.out.println(product.allInfoProduct());
				return true;
			}
		System.out.println("The product did not found in the system");
		return false;
	}

	public static void printAllInfoAllSystemProduct(SystemProduct syPr) {
		String str = syPr.toString();
		if (str != null)
			System.out.println(str);
		else
			System.out.println("There is no product. profit equal 0.\n");
	}

	public static void printAllOrderOfProduct(SystemProduct syPr) {
		syPr.printAllProduct();
		int num = Halper.chooseObject(syPr, syPr.getProductSet().size());
		Product product = Halper.getObjectFromSet(syPr.getProductSet(), num);
		System.out.println(product.infoAllOrderInProduct());
	}

	public static boolean saveSystem(SystemProduct syPr) {
		return stack.add(syPr.createMomento());
	}

	public static boolean restoreSystem(SystemProduct syPr) {
		if (stack.size() != 0) {
			syPr.setMomento(stack.pop());
			return true;
		}
		System.out.println("There is no restore.");
		return false;
	}
}