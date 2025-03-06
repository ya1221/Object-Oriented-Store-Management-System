package id_326295417;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Halper {
	private static Scanner input = new Scanner(System.in);

	public static String getNewString() {
		String newString;
		do {
			newString = input.nextLine();
		} while (newString.isEmpty());
		return newString;
	}

	public static int getPositiveNum(String mes) {
		int num;
		do {
			System.out.println(mes + " (from 0 up - example: 5)");
			num = input.nextInt();
		} while (num < 0);
		return num;
	}

	public static int chooseObject(SystemProduct syPr, int max) {
		int productNum;
		do {
			System.out.println("Please choose from the list:");
			productNum = input.nextInt();
		} while (productNum < 1 || productNum > max);
		return productNum;
	}

	public static <T> T getObjectFromSet(Set<T> set, int num) {
		Iterator<?> it = set.iterator();
		T object = (T) it.next();
		for (int i = 1; i < num; i++)
			object = (T) it.next();
		return object;
	}
}
