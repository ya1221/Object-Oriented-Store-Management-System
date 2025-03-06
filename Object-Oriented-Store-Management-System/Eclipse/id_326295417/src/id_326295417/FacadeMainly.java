package id_326295417;

import java.util.Scanner;

public class FacadeMainly {
	private static Scanner input = new Scanner(System.in);

	public static void firstManu() {
		int numFun;
		boolean work = true;
		SystemProduct s1 = SystemProduct.getSystemProduct();
		do {
			System.out.println(
					"Enter the number of the function you want to perform." + "\n1 - Get data" + "\n2 - Add product"
							+ "\n3 - Remove product" + "\n4 - Update stock of product" + "\n5 - Add order to product"
							+ "\n6 - Remove the last order" + "\n7 - Print all informatiom of product by serial number"
							+ "\n8 - Print all product in the system" + "\n9 - Print only order of product"
							+ "\n10 - Save system" + "\n11 - Restore the system" + "\n0 - Exit");
			numFun = input.nextInt();
			switch (numFun) {
			case 1:
				getDate(s1);
				break;
			case 2:
				work = FacadeSystemProduct.addNewPruduct(s1);
				break;
			case 3:
				work = FacadeSystemProduct.deleteProduct(s1);
				break;
			case 4:
				work = FacadeSystemProduct.changeStock(s1);
				break;
			case 5:
				work = FacadeSystemProduct.addOrder(s1);
				break;
			case 6:
				work = FacadeSystemProduct.undoOrder(s1);
				break;
			case 7:
				work = FacadeSystemProduct.printProductBySerialNumber(s1);
				break;
			case 8:
				FacadeSystemProduct.printAllInfoAllSystemProduct(s1);
				break;
			case 9:
				FacadeSystemProduct.printAllOrderOfProduct(s1);
				break;
			case 10:
				work = FacadeSystemProduct.saveSystem(s1);
				break;
			case 11:
				work = FacadeSystemProduct.restoreSystem(s1);
				break;
			case 0:
				System.out.println("Thank you, good day!");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			if (numFun != 0) {
				if (work)
					System.out.println("\nThe function work!\n");
				else
					System.out.println("\nThe function not work!\n");
			}
		} while (numFun != 0);
	}

	public static void getDate(SystemProduct syPr) {
		CountryTax couT1 = CountryTaxFactory.create("UK");
		CountryTax couT2 = CountryTaxFactory.create("USA");
		couT2.setImportTax(30);
		CountryTax couT3 = CountryTaxFactory.create("Spain");
		couT3.setImportTax(10);

		syPr.getCountryTaxSet().add(couT1);
		syPr.getCountryTaxSet().add(couT2);
		syPr.getCountryTaxSet().add(couT3);

		Customer customer1 = CustomerFactory.create("Amir Cohen", "0505738459");
		Customer customer2 = CustomerFactory.create("Maor Shalev", "0545937495");
		Customer customer3 = CustomerFactory.create("Yossi Levi", "0502958839");
		Customer customer4 = CustomerFactory.create("Romi Natan", "0548226643");
		Customer customer5 = CustomerFactory.create("Haim Ben Shimon", "0502192264");
		Customer customer6 = CustomerFactory.create("Shalon Ben Zeev", "0503872277");
		Customer customer7 = CustomerFactory.create("Reuven Zehavi", "0549008544");
		Customer customer8 = CustomerFactory.create("Stav Yefet", "0501298845");
		Customer customer9 = CustomerFactory.create("Hagit Ashcenzi", "0503385572");

		Product pInStore1 = SoldInStoreFactory.create("777888999", "Table", 10, 15, 20);
		Product pInStore2 = SoldInStoreFactory.create("444555666", "Refrigerator", 20, 30, 15);
		Product pInStore3 = SoldInStoreFactory.create("111222333", "Cheir", 5, 15, 10);

		Order order = OrderFactory.create("111111111", pInStore1, customer1, 1, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore1.getOrderSet().add(order);
		order = OrderFactory.create("222222222", pInStore1, customer1, 2, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore1.getOrderSet().add(order);
		order = OrderFactory.create("333333333", pInStore1, customer1, 3, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore1.getOrderSet().add(order);
		order = OrderFactory.create("444444444", pInStore2, customer2, 4, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore2.getOrderSet().add(order);
		order = OrderFactory.create("555555555", pInStore2, customer2, 5, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore2.getOrderSet().add(order);
		order = OrderFactory.create("666666666", pInStore2, customer2, 6, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore2.getOrderSet().add(order);
		order = OrderFactory.create("777777777", pInStore3, customer3, 7, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore3.getOrderSet().add(order);
		order = OrderFactory.create("888888888", pInStore3, customer3, 8, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore3.getOrderSet().add(order);
		order = OrderFactory.create("999999999", pInStore3, customer3, 9, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		order.getInvoiceSet().add(FormatForCustomerFactory.create(order));
		pInStore3.getOrderSet().add(order);

		Product pWeb1 = SoldThroughWebsiteFactory.create("123456789", "Cabinet", 22, 25, 4, 18.3, couT1);
		Product pWeb2 = SoldThroughWebsiteFactory.create("111444555", "Bed", 35, 45, 20, 25, couT2);
		Product pWeb3 = SoldThroughWebsiteFactory.create("333333344", "Glasses", 3, 8, 10, 20, couT3);

		SoldThroughWebsite pW1 = (SoldThroughWebsite) pWeb1;
		pW1.getShippingSet().add("Express Shipping");
		pW1.getShippingSet().add("Standard Shipping");
		SoldThroughWebsite pW2 = (SoldThroughWebsite) pWeb2;
		pW2.getShippingSet().add("Express Shipping");
		SoldThroughWebsite pW3 = (SoldThroughWebsite) pWeb3;
		pW3.getShippingSet().add("Standard Shipping");

		DeliveryCompany dhl = DHL.getDHL("Liad Hersog", "0507692285");
		DeliveryCompany fedEx = FedEx.getFedEx("Dana Meir", "0509387421");

		syPr.getNotify().addListener(dhl);
		syPr.getNotify().addListener(fedEx);

		Shipping ExDHL = ExpressDHL.getExpressDHL("Express Shipping", dhl);
		Shipping StDHL = StandardDHL.getStandardDHL("Standard Shipping", fedEx);
		Shipping ExFedEx = ExpressFedEx.getExpressFedEx("Express Shipping", dhl);
		Shipping StFedEx = StandardFedEx.getStandardFedEx("Standard Shipping", fedEx);

		syPr.getShippingWithCompanyDeliverySet().add(ExDHL);
		syPr.getShippingWithCompanyDeliverySet().add(StDHL);
		syPr.getShippingWithCompanyDeliverySet().add(ExFedEx);
		syPr.getShippingWithCompanyDeliverySet().add(StFedEx);

		order = OrderFactory.create("111112222", pWeb1, customer4, 1, ExDHL);
		pWeb1.getOrderSet().add(order);
		order = OrderFactory.create("222223333", pWeb1, customer4, 2, StDHL);
		pWeb1.getOrderSet().add(order);
		order = OrderFactory.create("333334444", pWeb1, customer4, 3, ExFedEx);
		pWeb1.getOrderSet().add(order);
		order = OrderFactory.create("444445555", pWeb2, customer5, 4, StFedEx);
		pWeb2.getOrderSet().add(order);
		order = OrderFactory.create("555556666", pWeb2, customer5, 5, ExDHL);
		pWeb2.getOrderSet().add(order);
		order = OrderFactory.create("666667777", pWeb2, customer5, 6, StDHL);
		pWeb2.getOrderSet().add(order);
		order = OrderFactory.create("777778888", pWeb3, customer6, 7, ExFedEx);
		pWeb3.getOrderSet().add(order);
		order = OrderFactory.create("888889999", pWeb3, customer6, 8, StFedEx);
		pWeb3.getOrderSet().add(order);
		order = OrderFactory.create("999990000", pWeb3, customer6, 9, ExDHL);
		pWeb3.getOrderSet().add(order);

		Product pWhol1 = SoldToWholesalersFactory.create("444444444", "Hat", 2, 6, 22);
		Product pWhol2 = SoldToWholesalersFactory.create("222555888", "Computer", 12, 20, 8);
		Product pWhol3 = SoldToWholesalersFactory.create("999999900", "Shoe", 8, 12, 8);

		order = OrderFactory.create("111112222", pWhol1, customer7, 1, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol1.getOrderSet().add(order);
		order = OrderFactory.create("222223333", pWhol1, customer7, 2, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol1.getOrderSet().add(order);
		order = OrderFactory.create("333334444", pWhol1, customer7, 3, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol1.getOrderSet().add(order);
		order = OrderFactory.create("444445555", pWhol2, customer8, 4, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol2.getOrderSet().add(order);
		order = OrderFactory.create("555556666", pWhol2, customer8, 5, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol2.getOrderSet().add(order);
		order = OrderFactory.create("666667777", pWhol2, customer8, 6, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol2.getOrderSet().add(order);
		order = OrderFactory.create("777778888", pWhol3, customer9, 7, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol3.getOrderSet().add(order);
		order = OrderFactory.create("888889999", pWhol3, customer9, 8, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol3.getOrderSet().add(order);
		order = OrderFactory.create("999990000", pWhol3, customer9, 9, null);
		order.getInvoiceSet().add(FormatForAccountantFactory.create(order));
		pWhol3.getOrderSet().add(order);

		syPr.getProductSet().add(pInStore1);
		syPr.getProductSet().add(pInStore2);
		syPr.getProductSet().add(pInStore3);
		syPr.getProductSet().add(pWeb1);
		syPr.getProductSet().add(pWeb2);
		syPr.getProductSet().add(pWeb3);
		syPr.getProductSet().add(pWhol1);
		syPr.getProductSet().add(pWhol2);
		syPr.getProductSet().add(pWhol3);
	}
}
