package id_326295417;

public class CountryTaxFactory implements Factorable {
	public static CountryTax create() {
		return new CountryTax();
	}

	public static CountryTax create(String destCountry) {
		return new CountryTax(destCountry);
	}

	public static CountryTax createCopy(CountryTax countryTax) {
		return new CountryTax(countryTax);
	}
}
