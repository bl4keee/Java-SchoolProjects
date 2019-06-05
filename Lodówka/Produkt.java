public class Produkt implements Comparable {
	private String nazwa;
	private double ilosc;
	private int ileMaDni;
	
	public Produkt( String n, double il, int ile) {
		nazwa = n;
		ilosc = il;
		ileMaDni = ile;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getIlosc() {
		return ilosc;
	}

	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}

	public int getIleMaDni() {
		return ileMaDni;
	}

	public void setIleMaDni(int ileMaDni) {
		this.ileMaDni = ileMaDni;
	}
	
	public String toString() {
		return getNazwa()+" ("+ getIlosc() + ") ["+getIleMaDni()+"]";
	}
	
	public int compareTo(Object o) {
		Produkt p = (Produkt) o;
		return this.getNazwa().compareTo(p.getNazwa());
	}
	
}