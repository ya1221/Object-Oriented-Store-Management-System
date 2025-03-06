package id_326295417;

import java.util.Objects;

public class CountryTax {
	private String dest_countery;
	private float import_tax;

	public CountryTax() {
		this.dest_countery = null;
		this.import_tax = 20;
	}

	public CountryTax(String destCountry) {
		this.dest_countery = destCountry;
		this.import_tax = 20;
	}

	public CountryTax(CountryTax countryTax) {
		this.dest_countery = countryTax.dest_countery;
		this.import_tax = 20;
	}

	public float getImportTax() {
		return import_tax;
	}

	public void setDestCountry(String destCountry) {
		this.dest_countery = destCountry;
	}

	public void setImportTax(float importTax) {
		this.import_tax = importTax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.dest_countery);
	}

	public boolean equals(Object other) {
		if (!(other instanceof CountryTax))
			return false;
		CountryTax couT = (CountryTax) other;
		return this.dest_countery.equals(couT.dest_countery);
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Dest Country: " + this.dest_countery + ", import tax: " + this.import_tax);
		return res.toString();
	}
}
